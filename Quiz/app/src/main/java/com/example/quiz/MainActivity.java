package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    TextView tvNumeroQuesito;
    TextView tvTestoQuesito;
    TextView tvRisposteCorrette;
    TextView tvRisposteValideNonCorrette;
    TextView tvRisposteTotali;

    private Quesito[] arrayQuesiti = new Quesito[]{
            new Quesito("Il risultato di 1+1 = 2?", true),
            new Quesito("La capitale italiana è Venezia?", false),
            new Quesito("Zerid è una città rumena?", true),
            new Quesito("Qualcuno dice che sei un genio?", false),
            new Quesito("5 x 4 = 25 ? ", false),
    };

    private final int NUMERO_QUESITI  = arrayQuesiti.length;
    private boolean[] suggerimento_Visto = new boolean[NUMERO_QUESITI];
    private boolean[] quesiti_risposti  = new boolean[NUMERO_QUESITI];
    private int quesito_corrente = 0 ;
    private int risposte_totali = 0 ;
    private int risposte_corrette = 0 ;
    private int notvalide = 0 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvNumeroQuesito = findViewById(R.id.tvPrimaText);
        tvTestoQuesito = findViewById(R.id.tvSecondaText);
        tvRisposteCorrette = findViewById(R.id.tvTerzaText);
        tvRisposteValideNonCorrette= findViewById(R.id.tvQuartaText);
        tvRisposteTotali= findViewById(R.id.tvQuintaText);

        for(int i = 0; i< NUMERO_QUESITI;i++){
            suggerimento_Visto[i] = false;
        }
        for(int i = 0; i< NUMERO_QUESITI;i++){
            quesiti_risposti[i] = false;
        }

    }

    public void VaiSuggerimento (View v){
        suggerimento_Visto[quesito_corrente] = true;
        Intent i = new Intent(getApplicationContext(),Suggerimento.class);
        i.putExtra("TESTO",arrayQuesiti[quesito_corrente].getTesto());
        i.putExtra("RISPOSTA",arrayQuesiti[quesito_corrente].getRisposta());
        startActivityForResult(i,345);
    }

    private void aggiornaQuesito(){
        tvNumeroQuesito.setText("Domanda numero: "+ quesito_corrente);
        tvTestoQuesito.setText(arrayQuesiti[quesito_corrente].getTesto());
        tvRisposteCorrette.setText("Risposte corrette valide: "+risposte_corrette);
        tvRisposteValideNonCorrette.setText("Risposte corretta non valida: "+ notvalide);
        tvRisposteTotali.setText("Risposte totali: "+risposte_totali);
    }

    public void Precedente (View v){
        quesito_corrente--;
        if(quesito_corrente<0){
            quesito_corrente = NUMERO_QUESITI-1;
        }
        aggiornaQuesito();
    }

    public void Successivo (View v){
        quesito_corrente++;
        quesito_corrente = quesito_corrente % NUMERO_QUESITI;
        aggiornaQuesito();
    }

    //da controllare il perche non aumenta il valore delle risposte valide non corrette
    public void Corretto (View v){
        if(quesiti_risposti[quesito_corrente] == false){
            quesiti_risposti[quesito_corrente] = true;
            risposte_totali++;
            Quesito q = arrayQuesiti[quesito_corrente];
            boolean risposta_corretta = q.getRisposta();
                if (risposta_corretta == true) {
                    if (suggerimento_Visto[quesito_corrente]) {
                        notvalide++;
                    } else {
                        risposte_corrette++;
                    }
                }
        }
        Successivo(null);
    }

    public  void Errato (View v) {
        if(quesiti_risposti[quesito_corrente] == false){
            quesiti_risposti[quesito_corrente] = true;
            risposte_totali++;
            Quesito q = arrayQuesiti[quesito_corrente];
            boolean risposta_corretta = q.getRisposta();
                if (risposta_corretta == false) {
                    if (suggerimento_Visto[quesito_corrente]) {
                        notvalide++;
                    } else {
                        risposte_corrette++;
                    }
                }
        }
        Successivo(null);
    }

    @Override
    public void onActivityResult(int request_code, int result_code, Intent dati) {
        super.onActivityResult(request_code, result_code, dati);
        if (request_code != 345 || request_code != Activity.RESULT_OK || dati == null) return;
        suggerimento_Visto[quesito_corrente] = dati.getBooleanExtra("RISMOS", false);
    }

}