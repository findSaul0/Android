package com.example.datastorage_preference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class HighScore extends AppCompatActivity {

    private EditText Edit;
    private LinearLayout TextTv;
    private ArrayList<TextView> TvScores;
    public int [] punteggi = {0,0,0};
    public String [] names = {"","",""};
    private int punteggio;

    SharedPreferences shared;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        punteggio = getIntent().getIntExtra("SCORE", -1);
        Edit = findViewById(R.id.Edit);
        TextTv = findViewById(R.id.TextTv);
        TvScores = new ArrayList<>();
        TvScores.add((TextView) TextTv.getChildAt(0));
        TvScores.add((TextView) TextTv.getChildAt(1));
        TvScores.add((TextView) TextTv.getChildAt(2));

        shared = getSharedPreferences("file",MODE_PRIVATE);


        punteggi[0] = shared.getInt("PUNTEGGI1",0);
        punteggi[1] = shared.getInt("PUNTEGGI2",0);
        punteggi[2] = shared.getInt("PUNTEGGI3",0);

        names[0] = shared.getString("NOME1","FIRST");
        names[1] = shared.getString("NOME2","SECOND");
        names[2] = shared.getString("NOME3","THIRD");

        int i = 0;
        for(TextView t : TvScores){
            t.setText(names[i]+ " "+punteggi[i]);
            i++;
        }

    }

    public void InsertName(View v){
        String nome = Edit.getText().toString();
        if(punteggio > punteggi[2]){
            if(punteggio > punteggi[1]){
                if(punteggio> punteggi[0]){
                    names[2] = names[1];
                    names[1] = names[0];
                    names[0] = nome;
                    punteggi[2] = punteggi[1];
                    punteggi[1] = punteggi[0];
                    punteggi[0] = punteggio;
                }
                else {
                    names[2] = names[1];
                    names[1] = nome;
                    punteggi[2] = punteggi[1];
                    punteggi[1] = punteggio;
                }
            }
            else{
                names[2] = nome;
                punteggi[2] = punteggio;
            }
        }
        SharedPreferences.Editor editor = shared.edit();
        editor.putInt("PUNTEGGI1",punteggi[0]);
        editor.putInt("PUNTEGGI2",punteggi[1]);
        editor.putInt("PUNTEGGI3",punteggi[2]);
        editor.putString("NOME1",names[0]);
        editor.putString("NOME2",names[1]);
        editor.putString("NOME3",names[2]);
        editor.putInt("SCORE",0);
        editor.commit();
        finish();

    }


}