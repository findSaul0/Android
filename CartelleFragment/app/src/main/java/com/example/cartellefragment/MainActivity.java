package com.example.cartellefragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private final int NUM_CARTELLE = 6;
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

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        for(int i = 0; i<NUM_CARTELLE; i++){
            Fragment cartella = new Cartella();
            ((Cartella) cartella).numeriCartella(nuemri_nelle_cartelle[i]);
            String str_id = String.format("frameCartella%d",i);
            int id = getResources().getIdentifier(str_id,"id",getPackageName());
            ft.add(id,cartella,null);
        }
        ft.commit();
    }
}