package com.example.datastorage_preference;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private LinearLayout LayoutTextView;
    private ArrayList<TextView> TvScores;
    private TextView tvCounter;
    private int punteggio = 0;
    public int [] punteggi = {0,0,0};
    public String [] names = {"","",""};
    SharedPreferences shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCounter = findViewById(R.id.tvCounter);
        LayoutTextView = findViewById(R.id.LayoutTextView);
        TvScores = new ArrayList<>();
        TvScores.add((TextView) LayoutTextView.getChildAt(0));
        TvScores.add((TextView) LayoutTextView.getChildAt(1));
        TvScores.add((TextView) LayoutTextView.getChildAt(2));

        shared = getSharedPreferences("file",MODE_PRIVATE);
    }


    //Bottono semplici
    public void Decrement (View v){
        if(punteggio>0) {
            punteggio--;
            tvCounter.setText(punteggio+"");
        }
    }

    public void Increment (View v){
        punteggio++;
        tvCounter.setText(punteggio+"");
    }

    public void Reset(View v){
        punteggio = 0;
        tvCounter.setText(punteggio+"");
    }

    //Button Prefernece
    public void Fine (View v){
        if(punteggio > punteggi[2]){
            Intent i = new Intent();
            i.setClass(getApplicationContext(),HighScore.class);
            i.putExtra("SCORE", punteggio);
            startActivity(i);
        }
    }

    //salviamo il nuovo stato dei punteggi e nomi
    @Override
    protected void onResume() {
        super.onResume();
        punteggi[0] = shared.getInt("PUNTEGGI1",0);
        punteggi[1] = shared.getInt("PUNTEGGI2",0);
        punteggi[2] = shared.getInt("PUNTEGGI3",0);

        names[0] = shared.getString("NOME1","FIRTS");
        names[1] = shared.getString("NOME2","SECOND");
        names[2] = shared.getString("NOME3","THIRD");

        int i = 0;
        for(TextView t : TvScores){
            t.setText(names[i]+ ":"+punteggi[i]);
            i++;
        }

        punteggio = shared.getInt("SCORE",punteggio);
        tvCounter.setText(punteggio+"");
    }

    //utilizziamo questa funzione per scrivere sul file i nostri dati
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        SharedPreferences.Editor editor = shared.edit();
        editor.putInt("SCORE",punteggio);
        editor.commit();
    }

    public void ResetHighScore(View v){
        for (int i = 0; i<3; i++){
            punteggi[i] = 0;
        }

        names[0] = "FIRST";
        names[1] = "SECOND";
        names[2] = "THIRD";

        SharedPreferences.Editor editor = shared.edit();
        editor.putInt("PUNTEGGI1",punteggi[0]);
        editor.putInt("PUNTEGGI2",punteggi[1]);
        editor.putInt("PUNTEGGI3",punteggi[2]);
        editor.putString("NOME1", names[0]);
        editor.putString("NOME2", names[1]);
        editor.putString("NOME3", names[2]);
        editor.commit();

        int i = 0;
        for( TextView t : TvScores){
            t.setText(names[i]+":"+punteggi[i]);
            i++;
        }
    }
}