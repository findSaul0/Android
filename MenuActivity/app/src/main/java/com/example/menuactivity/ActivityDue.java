package com.example.menuactivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;

public class ActivityDue extends Activity {

    TextView totale, primo,secondo,contorno,frutta;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_due);
        totale = findViewById(R.id.viewTotale);
        primo = findViewById(R.id.viewPrimo);
        secondo = findViewById(R.id.viewSecondo);
        contorno = findViewById(R.id.viewContorno);
        frutta = findViewById(R.id.viewFrutta);

        int uno = getIntent().getExtras().getInt("PRIMO");
        primo.setText(Integer.toString(uno));

        int due = getIntent().getExtras().getInt("SECONDO");
        secondo.setText(Integer.toString(due));

        int tre = getIntent().getExtras().getInt("CONTORNO");
        contorno.setText(Integer.toString(tre));

        int quattro = getIntent().getExtras().getInt("FRUTTA");
        frutta.setText(Integer.toString(quattro));

        int cinque = getIntent().getExtras().getInt("TOTALE");
        totale.setText(Integer.toString(cinque));

    }
}
