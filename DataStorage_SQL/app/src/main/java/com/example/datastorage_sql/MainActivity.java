package com.example.datastorage_sql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import javax.xml.validation.Schema;

public class MainActivity extends AppCompatActivity {
    private ListView primaLista;
    private ListView secondaLista;
    private EditText tvNome;
    private EditText tvVoto;


    private SQLiteDatabase db = null;
    private DatabaseOpenHelper dbHelper;
    private SimpleCursorAdapter adapter;
    private SimpleCursorAdapter adapterSelected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNome = findViewById(R.id.tvNome);
        tvVoto = findViewById(R.id.tvVoto);
        primaLista = findViewById(R.id.primaList);
        secondaLista = findViewById(R.id.secondaList);

        dbHelper = new DatabaseOpenHelper(this);
        db = dbHelper.getWritableDatabase();

        Cursor cursorAll = db.rawQuery("SELECT * from studenti",null);
        Cursor cursorSelected = readSelectionedEntries();

        adapter = new SimpleCursorAdapter(
                getApplicationContext(),
                R.layout.layout_list,
                cursorAll,
                DatabaseOpenHelper.colums,
                new int[] {R.id._id,R.id.nome , R.id.voto},
                0
        );

        adapterSelected = new SimpleCursorAdapter(
                getApplicationContext(),
                R.layout.layout_list,
                cursorSelected,
                DatabaseOpenHelper.colums,
                new int[] {R.id._id,R.id.nome,R.id.voto},
                0
        );

        primaLista.setAdapter(adapter);
        secondaLista.setAdapter(adapterSelected);

        primaLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SQLiteCursor cursor= (SQLiteCursor) primaLista.getItemAtPosition(position);

                int _id = cursor.getInt(0);
                String nome = cursor.getString(1);
                int voto = cursor.getInt(2);

                Toast.makeText(getApplicationContext(),
                        "Cancello il record " + _id + "\nNome: " + nome + " - Voto = " + voto,
                        Toast.LENGTH_LONG).show();


                db.delete(SchemaDb.Tavola.TABLE_NAME,
                        SchemaDb.Tavola._ID + "=?",
                        new String[]{"" + _id});


                // Redisplay data
                updateList();
            }
        });

    }


            private Cursor readSelectionedEntries(){

                String[] projection = {
                        SchemaDb.Tavola._ID,
                        SchemaDb.Tavola.COLUMN_NAME,
                        SchemaDb.Tavola.COLUMN_VOTO,
                };

                String sortOrder = SchemaDb.Tavola.COLUMN_VOTO + " ASC ";
                String selection;
                selection = SchemaDb.Tavola.COLUMN_VOTO + " >? ";

                String[] selectionArgs = {"25"};

                Cursor cursor = db.query(
                        SchemaDb.Tavola.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );

                return cursor;
            }



                        public void Inserisci (View v){
                            String nome = tvNome.getText().toString();
                            String voto = tvVoto.getText().toString();

                            if(tvNome.length() > 0 && voto.length() >0){
                                ContentValues values = new ContentValues();
                                values.put(SchemaDb.Tavola.COLUMN_NAME, nome);
                                values.put(SchemaDb.Tavola.COLUMN_VOTO, Integer.parseInt(voto));
                                db.insert(SchemaDb.Tavola.TABLE_NAME,null,values);
                            } else{
                                Toast.makeText(getApplicationContext(),"Dati non validi", Toast.LENGTH_LONG).show();
                            }

                            updateList();
                        }


                                    public void updateList(){
                                        adapter.getCursor().requery();
                                        adapter.notifyDataSetChanged();
                                        adapterSelected.getCursor().requery();
                                        adapterSelected.notifyDataSetChanged();
                                    }

                                    private void clearAll() {
                                        db.delete(SchemaDb.Tavola.TABLE_NAME, null, null);
                                    }


                                    @Override
                                    protected void onDestroy() {
                                        db.close();
                                        super.onDestroy();
                                    }
}