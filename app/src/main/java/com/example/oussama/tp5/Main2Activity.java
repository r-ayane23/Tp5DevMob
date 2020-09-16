package com.example.example.tp5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    DataBase db = null;
    ListView ls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        db = new DataBase(this);
        ls = (ListView)findViewById(R.id.listView);
    }
public void afficher1 ( View v) {
    int n = db.compt();
    ArrayList<String> listt = db.getAllrecord();
    ls.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listt));
    Toast.makeText(Main2Activity.this, "" + n, Toast.LENGTH_SHORT).show();
    for (int a = 0; a < n; a++) {
    }
}}
