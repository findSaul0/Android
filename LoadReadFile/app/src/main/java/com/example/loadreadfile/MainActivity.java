package com.example.loadreadfile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    public TextView Percorso;
    public EditText NomeFile;
    public EditText Inserisci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Percorso = findViewById(R.id.Percorso);
        NomeFile = findViewById(R.id.NomeFile);
        Inserisci = findViewById(R.id.Inserisci);

        //ci consente di trovare la directory della app
        Percorso.setText("Path: " + getApplicationContext().getFilesDir().toString());
    }

    public void Buttonreset(View v){
        Inserisci.setText("");
    }

    public void salva  (View v){
        String str = NomeFile.getText().toString();
        FileOutputStream fos  = null;
        try{
            fos = openFileOutput(str, Context.MODE_PRIVATE);
            fos.write(Inserisci.getText().toString().getBytes());
            fos.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void load(View v){
        String str = NomeFile.getText().toString();
        FileInputStream fis = null;
        try {
            fis = openFileInput(str);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line;
            String data = "";
            while (null != (line = br.readLine())){
                data+=line+"\n";
            }
            br.close();
            Inserisci.setText(data);
        }catch (FileNotFoundException e ){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}