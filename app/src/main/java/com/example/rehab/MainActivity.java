package com.example.rehab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private SimpleAdapter sa;
    private ListView lista;
    private TextView fecha;
    private Button next;
    private DatePickerDialog.OnDateSetListener onDateSetListener;
    ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fecha=findViewById(R.id.fecha);
        lista= findViewById(R.id.lista_datos);
        next = findViewById(R.id.next);
        HashMap<String,String> item;

        fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datepicker = new com.example.rehab.DatePicker();
                datepicker.show(getSupportFragmentManager(), "Escoger Fecha");
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mnext();
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

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String fechaseleccionada = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        fecha.setText(fechaseleccionada);
    }

    private String[][] por_tiempo =
            {{"Total Dia: ","210"},
                    {"Promedio por hora"," 48"},
                    {"Por minuto","5"}};

    public void mnext(){
        Intent intent = new Intent(this, Contador.class);

        startActivity(intent);
    }


}
