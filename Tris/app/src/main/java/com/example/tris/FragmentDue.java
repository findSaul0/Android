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

public class FragmentDue extends Fragment implements View.OnClickListener {

    FragmentDueToUno listner;


    public interface FragmentDueToUno{
        void updateFragmentDue(Button b);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FragmentDueToUno){
            listner = (FragmentDueToUno) context;
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragmnet_due_layout,container,false);
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
            b.setText("O");
        }
        else{
            b.setTag("false");
        }
        listner.updateFragmentDue(b);
    }


}
