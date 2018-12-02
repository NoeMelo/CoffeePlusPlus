package com.example.laboratorioesan.ilunch;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by lchang on 25/09/17.
 */

public class RestauranteSQLiteHelper extends SQLiteOpenHelper {
//    Restaurante(String nombre,String descripcion,  int fotores, String lat, String lon) {
    //Sentencia SQL para crear la tabla de Usuarios
    private String sqlCreate = "CREATE TABLE Restaurante (nombre TEXT, descripcion TEXT, fotores INTEGER, lat TEXT, lon TEXT)";

    public RestauranteSQLiteHelper(Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version){
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
        Log.i("onUpgrade","BASE DE DATOS");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Restaurante");


        sqLiteDatabase.execSQL(sqlCreate);
    }
}
