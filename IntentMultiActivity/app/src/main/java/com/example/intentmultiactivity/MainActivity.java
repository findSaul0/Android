package com.example.intentmultiactivity;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edit;

    TextView text1, text2;

    Button button1, button2;

    String s1,s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit = findViewById(R.id.editText);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        button1.setText("Activity2");
        button1.setOnClickListener( v -> {
            Intent i = new Intent(getApplicationContext(), Activity2.class);
            i.putExtra("TESTO1", edit.getText().toString());
            i.putExtra("TESTO3", s2);
            startActivity(i);
        });

        button2.setText("Activity3");
        button2.setOnClickListener( v -> {
            Intent i = new Intent(getApplicationContext(), Activity3.class);
            i.putExtra("TESTO1", edit.getText().toString());
            i.putExtra("TESTO2", s1);
            startActivity(i);
        });


        s1 = getIntent().getStringExtra("TESTO2");
        s2 = getIntent().getStringExtra("TESTO3");


        text1.setText(s1);
        text2.setText(s2);

    }
}