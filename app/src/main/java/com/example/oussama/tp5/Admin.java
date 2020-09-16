package com.example.example.tp5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Admin extends AppCompatActivity {

    DataBase db = null;
    EditText auteur;
    EditText titre;
    EditText motcle;
    EditText resume;
    EditText chrch;
    EditText supp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        db = new DataBase(this);
        auteur = (EditText)findViewById(R.id.editText9) ;
        titre = (EditText)findViewById(R.id.editText10);
        motcle = (EditText)findViewById(R.id.editText11);
        resume = (EditText)findViewById(R.id.editText12);
        chrch =(EditText)findViewById(R.id.editText13);
        supp=(EditText)findViewById(R.id.editText14);
    }
    public void click5(View view) {
        db.InsererLivre(auteur.getText().toString(),titre.getText().toString(),motcle.getText().toString(),resume.getText().toString());
    }
    public void cherche(View view) {
        Intent myintent1111 = new Intent(this,Chrch.class) ;


        startActivity(myintent1111);
    }

    public void supplivre(View view) {
        db.delete(supp.getText().toString());
    }
    public void liv(View view) {
        Intent myintent111 = new Intent(this,Main2Activity.class) ;


        startActivity(myintent111);
    }
}
