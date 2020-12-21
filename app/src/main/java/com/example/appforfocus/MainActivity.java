package com.example.appforfocus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.example.appforfocus.api.NetworkService;
import com.example.appforfocus.database.ValutesDatabase;
import com.example.appforfocus.database.ValutesViewModel;
import com.example.appforfocus.focus.CurrencyResponce;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PostAdapter adapter;
    private TextView textViewInfo;
    private ValutesViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewInfo = findViewById(R.id.textViewInfo);
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new PostAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ValutesViewModel.class);
        showData();

    }

    public void UploadInfo(View view) {
        showData();
    }

    private void showData() {
        viewModel.getValutes().observe(this, new Observer<List<Valutes>>() {
            @Override
            public void onChanged(List<Valutes> valutes) {
                adapter.setResponces(valutes);
            }
        });
        viewModel.loadData();
    }
}
