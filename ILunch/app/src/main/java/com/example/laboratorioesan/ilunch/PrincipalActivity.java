package com.example.laboratorioesan.ilunch;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PrincipalActivity extends AppCompatActivity {

    private Button btnEntradas;
    private Button btnFondos;
    private Button btnPostres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEntradas = (Button) findViewById(R.id.btnEntradas);
        btnFondos = (Button) findViewById(R.id.btnFondos);
        btnPostres = (Button) findViewById(R.id.btnPostre);


        btnEntradas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction().replace(R.id.contenedor, new EntradaFragment(), "fragment-a");

                EntradaFragment entradaFragment = new EntradaFragment();
                transaction.add(R.id.contenedor, entradaFragment);

                transaction.commit();
            }
        });

        btnFondos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction().replace(R.id.contenedor, new FondosFragment(), "fragment-b");

                FondosFragment fondosFragment = new FondosFragment();
                transaction.add(R.id.contenedor, fondosFragment);

                transaction.commit();
            }
        });

        btnPostres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction().replace(R.id.contenedor, new PostreFragment(), "fragment-b");

                PostreFragment postreFragment = new PostreFragment();
                transaction.add(R.id.contenedor, postreFragment);

                transaction.commit();
            }
        });
    }
}
