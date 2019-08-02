package com.example.rehab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

public class Contador extends AppCompatActivity {
    private Button contador;
    private boolean timing;
    private Chronometer chronometer;
    private Button reset;
    private TextView conteo;
    private TextView clickpmin;
    private Button pausa;
    public int clicks;
    private long pauseoff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador);

        chronometer= findViewById(R.id.cronos);
        chronometer.setBase(SystemClock.elapsedRealtime());
        contador= findViewById(R.id.btn_contador);
        reset = findViewById(R.id.reset);
        conteo= findViewById(R.id.conteo);
        pausa = findViewById(R.id.pausa);
        conteo.setText("");
        clickpmin=findViewById(R.id.clickpmin);
        clickpmin.setText("Clicks en 0"+" minuto(s): "+clicks);

        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {

                int t=60000;
                int v=1;

                for(int i=0; i<10; i++){

                    long x = (SystemClock.elapsedRealtime() - chronometer.getBase());

                    if( x >= t ){

                        clickpmin.setText("Clicks en "+v+" minuto(s): "+clicks);
                        //Toast.makeText(Contador.this, "Clicks en "+ v + "minuto(s): "+ clicks, Toast.LENGTH_LONG).show();
                    }
                    t+=60000;
                    v++;



                }
            }
        });

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

    private void getClicks(){

    }
}
