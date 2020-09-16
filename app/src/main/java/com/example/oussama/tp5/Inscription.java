package com.example.example.tp5;

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

public class Inscription extends AppCompatActivity {

    DataBase db = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        db = new DataBase(this);
    }


    public void  buclick(View view)
    {


        String c = "";
        EditText firstname = (EditText)findViewById(R.id.editText3) ;
        EditText lastname = (EditText)findViewById(R.id.editText4);
        EditText username = (EditText)findViewById(R.id.editText5);
        EditText password = (EditText)findViewById(R.id.editText6);
        EditText phone = (EditText)findViewById(R.id.editText8);
        EditText  confirmerpassword= (EditText)findViewById(R.id.editText);
        DataBase db = new DataBase(this) ;




        if ((firstname.getText().toString()).equals(c) || (lastname.getText().toString()).equals(c) || (username.getText().toString()).equals(c) || (password.getText().toString()).equals(c) || (phone.getText().toString()).equals(c) || (confirmerpassword.getText().toString()).equals(c)) {
            Toast.makeText(Inscription.this, "Tout les chanmps sont obligatoires", Toast.LENGTH_SHORT).show();
        }
        else if (!(firstname.getText().toString().matches("[a-z|A-Z]{3,}")) && (!(firstname.getText().toString()).equals(c))) {
            Toast.makeText(Inscription.this, "Minimum 3 caracteres pour le nom", Toast.LENGTH_SHORT).show();
        }


        else if (!(lastname.getText().toString().matches("[a-z|A-Z]{3,}")) && (!(firstname.getText().toString()).equals(c))) {
            Toast.makeText(Inscription.this, "Minimum 3 caracteres pour le prénom", Toast.LENGTH_SHORT).show();
        }


        else if (!(phone.getText().toString().matches("[0]{1,1}[5|6|7]{1,1}[0-9]{8,8}")) && (!(phone.getText().toString()).equals(c))) {
            Toast.makeText(Inscription.this, "Le numéro de telephone est incorrect", Toast.LENGTH_SHORT).show();

        }






        else if (!(password.getText().toString().matches("[a-z|A-Z|0-9]{5,}")) && (!(firstname.getText().toString()).equals(c))) {
            Toast.makeText(Inscription.this, "Minimum 5 caracteres pour le mdp", Toast.LENGTH_SHORT).show();

        }






        else if(!( confirmerpassword.getText().toString().equals( password.getText().toString() ) )  ) {

            Toast.makeText(Inscription.this, "Mdp non confirmé", Toast.LENGTH_SHORT).show();
        }

        else {
            int ress = db.testuser(username.getText().toString());
            int t = db.testel(Integer.parseInt(phone.getText().toString()));

            if (ress == 1) {

                Toast.makeText(Inscription.this, "Nom d'utilisateur existant", Toast.LENGTH_SHORT).show();
            }
            else if (t == 1) {
                Toast.makeText(Inscription.this, "Num de téléphone existant", Toast.LENGTH_SHORT).show();
            }

            else {
                db.InsertRowAdmin(username.getText().toString(), password.getText().toString(), Integer.parseInt(phone.getText().toString()));

                Toast.makeText(Inscription.this, "Compte crée avec succés", Toast.LENGTH_SHORT).show();

                Intent myintent11 = new Intent(this,MainActivity.class) ;


                startActivity(myintent11);

            } }


    }


}