package com.example.appforfocus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appforfocus.database.ValutesDatabase;

public class AddValuteActivity extends AppCompatActivity {

    EditText editTextName;
    ValutesDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_valute);
        editTextName = findViewById(R.id.editTextName);
        database = ValutesDatabase.getInstance(this);

    }

    public void onClickSaveValute(View view) {
        String title = editTextName.getText().toString().trim();
        if (!title.isEmpty()) {
            Valutes valutes = new Valutes(36, "E23", "222", "1", 100, title, 44, 45);
            database.valutesDao().insertValute(valutes);
            backToMain();

        } else {
            Toast.makeText(this, "All fields must be filled", Toast.LENGTH_SHORT).show();
        }

    }

    void backToMain() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}