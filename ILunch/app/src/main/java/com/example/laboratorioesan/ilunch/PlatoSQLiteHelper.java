package com.example.laboratorioesan.ilunch;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class PlatoSQLiteHelper extends SQLiteOpenHelper {

    private String sqlCreate = "CREATE TABLE Plato2 (nombre TEXT,tipo TEXT,descripcion TEXT, fotoplato INTEGER)";

    public PlatoSQLiteHelper(Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version){
        super(context, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Se ejecuta la sentencia SQL de creación de la tabla

        Log.i("onCreate","CREA TABLA");
        sqLiteDatabase.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


        //Se elimina la versión anterior de la tabla
        Log.i("onUpgrade","HA CAMBIADO LA BASE DE DATOS");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Plato2");

        //Se crea la nueva versión de la tabla
        sqLiteDatabase.execSQL(sqlCreate);
    }



}
