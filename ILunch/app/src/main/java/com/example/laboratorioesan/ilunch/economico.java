package com.example.laboratorioesan.ilunch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class economico extends AppCompatActivity {
    private Button btnE;
    private Button btnF;
    private Button btnP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_economico);
        btnE=(Button)findViewById(R.id.btnEE);
        btnF=(Button)findViewById(R.id.btnFE);
        btnP=(Button)findViewById(R.id.btnPE);
        btnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postre_eco();
            }
        });
        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                segundo_eco();
            }
        });
        btnE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entrada_eco();
            }
        });

    }
    private void entrada_eco(){
        Intent intent = new Intent(this, Agregar.class);
        startActivity(intent);
    }
    private void segundo_eco(){
        Intent intent = new Intent(this , Agregar.class);
        startActivity(intent);
    }
    private void postre_eco(){
        Intent intent = new Intent(this, Agregar.class);
        startActivity(intent);
    }
}
