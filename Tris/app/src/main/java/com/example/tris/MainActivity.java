package com.example.tris;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FrameLayout primaGriglia, secondaGriglia;
    private TrisFragment playerX;
    private TrisFragment playerO;
    private FragmentTransaction ft;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getActionBar().setTitle("SalvatoreAmbrosio - Doppio Tris");

        primaGriglia=findViewById(R.id.primaGriglia);
        secondaGriglia=findViewById(R.id.secondaGriglia);


        fm=getSupportFragmentManager();
        ft=fm.beginTransaction();

        playerX=new TrisFragment("X");
        playerO=new TrisFragment("O");

        playerX.setParentActivity(this);
        playerO.setParentActivity(this);

        ft.add(R.id.primaGriglia,playerX);
        ft.add(R.id.secondaGriglia,playerO);

        ft.commit();



    }

    public void aggiornaDataSet(ArrayList<String> newData){

        playerO.setArray(newData);
        playerX.setArray(newData);

        FragmentTransaction ft=fm.beginTransaction();
        ft.detach(playerO);
        ft.detach(playerX);
        ft.attach(playerX);
        ft.attach(playerO);
        ft.commit();
    }


}