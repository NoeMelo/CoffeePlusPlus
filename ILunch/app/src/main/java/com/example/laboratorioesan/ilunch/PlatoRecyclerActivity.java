package com.example.laboratorioesan.ilunch;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class PlatoRecyclerActivity extends Activity {
    RecyclerView rvLista2;
    List<Plato> listaPlatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plato_recycler); ///nkurbfvurh
        rvLista2 = (RecyclerView) findViewById(R.id.rvLista2);

        LinearLayoutManager lm = new LinearLayoutManager(this);
        rvLista2.setLayoutManager(lm);
        rvLista2.setHasFixedSize(true);

        this.CargarData();
        this.CargarAdapter();
    }

    private void CargarData() {
        listaPlatos = new ArrayList<>();
        listaPlatos.add(new Plato("Arroz con Pollo","Plato de Fondo","Delicioso plato criollo con arroz al culantro y pollo",  R.drawable.arrozconpollo));
        listaPlatos.add(new Plato("Bisteck a lo pobre","Plato de Fondo","Bisteck de res frito con papas, huevo y todas las cremas",  R.drawable.bisteckpobre));
        listaPlatos.add(new Plato("Pollo al Vino","Plato de Fondo","Guiso horneado con Vino de Ica acompañado de papas",  R.drawable.polloalvino));
        listaPlatos.add(new Plato("Crema a la Huancaina","Entrada","Papas, huevo, aceituna y crema de ají peruano",  R.drawable.papahuancayna));
        listaPlatos.add(new Plato("Ensalada fresca","Entrada","Ensalada mixta de verduras frescas",  R.drawable.ensaladafresca));
        listaPlatos.add(new Plato("Sopa de Pollo","Entrada","Sopa de pollo con verduras y fideito",  R.drawable.sopacasera));

    }

    private void CargarAdapter() {
        RVAdapterPlato adapter = new RVAdapterPlato(listaPlatos);///AYUDAAAAAAA
        rvLista2.setAdapter(adapter);
    }

    public void Reservado(View view) {
        Button but = (Button)findViewById(R.id.btnCarrito);
        but.setBackgroundColor(Color.GREEN);

    }
/*
    public void verMe(View view) {
        Intent intent = new Intent(this,RecyclerActivity.class);
        startActivity(intent);

    }*/
}
