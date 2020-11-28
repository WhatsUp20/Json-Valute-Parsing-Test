package com.example.appforfocus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.example.appforfocus.focus.CurrencyResponce;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PostAdapter adapter;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new PostAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }

    private void getInfo() {
        NetworkService.getInstance()
                .getAll()
                .getAll()
                .enqueue(new Callback<CurrencyResponce>() {
                    @Override
                    public void onResponse(Call<CurrencyResponce> call, Response<CurrencyResponce> response) {
                        if (response.isSuccessful()) {
                            Collection<Message> messages = response.body().getValute().values();
                            if (messages.equals(Message.class)) {
                                adapter.setResponces((List<Message>) messages);
                            } else
                                Toast.makeText(MainActivity.this, "Ошибка!", Toast.LENGTH_LONG).show();
                             }

                        }

                    @Override
                    public void onFailure(Call<CurrencyResponce> call, Throwable t) {
                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void UploadInfo(View view) {
        getInfo();
    }
}
