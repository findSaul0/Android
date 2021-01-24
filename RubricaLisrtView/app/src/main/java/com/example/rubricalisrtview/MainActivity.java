package com.example.rubricalisrtview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Contatto> contattoList;
    ListView listView;

    Button button;
    EditText nome;
    EditText cognome;
    EditText numero;
    String nome_bundle;
    String cognome_bundle;
    String numero_bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){
         nome_bundle = savedInstanceState.getString("NOME");
         cognome_bundle = savedInstanceState.getString("COGNOME");
         numero_bundle = savedInstanceState.getString("NUMERO");
        }


        contattoList = new ArrayList<>();
        contattoList.add(new Contatto("Antonio Fasulo","34393832",R.drawable.ic_launcher_background));
        contattoList.add(new Contatto("Gianni Morandi","34393832",R.drawable.ic_launcher_background));
        contattoList.add(new Contatto("Fanculo Bugo","34393832",R.drawable.ic_launcher_background));

        listView = findViewById(R.id.ListView);

        CustomArrayAdapter adapter = new CustomArrayAdapter(this,R.layout.element_list,contattoList);

        listView.setAdapter(adapter);

        nome = findViewById(R.id.tvNome);
        cognome = findViewById(R.id.tvCognome);
        numero = findViewById(R.id.tvTelefono);
        button = findViewById(R.id.ButtonInsert);

        nome.setText(nome_bundle);
        cognome.setText(cognome_bundle);
        numero.setText(numero_bundle);

        button.setOnClickListener(event ->{
            Contatto c = new Contatto(nome.getText().toString()+" "+cognome.getText().toString(),numero.getText().toString(),R.drawable.ic_launcher_background);
            adapter.add(c);
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("NOME",nome.getText().toString());
        outState.putString("COGNOME",cognome.getText().toString());
        outState.putString("NUMERO",numero.getText().toString());
    }
}