package com.example.laboratorioesan.ilunch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    private EditText name;
    private EditText contraseña;
    private Button entra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name=(EditText) findViewById(R.id.user);
        contraseña=(EditText)findViewById(R.id.contra);
        entra=(Button)findViewById(R.id.btn_entrar);
        entra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validar(name.getText().toString(),contraseña.getText().toString());
            }
        });

    }
    public   void validar (String usuario,String password){
        if (usuario.equals("Admin")&& password.equals("123456") ){
            Intent intent= new Intent(this,MainActivity.class);
            startActivity(intent);
        } else {
            if (usuario.equals("Mapa") && password.equals("123456")) {
                Intent intent1 = new Intent(this, MapsActivity.class);
                startActivity(intent1);
            }

        }
        }
    }
