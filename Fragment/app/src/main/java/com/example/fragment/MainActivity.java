package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private EditText tvEdit;
    private LinearLayout tvContenitoreCartelle;
   // private final int NUM_CARTELLE = 4;
    public static final int [] [] nuemri_nelle_cartelle={
            {13,21,54,43,67,77,32,90,11,12,46,80,76,44,66},
            {14,21,54,43,67,77,32,90,11,12,46,80,76,44,66},
            {15,21,54,43,67,77,32,90,11,12,46,80,76,44,66},
            {16,21,54,43,67,77,32,90,11,12,46,80,76,44,66},
            {17,21,54,43,67,77,32,90,11,12,46,80,76,44,66},
            {18,21,54,43,67,77,32,90,11,12,46,80,76,44,66},
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvEdit = (EditText) findViewById(R.id.tvEdit);
        tvContenitoreCartelle = (LinearLayout) findViewById(R.id.tvContenitoreCartelle);
    }

    public void Invia_Numero(View v){
        tvContenitoreCartelle.removeAllViews();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        String str = tvEdit.getText().toString();
        int numeoro_cartelle = Integer.parseInt(str);

        for(int i = 0; i< numeoro_cartelle; i++){
            FrameLayout fl = new FrameLayout(this);
            fl.setId(i+1);
            fl.setPadding(10,10,10,10);
            fl.setBackgroundColor(Color.GREEN);
            tvContenitoreCartelle.addView(fl);
        }

        for(int i = 0 ; i<numeoro_cartelle; i++){
            Fragment cartella = new Cartella();
            ((Cartella) cartella).numeriCartella(nuemri_nelle_cartelle[i]);
            int id =i+1;
            ft.add(id,cartella,null);
        }
        ft.commit();
    }


}