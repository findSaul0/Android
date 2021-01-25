package com.example.menuactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioButton primo_uno;
    RadioButton primo_due;
    RadioButton primo_tre;
    RadioButton secondo_uno;
    RadioButton secondo_due;
    RadioButton secondo_tre;
    RadioButton contorno_uno;
    RadioButton contorno_due;
    RadioButton contorno_tre;
    RadioButton frutta_uno;
    RadioButton frutta_due;
    RadioButton frutta_tre;
    TextView totale;
    Button cassa;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        primo_uno = findViewById(R.id.primo_uno);
        primo_due = findViewById(R.id.primo_due);
        primo_tre = findViewById(R.id.primo_tre);
        secondo_uno = findViewById(R.id.secondo_uno);
        secondo_due = findViewById(R.id.secondo_due);
        secondo_tre = findViewById(R.id.secondo_tre);
        contorno_uno = findViewById(R.id.contorno_uno);
        contorno_due = findViewById(R.id.contorno_due);
        contorno_tre = findViewById(R.id.contorno_tre);
        frutta_uno = findViewById(R.id.frutta_uno);
        frutta_due = findViewById(R.id.frutta_due);
        frutta_tre = findViewById(R.id.frutta_tre);
        totale = findViewById(R.id.totale);

        cassa = findViewById(R.id.cassa);
        cassa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ActivityDue.class);
                intent.putExtra("PRIMO",tot1);
                intent.putExtra("SECONDO",tot2);
                intent.putExtra("CONTORNO",tot3);
                intent.putExtra("FRUTTA",tot);
                intent.putExtra("TOTALE",s);
                startActivity(intent);
            }
        });
    }

    private int tot1 = 0;
    private int tot2 = 0;
    private int tot3 = 0;
    private int tot = 0 ;
    private int s;

    public void onRadioButtonClicked(View v) {
        Boolean checked = ((RadioButton) v).isChecked();

        switch (v.getId()) {
            case R.id.primo_uno:
                if (checked) {
                    tot1 = 0;
                    tot1 += 3;
                    break;
                }

            case R.id.primo_due:
                if (checked) {
                    tot1 = 0;
                    tot1 += 5;
                    break;
                }


            case R.id.primo_tre:
                if (checked) {
                    tot1 = 0;
                    tot1 += 7;
                    break;
                }
        }

        switch (v.getId()) {
            case R.id.secondo_uno:
                if (checked) {
                    tot2 = 0;
                    tot2 += 3;
                    break;
                }

            case R.id.secondo_due:
                if (checked) {
                    tot2 = 0;
                    tot2 += 5;
                    break;
                }


            case R.id.secondo_tre:
                if (checked) {
                    tot2 = 0;
                    tot2 += 7;
                    break;
                }

        }

        switch (v.getId()) {
            case R.id.contorno_uno:
                if (checked) {
                    tot3 = 0;
                    tot3 += 3;
                    break;
                }

            case R.id.contorno_due:
                if (checked) {
                    tot3 = 0;
                    tot3 += 5;
                    break;
                }


            case R.id.contorno_tre:
                if (checked) {
                    tot3 = 0;
                    tot3 += 7;
                    break;
                }

        }

        switch (v.getId()) {
            case R.id.frutta_uno:
                if (checked) {
                    tot = 0;
                    tot += 3;
                    break;
                }

            case R.id.frutta_due:
                if (checked) {
                    tot = 0;
                    tot += 5;
                    break;
                }

            case R.id.frutta_tre:
                if (checked) {
                    tot = 0;
                    tot += 7;

                    break;
                }

        }
        s = tot+tot3+tot1+tot2;
        totale.setText(Integer.toString(s));
    }




}