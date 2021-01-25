package com.example.tris;



import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;

public class TrisFragment extends Fragment {

    private String player;
    private GridView trisGrid;
    private TextView playerView;
    private ArrayList<String> array= new ArrayList<>(Arrays.asList("","","","","","","","",""));
    private ArrayAdapter<String> stringAdapter;
    private MainActivity parentActivity;
    private String TAG="Doppio Tris";
    private boolean play=true;

    public TrisFragment() {
        super();
    }

    public TrisFragment(String player){
        this.player=player;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Log.d(TAG, "onCreateView: ");
        View v=inflater.inflate(R.layout.fragment_layout,container,false);

        playerView=v.findViewById(R.id.playerView);

        playerView.setText("Giocatore "+player);

        trisGrid=v.findViewById(R.id.trisGrid);

        stringAdapter=new ArrayAdapter<>(getContext(),R.layout.single_layout,R.id.casella,array);

        trisGrid.setAdapter(stringAdapter);



        trisGrid.setOnItemClickListener(listener);



        return v;
    }

    public void setArray(ArrayList<String> array){
        this.array=array;
        stringAdapter.notifyDataSetChanged();

    }


    public void setParentActivity(MainActivity mainActivity) {
        this.parentActivity=mainActivity;
    }


    private AdapterView.OnItemClickListener listener=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


            if(!array.get(i).isEmpty()){
                Toast.makeText(getContext(),"Non puoi mettere qui!",Toast.LENGTH_SHORT).show();
            }else{
                array.set(i,player);
                stringAdapter.notifyDataSetChanged();
                parentActivity.aggiornaDataSet(array);

            }

        }
    };


}
