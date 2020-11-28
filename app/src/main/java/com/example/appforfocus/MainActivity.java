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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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
                            Collection<Valutes> valutes = response.body().getValute().values();
                            List<Valutes> list = new ArrayList<>(valutes);
                            adapter.setResponces(list);
                            CurrencyResponce currencyResponces = response.body();
                            String content = "" + currencyResponces.getDate();
                            textView.append(content);

                        }
                    }

                    @Override
                    public void onFailure(Call<CurrencyResponce> call, Throwable t) {
                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void UploadInfo(View view) {
        textView.setText("");
        getInfo();
    }
}
