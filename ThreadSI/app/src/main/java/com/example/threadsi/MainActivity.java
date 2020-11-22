package com.example.threadsi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.BitSet;

public class MainActivity extends AppCompatActivity {
    private ImageView tvimageview;
    private TextView  tvTextView;
    private  TextView tvPermesso;
    private Button buttonPermesso;
    private Bitmap bmap;
    private int index = 1 ;
    private int counter = 0 ;
    ProgressBar pb;
//modifica git
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvimageview = findViewById(R.id.Imageview);
        tvTextView = findViewById(R.id.counter);
        tvPermesso = findViewById(R.id.tvPermessi);
        buttonPermesso = findViewById(R.id.Permessi);
        pb = findViewById(R.id.progressBar_cyclic);
        havePermesso();
    }

    public void Load (View v){
        pb.setVisibility(ProgressBar.VISIBLE);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(8000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }

                bmap = null;
                switch(index){
                    case 1:
                        bmap = BitmapFactory.decodeResource(getResources(),R.drawable.image1);
                        index = 2;
                        break;
                    case 2:
                        bmap = BitmapFactory.decodeResource(getResources(),R.drawable.image2);
                        index = 1;
                        break;
                }

                //visualizziamo l'immagine nel main thread usando il metodo post
                tvimageview.post(new Runnable() {
                    @Override
                    public void run() {
                        tvimageview.setImageBitmap(bmap);
                        pb.setVisibility(ProgressBar.INVISIBLE);
                    }
                });

            }
        }).start();
    }

    public void UpgradeCounter (View v){
        counter++;
        tvTextView.setText(""+counter);
    }



    //GESTIONE PERMESSI
    public void AcceptedPermission(View view) {
        //Metodo che verifica se l'utente ha consentito o meno il permesso
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            //richiediamo permsso
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},100);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[],int []grantResults){
        //Metodo da utilizzare assieme a requestPermission del metodo AcceptedPermission
        switch (requestCode){
            case 100:
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    havePermesso();
                }else{
                    havePermesso();
                }
        }
    }

    public void havePermesso(){
        //Metodo per far aggiornare la TextView
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
            tvPermesso.setText("Permesso consentito");
        } else {
            tvPermesso.setText("Permesso non consentito");
        }
    }
}