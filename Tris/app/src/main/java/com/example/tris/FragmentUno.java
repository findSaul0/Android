package com.example.tris;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FragmentUno extends Fragment implements View.OnClickListener {

    FragmentUnoToDue listner;


    public interface FragmentUnoToDue{
        void updateFragmentUno(Button b);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FragmentUnoToDue){
            listner = (FragmentUnoToDue) context;
        }else{
            throw new RuntimeException(context.toString()+"Fragment uno must implement");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listner = null;
    }

    private Button button;
    private View v;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragmnet_layout,container,false);
        ArrayList<View> allButtons;
        allButtons = v.findViewById(R.id.grid_tris).getTouchables();
        for(View element : allButtons){
            button = (Button) element;
            button.setOnClickListener(this);
            }
        return v;
    }


    public void updateButton (Button b){
        button.setText(b.getText());
    }


    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        Object tag = b.getTag();
        if(tag == null){
            b.setText("X");
        }
        else{
            b.setTag("false");
        }
        listner.updateFragmentUno(b);
    }


}
