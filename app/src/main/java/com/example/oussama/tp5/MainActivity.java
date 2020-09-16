package com.example.example.tp5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DataBase db = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DataBase(this);
    }

    public void click1(View view) {

        String c = "";


        EditText username = (EditText)findViewById(R.id.editText2) ;
        EditText password = (EditText) findViewById(R.id.editText7);
        int res = db.Testt(username.getText().toString(), password.getText().toString());
        if ((username.getText().toString()).equals(c) && (password.getText().toString()).equals(c)) {
            Toast.makeText(MainActivity.this, "Entrez vos identifiants", Toast.LENGTH_SHORT).show();
        } else {
            if ((username.getText().toString()).equals(c) || (password.getText().toString()).equals(c)) {
                if ((username.getText().toString()).equals(c)) {
                    Toast.makeText(MainActivity.this, "Entrez votre nom d'utilisateyur", Toast.LENGTH_SHORT).show();
                }

                if ((password.getText().toString()).equals(c)) {
                    Toast.makeText(MainActivity.this, "Entrez votre mot de passe", Toast.LENGTH_SHORT).show();
                }
            } else {
                if (res == -1)
                    Toast.makeText(MainActivity.this, "Identifiants invalide", Toast.LENGTH_SHORT).show();
                else {
                    Intent myintent11 = new Intent(this, Admin.class);


                    startActivity(myintent11);
                }


            } }}


    public void click(View view)
    {

        Intent myintent1 = new Intent(this,Inscription.class) ;


        startActivity(myintent1);


    }



}
