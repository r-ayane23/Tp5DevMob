package com.example.example.tp5;

/**
 * Created by example on 16/02/20.
 */
import  android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Button;

import java.util.ArrayList;

public class DataBase extends SQLiteOpenHelper {
    public static String DbName = "mystudent.db ";
    public static final int version = 1;
    private SQLiteDatabase db;

    public DataBase(Context context) {
        super(context, DbName, null, version);


    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS livre ( auteur TEXT , titre TEXT , motcle TEXT , resume TEXT  );");
        db.execSQL("CREATE TABLE IF NOT EXISTS client ( name TEXT , password TEXT , phone INTEGER  );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if EXISTS client");
        db.execSQL("Drop table if EXISTS livre");
        onCreate(db);
    }

    public void InsererLivre(String auteur, String titre, String motcle, String resume) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("auteur", auteur);
        contentValues.put("titre", titre);
        contentValues.put("motcle", motcle);
        contentValues.put("resume", resume);

        db.insert("livre", null, contentValues);


    }

    public int TestLivre(String strNom, String strMdp) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from livre where name='" + strNom + "'and password='" + strMdp + "' ", null);
        int n = -1;
        if (res.moveToFirst())
            n = 1;

        return n;

    }

    public int Recherchelivre(String strlivre) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from livre where titre like  '" + strlivre + "' ", null);
        int n = -1;
        if (res.moveToFirst())
            n = 1;

        return n;

    }
    public int Recherchemot(String strlivre) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from livre where motcle like  '" + strlivre + "' ", null);
        int n = -1;
        if (res.moveToFirst())
            n = 1;

        return n;

    }


    public int RechercheTitre(String strtitre) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from client where phone='" + strtitre + "' ", null);
        int n = -1;
        if (res.moveToFirst())
            n = 1;

        return n;

    }

    public void InsertRowAdmin(String name, String mdp, int tel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("name", name);
        contentValues.put("password", mdp);
        contentValues.put("phone", tel);

        db.insert("client", null, contentValues);


    }

    public int Testt(String strNom, String strMdp) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from client where name='" + strNom + "'and password='" + strMdp + "' ", null);
        int n = -1;
        if (res.moveToFirst())
            n = 1;

        return n;

    }

    public int testuser(String strNom) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from client where name='" + strNom + "' ", null);
        int n = -1;
        if (res.moveToFirst())
            n = 1;

        return n;

    }


    public int testel(int tel) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from client where phone='" + tel + "' ", null);
        int n = -1;
        if (res.moveToFirst())
            n = 1;

        return n;

    }
    public int compt() {
        int n=0;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from livre", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            n++;
            res.moveToNext();
        }
        return n;
    }

    public void delete(String nm) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from livre where titre=" + nm);
    }

    public ArrayList getAllrecord() {
        ArrayList array_List = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from livre", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            array_List.add(("Auteur : ") + res.getString(res.getColumnIndex("auteur")) + "  Titre : " + res.getString(res.getColumnIndex("titre")) + " Mot clé :"+ res.getString(res.getColumnIndex("motcle"))+ "Résumé :" +res.getString(res.getColumnIndex("resume")));
            array_List.add((""));
            res.moveToNext();
        }
return  array_List;

    }
    public ArrayList getAllrecord2(String mot) {
        ArrayList array_List = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from livre where motcle = ' "+mot+ " '", null);
        res.moveToFirst();
        Log.d("test", "getAllrecord2: " + (res.getCount()));
        while (res.isAfterLast() == false) {
            array_List.add(("Auteur : ") + res.getString(res.getColumnIndex("auteur")) + "  Titre : " + res.getString(res.getColumnIndex("titre")) + " Mot clé :"+ res.getString(res.getColumnIndex("motcle"))+ "Résumé :" +res.getString(res.getColumnIndex("resume")));
            array_List.add((""));
            res.moveToNext();
        }
        return  array_List;

    } }



