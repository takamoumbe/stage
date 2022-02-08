package com.example.montp.operations;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.montp.EmploeModel;
import com.example.montp.Registrer;

public class ConnexionBDD extends SQLiteOpenHelper {

    private final Context context;
    SQLiteDatabase bdd;
    public static final String NOM_BDD = "operations";
    public static final  int VERSION_BDD = 1;
    public static final String TABLE_EMP = "employe";
    public static final String ID_EMP = "_id";
    public static final String NOM_EMP = "nom_emp";
    public static final String PASS_EMP = "password";
    public static final String EMAIL_EMP = "email";
    public static final String MATRICULE_EMP = "matricule";
    // requete qui cree la table
    public static final String REQUETE_TABLE_EMP = "CREATE TABLE "+
            TABLE_EMP+ " (" +
            ID_EMP +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NOM_EMP+ " TEXT,"+
            PASS_EMP+ " TEXT,"+
            MATRICULE_EMP+ " TEXT,"+
            EMAIL_EMP+ " TEXT "+ ");";

    public ConnexionBDD(@Nullable Context context) {
        super(context, NOM_BDD, null, VERSION_BDD);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase bdd) {
        //ont execute la requete de creation de notre table
        bdd.execSQL(REQUETE_TABLE_EMP);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        bdd.execSQL("DROP TABLE IF EXISTS "+TABLE_EMP);
        onCreate(bdd);
    }

    @Override
    public void close() {
        bdd.close();
    }

    public void insererEmployer(EmploeModel emp) {
        SQLiteDatabase bdd = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(NOM_EMP,emp.getNom().toLowerCase());
        cv.put(PASS_EMP,emp.getPass().toLowerCase());
        cv.put(EMAIL_EMP,emp.getEmail().toLowerCase());
        cv.put(MATRICULE_EMP,emp.getMatricule().toLowerCase());
        long resultat_insertion = bdd.insert(TABLE_EMP,null,cv);

        if(resultat_insertion == -1){
            Toast.makeText(context, "Echec d`insertion "+emp.getNom().toUpperCase(), Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "L'employer "+emp.getNom().toUpperCase()+" enregistrer avec success", Toast.LENGTH_SHORT).show();
        }

    }

    /*public EmploeModel getDocumentById(String row_id){
        SQLiteDatabase bdd = this.getReadableDatabase();
        Cursor cursor = bdd.query(TABLE_EMP,new String[]{ID_EMP,NOM_EMP,PASS_EMP,MATRICULE_EMP,EMAIL_EMP},ID_EMP + "=?",
                new String[]{String.valueOf(row_id)},null,null,null,null);
        if (cursor != null)
            cursor.moveToFirst();
        assert  cursor != null;
        return  new EmploeModel(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(3)
        );
    }*/
}
