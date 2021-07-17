package com.example.mobprob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InsertData extends AppCompatActivity {

    DataHelper sqlHelpers;
    Button tambah;
    EditText nama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);

        tambah = (Button) findViewById(R.id.tambah);
        nama = (EditText) findViewById(R.id.nama_startup);

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlHelpers = new DataHelper(InsertData.this);
                sqlHelpers.addData(new Startup(nama.getText().toString()));
                startActivity(new Intent(InsertData.this, MainMenu.class));
            }
        });
    }
}
