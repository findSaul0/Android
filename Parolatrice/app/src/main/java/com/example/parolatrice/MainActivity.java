package com.example.parolatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView memoria, risultato;
    EditText inserimento;

    Button somma,inverti,troncaDestra;
    Button trocaSinistra,raddoppia,memorizza;
    Button plus,clearMemory,clearInsert,clearResult;

    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        memoria = (TextView) findViewById(R.id.memory);
        risultato = (TextView) findViewById(R.id.result);
        inserimento = (EditText) findViewById(R.id.insert);

        somma = (Button) findViewById(R.id.countWord);
        inverti = (Button) findViewById(R.id.orderReverse);
        troncaDestra = (Button) findViewById(R.id.rightTroncation);
        trocaSinistra = (Button) findViewById(R.id.leftTroncation);
        raddoppia = (Button) findViewById(R.id.raddoppia);
        memorizza = (Button) findViewById(R.id.saveInMemory);
        plus = (Button) findViewById(R.id.plus);
        clearInsert =(Button) findViewById(R.id.clearInserisci);
        clearMemory = (Button) findViewById(R.id.clearMemory);
        clearResult = (Button) findViewById(R.id.clearResult);

        clearResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                risultato.setText("");
            }
        });

        somma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = inserimento.getText().toString();
                risultato.setText(Integer.toString(s.length()));
            }
        });

        inverti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = inserimento.getText().toString();
                String reverse = new StringBuffer(s).reverse().toString();
                risultato.setText(reverse);
            }
        });

        troncaDestra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = inserimento.getText().toString();
                int meta = ((s.length())/2);
                String subString = s.substring(0,meta);
                risultato.setText(subString);
            }
        });

        trocaSinistra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = inserimento.getText().toString();
                int meta = ((s.length())/2);
                String subString = s.substring(meta);
                risultato.setText(subString);
            }
        });

        raddoppia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = inserimento.getText().toString();
                String concat = s.concat(s);
                risultato.setText(concat);
            }
        });



        memorizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = risultato.getText().toString();
                memoria.setText(result);
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String d = inserimento.getText().toString();
                String concat = d.concat(result);
                risultato.setText(concat);
            }
        });

        clearMemory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memoria.setText("");
            }
        });

        clearInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inserimento.setText("");
            }
        });

    }

}