package com.example.laboratorioesan.ilunch;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static android.os.Build.ID;

public class normal extends AppCompatActivity {
    private Button btnEN;
    private Button btnFN;
    private Button btnPN;

    private EditText txtDescripcion;
    private EditText txtNombre;
    private Button btnGrabar;
    private SQLiteDatabase db;

    private Spinner spFondos;
    private Spinner spEntradas2;
    private Spinner spPostres;
private ListView lentrada;
    private ListView ltfondo;
    private ListView ltpostre;



    String tipoplato;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        btnEN=(Button)findViewById(R.id.btnEN);
        btnFN=(Button)findViewById(R.id.btnFN);
        lentrada = (ListView)findViewById(R.id.lentrada);
        ltfondo = (ListView)findViewById(R.id.ltfondo);
        ltpostre = (ListView)findViewById(R.id.ltpostre);
        //btnPN=(Button)findViewById(R.id.BTNN);

       // spFondos =(Spinner) findViewById(R.id.spnFondos2);
       // spEntradas2 =(Spinner) findViewById(R.id.spnEntrada2);
       // spPostres =(Spinner) findViewById(R.id.spnPostres);
        final PlatoSQLiteHelper dsdbh = new PlatoSQLiteHelper(this, "DBLunch", null, 1);

        db = dsdbh.getWritableDatabase();

        Cursor c = db.rawQuery("SELECT nombre, tipo, descripcion, fotoplato  FROM Plato2 WHERE tipo = 'Entrada'", null);



        List<Plato> listaa = new ArrayList<>();
        List<Integer> conta = new ArrayList<>();
        Integer cont = 0;
        List<String> nombrecito = new ArrayList<>();

        if (c.moveToFirst()) {
            do {

                listaa.add(new Plato(c.getString(0), c.getString(1), c.getString(2), c.getInt(3)));
                cont = cont +1;
                conta.add(cont);
                nombrecito.add(c.getString(0));
            }while(c.moveToNext());
        }

        PlatoAdapter adaptador = new PlatoAdapter(normal.this, listaa);
        lentrada.setAdapter(adaptador);

        lentrada.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adpterView, View view, int position,
                                    long id) {
                for (int i = 0; i < lentrada.getChildCount(); i++) {
                    if(position == i ){
                        lentrada.getChildAt(i).setBackgroundColor(Color.GREEN);



                    }else{
                        lentrada.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                    }
                }
            }
        });
        //---------------

       Cursor d = db.rawQuery("SELECT nombre, tipo, descripcion, fotoplato  FROM Plato2 WHERE tipo = 'Fondo'", null);



        List<Plato> listu = new ArrayList<>();

        if (d.moveToFirst()) {
            do {

                listu.add(new Plato(d.getString(0), d.getString(1), d.getString(2), d.getInt(3)));

            }while(d.moveToNext());
        }

        PlatoAdapter2 adaptad = new PlatoAdapter2(normal.this, listu);
        ltfondo.setAdapter(adaptad);

        //-------------

        Cursor e = db.rawQuery("SELECT nombre, tipo, descripcion, fotoplato  FROM Plato2 WHERE tipo = 'Postre'", null);



        List<Plato> listi = new ArrayList<>();

        if (e.moveToFirst()) {
            do {

                listi.add(new Plato(e.getString(0), e.getString(1), e.getString(2), e.getInt(3)));

            }while(e.moveToNext());
        }

        PlatoAdapter3 adap = new PlatoAdapter3(normal.this, listi);
        ltpostre.setAdapter(adap);





    }



/*
        final PlatoSQLiteHelper dsdbh =
                new PlatoSQLiteHelper(this, "DBLunch", null, 1);

        db = dsdbh.getWritableDatabase();
        SQLiteDatabase db = dbHelper.getReadableDatabase()
        Cursor cursor = sqLiteDatabase.query(TABLE, allColluns, null, null, null, null, ID +" DESC", "1");

        //Creando Adaptador para GenreSpinner
        genreSpinnerAdapter = new SimpleCursorAdapter(this,android.R.layout.simple_spinner_item,dataSource.getAllGenres(),
                new String[]{DataBaseScript.GenreColumns.NAME_GENRE},
                new int[]{android.R.id.text1},
                SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

        public Cursor getAllGenres(){
            //Seleccionamos todas las filas de la tabla Genres
            return database.rawQuery(
                    "select * from " + DataBaseScript.GENRES_TABLE_NAME, null);
        }*/


/////////////////////////////////////////



       /* Cursor ent = db.rawQuery("SELECT nombre FROM PLATO WHERE tipo = 'Entrada'", null);

        List<String> platos = new ArrayList<>();
        if (ent.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {

                platos.add(new String(ent.getString(0)));

                      } while(ent.moveToNext());
        }

        ArrayList<String> paz1= new   ArrayList<String>(platos);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this
                ,R.array.paz1 // aqui va la lista que se creo en los strings
                ,android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spConvertir.setAdapter(adapter);


        ///////////////////







        ///////
        txtNombre = (EditText)findViewById(R.id.editNombre);

        txtDescripcion = (EditText)findViewById(R.id.editText2);
        spConvertir =(Spinner) findViewById(R.id.spinner);
        btnGrabar =(Button) findViewById(R.id.btnGrabar);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this
                ,R.array.lista_tipo // aqui va la lista que se creo en los strings
                ,android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spConvertir.setAdapter(adapter);
//////*/
}
