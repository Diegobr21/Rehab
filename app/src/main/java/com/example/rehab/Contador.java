package com.example.rehab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

public class Contador extends AppCompatActivity {
    private Button contador;
    private boolean timing;
    private Chronometer chronometer;
    private Button reset;
    private TextView conteo;
    private Button pausa;
    public int clicks;
    private long pauseoff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador);

        chronometer= findViewById(R.id.cronos);
        contador= findViewById(R.id.btn_contador);
        reset = findViewById(R.id.reset);
        conteo= findViewById(R.id.conteo);
        pausa = findViewById(R.id.pausa);
        conteo.setText("");

        contador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                contar();
                tomartiempo(v);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetearconteo();
                resettiempo(v);
            }
        });

        pausa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pausartiempo(v);
            }
        });

        resetearconteo();
    }

    public void tomartiempo(View v){
        if(!timing){
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseoff);
            chronometer.start();
            timing=true;
        }

    }
    public void pausartiempo(View v){
        if(timing){
            chronometer.stop();
            pauseoff = SystemClock.elapsedRealtime() - chronometer.getBase();
            timing = false;
        }
    }

    public void resettiempo(View v){

        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseoff = 0;
    }
    private void resetearconteo(){
        clicks = 0;
        conteo.setText(clicks + "");
    }

    private void contar(){
        clicks++;
        conteo.setText(clicks + "");
    }
}
