package com.example.laboratorioesan.ilunch;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Platos_Activity extends AppCompatActivity {
    private EditText txtDescripcion;
    private EditText txtNombre;
    private Spinner spiner;
    private Button btnGrabar;
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_platos_);


        txtNombre = (EditText)findViewById(R.id.editNombre);

        txtDescripcion = (EditText)findViewById(R.id.editText2);
        spiner = (Spinner) findViewById(R.id.spinner);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this
                ,R.array.lista_tipo // aqui va la lista que se creo en los strings
                ,android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiner.setAdapter(adapter);



        final PlatoSQLiteHelper dsdbh =
                new PlatoSQLiteHelper(this, "DBLunch", null, 1);

        db = dsdbh.getWritableDatabase();


        btnGrabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Recuperamos los valores de los campos de texto
                String desc = txtDescripcion.getText().toString();
                String nom = txtNombre.getText().toString();
                String spin = spiner.getSelectedItem().toString();

                //Alternativa 1: método sqlExec()
                //String sql = "INSERT INTO Usuarios (codigo,nombre) VALUES ('" + cod + "','" + nom + "') ";
                //db.execSQL(sql);

                //Alternativa 2: método insert()
                ContentValues nuevoRegistro = new ContentValues();
                nuevoRegistro.put("nombre", nom);
                nuevoRegistro.put("tipo", spin);
                nuevoRegistro.put("descripcion", desc);
                nuevoRegistro.put("foto", "sopa.png");
                db.insert("PLATO", null, nuevoRegistro);

                Toast.makeText(Platos_Activity.this, "Valor Insertado", Toast.LENGTH_LONG).show();
            }
        });

       /* btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Recuperamos los valores de los campos de texto
                String cod = txtCodigo.getText().toString();
                String nom = txtNombre.getText().toString();
                String stk = txtStock.getText().toString();

                //Alternativa 1: método sqlExec()
                //String sql = "UPDATE Usuarios SET nombre='" + nom + "' WHERE codigo=" + cod;
                //db.execSQL(sql);

                //Alternativa 2: método update()
                ContentValues valores = new ContentValues();
                valores.put("nombre", nom);
                valores.put("stock", stk);
                db.update("Producto", valores, "codigo=" + cod, null);

                Toast.makeText(PrincipalActivity.this, "Valor Actualizado", Toast.LENGTH_LONG).show();
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Recuperamos los valores de los campos de texto
                String cod = txtCodigo.getText().toString();

                //Alternativa 1: método sqlExec()
                //String sql = "DELETE FROM Usuarios WHERE codigo=" + cod;
                //db.execSQL(sql);

                //Alternativa 2: método delete()
                db.delete("Producto", "codigo=" + cod, null);

                Toast.makeText(PrincipalActivity.this, "Valor Eliminado", Toast.LENGTH_LONG).show();

            }
        });   */


                Cursor c = db.rawQuery("SELECT nombre FROM Plato", null);



                List<String> productos = new ArrayList<>();

                if (c.moveToFirst()) {
                    do {

                        productos.add(c.getString(0));

                    }while(c.moveToNext());
                }




      //  PlatoAdapter adapter = new PlatoAdapter(Platos_Activity.this, productos);
        //ltvValores.setAdapter(adapter);



    }
}
