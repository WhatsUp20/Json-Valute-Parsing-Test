package com.example.appforfocus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
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
    private TextView textViewInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewInfo = findViewById(R.id.textViewInfo);
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
                            final List<Valutes> list = new ArrayList<>(valutes);
                            adapter.setResponces(list);
                            CurrencyResponce currencyResponces = response.body();
                            String date = "Date: " + currencyResponces.getDate();
                            String timestamp = "Timestamp: " + currencyResponces.getTimestamp();
                            textViewInfo.append(date + "\n" + timestamp);

                            ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                                @Override
                                public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                                    return false;
                                }

                                @Override
                                public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                                    list.remove(viewHolder.getAdapterPosition());
                                    adapter.notifyDataSetChanged();
                                }
                            });
                            helper.attachToRecyclerView(recyclerView);
                        }
                    }

                    @Override
                    public void onFailure(Call<CurrencyResponce> call, Throwable t) {
                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void UploadInfo(View view) {
        textViewInfo.setText("");
        getInfo();
    }
}
