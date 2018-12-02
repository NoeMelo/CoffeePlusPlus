package com.example.laboratorioesan.ilunch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private Button btn2;
    private Button agre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);

        agre = (Button)findViewById(R.id.btnNuevoPlato);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregar1();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregar();
            }
        });
        agre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nuevo();
            }
        });
    }

    private void agregar(){
        Intent intent= new Intent(this,economico.class);
        startActivity(intent);
    }
    private void agregar1(){
        Intent intent= new Intent(this,normal.class);
        startActivity(intent);
    }

    private void nuevo(){
        Intent intent= new Intent(this,Agregar.class);
        startActivity(intent);
    }


    }

