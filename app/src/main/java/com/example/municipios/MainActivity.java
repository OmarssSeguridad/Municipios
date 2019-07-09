package com.example.municipios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
        Intent intent;
        String usuario;
        String pass;
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnIng = findViewById(R.id.ingresar);
        btnIng.setOnClickListener(this);
        Button btnClo = findViewById(R.id.salir);
        btnClo.setOnClickListener(this);
        }

public void onClick (View view)
        {


        switch (view.getId()){

        case R.id.ingresar:
        EditText correo = findViewById(R.id.correo);
        EditText contraseña = findViewById(R.id.password);

        String valorCorreo = correo.getText().toString();
        String valorContraseña = contraseña.getText().toString();




        if ((valorCorreo.equals("admin") || valorCorreo.equals("user")&& valorContraseña.equals("123456"))) {
                intent = new Intent(view.getContext(), MenuActivity.class);
                usuario= correo.getText().toString();
                pass= contraseña.getText().toString();
                intent.putExtra("usuario",usuario);
                intent.putExtra("pass",pass);

                startActivity(intent);
                Toast.makeText(this, "¡Bienvenido!", Toast.LENGTH_SHORT).show();
        } else {
                Toast.makeText(this, "Usuario y/o Contraseña incorrecto", Toast.LENGTH_SHORT).show();
        }
        break;
        case R.id.salir:
        Toast.makeText(this, "Adios", Toast.LENGTH_SHORT).show();
        finish();
        break;

        }

        }
        }

