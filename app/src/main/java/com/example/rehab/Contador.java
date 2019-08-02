package com.example.rehab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Contador extends AppCompatActivity {
    private Button contador;
    private Button reset;
    private TextView conteo;
    public int clicks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador);

        contador= findViewById(R.id.btn_contador);
        reset = findViewById(R.id.reset);
        conteo= findViewById(R.id.conteo);
        conteo.setText(clicks);

        contador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                contar();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetear();
            }
        });
    }

    private void resetear(){
        clicks = 0;
        conteo.setText(clicks);
    }

    private void contar(){
        clicks++;
        conteo.setText(clicks);
    }
}
