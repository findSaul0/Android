package com.example.fasulo_antonio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button mossa;
    Button doppio;
    Button nuova;
    EditText giocatore;
    TextView app;
    TextView tvGiocatore;
    TextView tvApp;
    TextView pari;
    TextView totali;

    private int counterGiocatore = 0;
    private int counterApp = 0;
    private int counterPari = 0;
    private int counterTotali = 0;

    private final int FORBICI = 0;
    private final int SASSO = 1;
    private final int CARTA = 2;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);

        tvGiocatore = findViewById(R.id.tvGiocatore);
        tvApp = findViewById(R.id.tvApp);
        pari = findViewById(R.id.tvPari);
        totali = findViewById(R.id.tvTotali);
        giocatore = findViewById(R.id.mossaGiocatore);
        app = findViewById(R.id.mossaApp);
        mossa = findViewById(R.id.buttonMossa);
        nuova = findViewById(R.id.buttonNuova);
        doppio = findViewById(R.id.buttonDoppio);




        nuova.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.setText("");
                giocatore.setText("");
            }
        });


        int valoreApp = randInt(0,3);
        mossa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.setText(Integer.toString(valoreApp));

                String stringApp = app.getText().toString();
                String stringGiocatore = giocatore.getText().toString();

                int intGiocatore = Integer.parseInt(stringGiocatore);
                int intApp = Integer.parseInt(stringApp);


                //Controlli Giocatore
                if(intGiocatore == SASSO && intApp == FORBICI ){
                    counterGiocatore++;
                    counterTotali++;
                    tvGiocatore.setText("Punteggio giocatore:"+counterGiocatore);
                    totali.setText("Partite totali:"+counterTotali);
                }else if(intGiocatore == FORBICI && intApp == CARTA){
                    counterGiocatore++;
                    counterTotali++;
                    tvGiocatore.setText("Punteggio giocatore:"+counterGiocatore);
                    totali.setText("Partite totali:"+counterTotali);
                }else if(intGiocatore == CARTA && intApp == SASSO){
                    counterGiocatore++;
                    counterTotali++;
                    tvGiocatore.setText("Punteggio giocatore:"+counterGiocatore);
                    totali.setText("Partite totali:"+counterTotali);
                }

                //Controlli App
                if(intApp == SASSO && intGiocatore == FORBICI){
                    counterApp++;
                    counterTotali++;
                    tvApp.setText("Punteggio app:"+counterApp);
                    totali.setText("Partite totali:"+counterTotali);
                }else if(intApp == FORBICI && intGiocatore == CARTA){
                    counterApp++;
                    counterTotali++;
                    tvApp.setText("Punteggio app:"+counterApp);
                    totali.setText("Partite totali:"+counterTotali);
                }else if(intApp == CARTA && intGiocatore == SASSO){
                    counterApp++;
                    counterTotali++;
                    tvApp.setText("Punteggio app:"+counterApp);
                    totali.setText("Partite totali:"+counterTotali);
                }

                //Controlli Parotà
                if(intApp == SASSO && intGiocatore == SASSO){
                    counterTotali++;
                    counterPari++;
                    totali.setText("Partite totali:"+counterTotali);
                    pari.setText("Partite pari:"+counterPari);
                }else if(intApp == FORBICI && intGiocatore == FORBICI){
                    counterTotali++;
                    counterPari++;
                    totali.setText("Partite totali:"+counterTotali);
                    pari.setText("Partite pari:"+counterPari);
                }else if(intApp == CARTA && intGiocatore == CARTA){
                    counterTotali++;
                    counterPari++;
                    totali.setText("Partite totali:"+counterTotali);
                    pari.setText("Partite pari:"+counterPari);
                }
            }
        });


        doppio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.setText(Integer.toString(valoreApp));

                String stringApp = app.getText().toString();
                String stringGiocatore = giocatore.getText().toString();

                int intGiocatore = Integer.parseInt(stringGiocatore);
                int intApp = Integer.parseInt(stringApp);


                //Controlli Giocatore
                if(intGiocatore == SASSO && intApp == FORBICI ){
                    counterGiocatore++;
                    counterTotali++;
                    int doppio = counterGiocatore + 1;
                    tvGiocatore.setText("Punteggio giocatore:"+ doppio);
                    totali.setText("Partite totali:"+counterTotali);
                }else if(intGiocatore == FORBICI && intApp == CARTA){
                    counterGiocatore++;
                    counterTotali++;
                    int doppio = counterGiocatore + 1;
                    tvGiocatore.setText("Punteggio giocatore:"+ doppio);
                    totali.setText("Partite totali:"+counterTotali);
                }else if(intGiocatore == CARTA && intApp == SASSO){
                    counterGiocatore++;
                    counterTotali++;
                    int doppio = counterGiocatore + 1;
                    tvGiocatore.setText("Punteggio giocatore:"+ doppio);
                    totali.setText("Partite totali:"+counterTotali);
                }

                //Controlli App
                if(intApp == SASSO && intGiocatore == FORBICI){
                    counterApp++;
                    counterTotali++;
                    int doppio = counterApp + 1;
                    tvApp.setText("Punteggio app:"+ doppio);
                    totali.setText("Partite totali:"+counterTotali);
                }else if(intApp == FORBICI && intGiocatore == CARTA){
                    counterApp++;
                    counterTotali++;
                    int doppio = counterApp + 1;
                    tvApp.setText("Punteggio app:"+ doppio);
                    totali.setText("Partite totali:"+counterTotali);
                }else if(intApp == CARTA && intGiocatore == SASSO){
                    counterApp++;
                    counterTotali++;
                    int doppio = counterApp + 1;
                    tvApp.setText("Punteggio app:"+ doppio);
                    totali.setText("Partite totali:"+counterTotali);
                }

                //Controlli Parotà
                if(intApp == SASSO && intGiocatore == SASSO){
                    counterTotali++;
                    counterPari++;
                    totali.setText("Partite totali:"+counterTotali);
                    pari.setText("Partite pari:"+counterPari);
                }else if(intApp == FORBICI && intGiocatore == FORBICI){
                    counterTotali++;
                    counterPari++;
                    totali.setText("Partite totali:"+counterTotali);
                    pari.setText("Partite pari:"+counterPari);
                }else if(intApp == CARTA && intGiocatore == CARTA){
                    counterTotali++;
                    counterPari++;
                    totali.setText("Partite totali:"+counterTotali);
                    pari.setText("Partite pari:"+counterPari);
                }
            }
        });

    }
    

    public int randInt(int min, int max){
        Random rand = new Random();
        int randomNum = rand.nextInt((max-min)+1)+min;
        return randomNum;
    }

}