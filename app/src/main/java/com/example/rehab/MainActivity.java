package com.example.rehab;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private SimpleAdapter sa;
    private ListView lista;
    private TextView fecha;
    private DatePickerDialog.OnDateSetListener onDateSetListener;
    ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fecha=findViewById(R.id.fecha);
        lista= findViewById(R.id.lista_datos);
        HashMap<String,String> item;

        fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

        for(int i=0;i<por_tiempo.length;i++){
            item = new HashMap<String,String>();
            item.put( "line1", por_tiempo[i][0]);
            item.put( "line2", por_tiempo[i][1]);
            list.add( item );
        }

        sa = new SimpleAdapter(this, list,
                R.layout.elementolista,
                new String[] { "line1","line2" },
                new int[] {R.id.texto, R.id.fecha});

        lista.setAdapter(sa);


    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

    }

    private String[][] por_tiempo =
            {{"Total Dia: ","210"},
                    {"Promedio por hora"," 48"},
                    {"Por minuto","5"}};


}
