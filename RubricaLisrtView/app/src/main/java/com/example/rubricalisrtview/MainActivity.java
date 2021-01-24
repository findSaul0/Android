package com.example.rubricalisrtview;

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

    EditText nome;
    EditText cognome;
    EditText numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contattoList = new ArrayList<>();
        contattoList.add(new Contatto("Antonio Fasulo","34393832",R.drawable.ic_launcher_background));
        contattoList.add(new Contatto("Gianni Morandi","34393832",R.drawable.ic_launcher_background));
        contattoList.add(new Contatto("Fanculo Bugo","34393832",R.drawable.ic_launcher_background));

        listView = findViewById(R.id.ListView);

        CustomArrayAdapter adapter = new CustomArrayAdapter(this,R.layout.element_list,contattoList);

        listView.setAdapter(adapter);



    }

    public void InsertNumber(View v){
        nome = findViewById(R.id.tvNome);
        cognome = findViewById(R.id.tvCognome);
        numero = findViewById(R.id.tvTelefono);

        String nome_edit = nome.getText().toString();
        String cognome_edit = cognome.getText().toString();
        String numero_edit = numero.getText().toString();

        String completa = nome_edit + " Paol"+ cognome_edit;

        contattoList.add(new Contatto(completa,numero_edit,R.drawable.ic_launcher_background));
    }
}