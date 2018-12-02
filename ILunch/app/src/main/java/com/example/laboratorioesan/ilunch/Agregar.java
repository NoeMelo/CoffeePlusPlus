package com.example.laboratorioesan.ilunch;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Agregar extends AppCompatActivity {
    private EditText txtDescripcion;
    private EditText txtNombre;
    private Button btnGrabar;
    private SQLiteDatabase db;
    private Spinner spConvertir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        txtNombre = (EditText)findViewById(R.id.editNombre);

        txtDescripcion = (EditText)findViewById(R.id.editText2);
        spConvertir =(Spinner) findViewById(R.id.spinner);
        btnGrabar =(Button) findViewById(R.id.btnGrabar);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this
                ,R.array.lista_tipo // aqui va la lista que se creo en los strings
                ,android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spConvertir.setAdapter(adapter);


        final PlatoSQLiteHelper dsdbh =
                new PlatoSQLiteHelper(this, "DBLunch", null, 1);

        db = dsdbh.getWritableDatabase();



        btnGrabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Recuperamos los valores de los campos de texto
                String desc = txtDescripcion.getText().toString();
                String nom = txtNombre.getText().toString();
                String spin = spConvertir.getSelectedItem().toString();

                //Alternativa 1: método sqlExec()
                String sql = "INSERT INTO Plato2 (nombre,tipo,descripcion,fotoplato) VALUES ('" + nom + "','" + spin + "','" + desc + "',1) ";
                db.execSQL(sql);

                //Alternativa 2: método insert()
                /*ContentValues nuevoRegistro = new ContentValues();
                nuevoRegistro.put("nombre", nom);
                nuevoRegistro.put("tipo", spin);
                nuevoRegistro.put("descripcion", desc);
                nuevoRegistro.put("fotoplato", 1);
                db.insert("Plato2", null, nuevoRegistro);
*/


                Toast.makeText(Agregar.this, "Valor Insertado", Toast.LENGTH_LONG).show();
            }
        });







    }
}
