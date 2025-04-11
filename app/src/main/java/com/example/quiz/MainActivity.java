package com.example.quiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edt_nombre, edt_edad;
    Spinner spinner_categorias;
    Button btn_guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_nombre = findViewById(R.id.edt_nombre);
        edt_edad = findViewById(R.id.edt_edad);
        spinner_categorias = findViewById(R.id.spinner_categorias);
        btn_guardar = findViewById(R.id.btn_guardar);

        String[] categorias = {"Deportes", "Música", "Cine"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categorias);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_categorias.setAdapter(adapter);

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = edt_nombre.getText().toString();
                String edad = edt_edad.getText().toString();
                String categoria = spinner_categorias.getSelectedItem().toString();

                SharedPreferences prefs = getSharedPreferences("quiz", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("nombre", nombre);
                editor.putString("edad", edad);
                editor.putString("categoria", categoria);
                editor.apply();

                Intent intent;
                switch (categoria) {
                    case "Deportes":
                        intent = new Intent(MainActivity.this, DeportesActivity.class);
                        break;
                    case "Música":
                        intent = new Intent(MainActivity.this, MusicaActivity.class);
                        break;
                    case "Cine":
                        intent = new Intent(MainActivity.this, CineActivity.class);
                        break;
                    default:
                        intent = new Intent(MainActivity.this, MainActivity.class);
                        break;
                }
                startActivity(intent);
            }
        });
    }
}