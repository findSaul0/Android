package com.example.rubricalisrtview;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomArrayAdapter extends ArrayAdapter<Contatto> {

    Context context;
    int resource;
    List<Contatto> contattoList;


    public CustomArrayAdapter(Context context, int resource, List<Contatto> contattoList) {
        super(context, resource, contattoList);

        this.context = context;
        this.resource  = resource;
        this.contattoList = contattoList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View v = inflater.inflate(resource,null);

        TextView TextviewNome = v.findViewById(R.id.textViewNome);
        TextView TextviewNumero = v.findViewById(R.id.textViewNumero);
        ImageView ImageView = v.findViewById(R.id.imageView);

        Contatto contatto = contattoList.get(position);

        TextviewNome.setText(contatto.getNome());
        TextviewNumero.setText(contatto.getNumero());
        ImageView.setImageDrawable(context.getResources().getDrawable(contatto.getImage()));

        v.findViewById(R.id.allelement).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(position);
            }
        });

        return v;
    }

    private void removeItem(int p){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Sicuro di eliminare questo contatto?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                contattoList.remove(p);
                notifyDataSetChanged();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
