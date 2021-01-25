package com.example.tris;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FragmentUno.FragmentUnoToDue,FragmentDue.FragmentDueToUno {

    private FragmentDue fragmentDue;
    private FragmentUno fragmentUno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentUno = new FragmentUno();
        fragmentDue = new FragmentDue();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.firstfragment,fragmentUno)
                .replace(R.id.secondfragment,fragmentDue)
                .commit();

    }

    @Override
    public void updateFragmentDue(Button b) {
        fragmentUno.updateButton(b);
    }

    @Override
    public void updateFragmentUno(Button b) {
        fragmentDue.updateButton(b);
    }
}