package com.example.example.tp5;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Chrch extends AppCompatActivity {
    DataBase db = null;
    EditText chrch;
    ListView ls2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chrch);
        db = new DataBase(this);
        chrch =(EditText)findViewById(R.id.editText15);
        ls2 = (ListView)findViewById(R.id.listView2);
    }
    public void cherche2(View view) {
        Toast.makeText(Chrch.this, "test", Toast.LENGTH_SHORT).show();
        int res=db.Recherchemot(chrch.getText().toString());
        if ( res == 1 ) {
            Toast.makeText(Chrch.this, "test2", Toast.LENGTH_SHORT).show();
            ArrayList<String> list = db.getAllrecord2(chrch.getText().toString());
            Toast.makeText(Chrch.this, "test3", Toast.LENGTH_SHORT).show();
            ls2.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list));
            Toast.makeText(Chrch.this, "test4", Toast.LENGTH_SHORT).show();

        }
        else  Toast.makeText(Chrch.this, "Livre inexistant", Toast.LENGTH_SHORT).show();

    }
}
