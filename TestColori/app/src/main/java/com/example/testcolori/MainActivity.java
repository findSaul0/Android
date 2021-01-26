package com.example.testcolori;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView numeroquesito,risposte,errate;
    ImageView layout,bianco,rosso,verde,blu,nero,giallo,viola,azzurro;

    private ArrayList<Integer> imageColor = new ArrayList<Integer>();

    private int quessito_corrente = 0;
    private int rispsote_valida = 0;
    private int quesiti_errati = 0;

    ColorDrawable uno,due,tre,quattro,cinque,sei,sette,otto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        errate = (TextView) findViewById(R.id.errate);
        risposte = (TextView) findViewById(R.id.risposte);
        numeroquesito = (TextView) findViewById(R.id.domande);

        layout = (ImageView) findViewById(R.id.singolo);



        bianco = (ImageView) findViewById(R.id.bianco);
        bianco.setBackgroundColor(Color.WHITE);
        uno = (ColorDrawable) bianco.getBackground();

        rosso = (ImageView) findViewById(R.id.rosso);
        rosso.setBackgroundColor(Color.RED);
        due = (ColorDrawable) rosso.getBackground();

        verde = (ImageView) findViewById(R.id.verde);
        verde.setBackgroundColor(Color.GREEN);
        tre = (ColorDrawable) verde.getBackground();

        blu = (ImageView) findViewById(R.id.blu);
        blu.setBackgroundColor(Color.BLUE);
        quattro = (ColorDrawable) blu.getBackground();

        nero = (ImageView) findViewById(R.id.nero);
        nero.setBackgroundColor(Color.BLACK);
        cinque = (ColorDrawable) nero.getBackground();

        giallo = (ImageView) findViewById(R.id.giallo);
        giallo.setBackgroundColor(Color.YELLOW);
        sei = (ColorDrawable) giallo.getBackground();

        viola = (ImageView) findViewById(R.id.viola);
        viola.setBackgroundColor(Color.MAGENTA);
        sette= (ColorDrawable) viola.getBackground();

        azzurro = (ImageView) findViewById(R.id.azzurro);
        azzurro.setBackgroundColor(Color.CYAN);
        otto = (ColorDrawable) azzurro.getBackground();


        imageColor.add(Color.RED);
        imageColor.add(Color.BLUE);
        imageColor.add(Color.MAGENTA);
        imageColor.add(Color.WHITE);
        imageColor.add(Color.CYAN);
        imageColor.add(Color.YELLOW);
        imageColor.add(Color.BLACK);
        imageColor.add(Color.GREEN);

        aggiornaQuesito();

    }

    public void ColorClick(View v){
        ColorDrawable drawable = (ColorDrawable) layout.getBackground();
        ColorDrawable color = (ColorDrawable) v.getBackground();
        if(drawable.getColor() == color.getColor()) {
                rispsote_valida++;
        }else {
            quesiti_errati++;
        }
        quessito_corrente++;
        aggiornaQuesito();
    }

    private void aggiornaQuesito(){
        errate.setText("Rispsote errate:"+quesiti_errati);
        numeroquesito.setText("Domanda n.:"+quessito_corrente+"/10");
        layout.setBackgroundColor(imageColor.get(quessito_corrente));
        risposte.setText("Risposte corrette:"+rispsote_valida);
    }
}