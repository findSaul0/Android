package com.example.cartellefragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class Cartella extends Fragment implements View.OnClickListener {

    int numeri[];

    public Cartella(){
        //costruttore vuoto
    }

    public void numeriCartella(int [] numeri){
        this.numeri = numeri;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v;
        v = inflater.inflate(R.layout.layout_cartella,container, false);
        ArrayList<View> allButtons;
        allButtons = v.findViewById(R.id.tvTableCartella).getTouchables();
        int j = 0;
        for (View element : allButtons){
            Button b = (Button) element;
            if ( b != null && numeri != null){
                b.setText(""+numeri[j]);
                j++;
                b.setOnClickListener(this);
            }
        }
        return v;
    }

        @Override
        public void onClick(View v) {
            Button b = (Button) v;
            Object tag = b.getTag();
            if(tag == null || tag.toString().equals("false")){
                b.setTag("true");
                b.setTextColor(Color.GREEN);
            } else {
                b.setTag("false");
                b.setTextColor(Color.BLACK);
            }
        }


}
