package com.example.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class Suggerimento extends Activity {
    TextView testoQuesito;
    TextView Risposta;
    private String testo;
    private boolean risposta;
    private boolean risposta_mostrata = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggerimento);
        testoQuesito = findViewById(R.id.tvTextUno);
        Risposta = findViewById(R.id.tvTextDue);

        Intent i = getIntent();
        testo = i.getStringExtra("TESTO");
        risposta = i.getBooleanExtra("RISPOSTA",risposta);

        testoQuesito.setText(testo);
        setReturnIntent();
    }

    private void setReturnIntent(){
        Intent dati = new Intent();
        dati.putExtra("RISMOS",risposta_mostrata);
        setResult(RESULT_OK,dati);
    }

    public void MostraRis (View v){
        Risposta.setText(""+risposta);
        risposta_mostrata = true;
        setReturnIntent();
    }

    public void Ritorna(View v){
        onBackPressed();
    }
}
