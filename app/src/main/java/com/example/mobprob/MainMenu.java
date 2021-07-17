package com.example.mobprob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class MainMenu extends AppCompatActivity {

    Button btnAdd;
    ArrayList<Startup> data;
    DataHelper sqlHelpers;
    ListView list;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        sqlHelpers = new DataHelper(MainMenu.this);
        data = new ArrayList<Startup>();
        btnAdd = (Button) findViewById(R.id.add_data);
        spinner = findViewById(R.id.spinner);

        data = sqlHelpers.allData();
        List<String> xdata = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            Startup st = data.get(i);
            String out = st.getNama();
            xdata.add(out);
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                MainMenu.this, android.R.layout.simple_spinner_item, xdata
        );

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(arrayAdapter);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, InsertData.class));
            }
        });

    }
}
