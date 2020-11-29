package com.example.datastorage_sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOpenHelper extends SQLiteOpenHelper {

    final static String[] colums = {
            SchemaDb.Tavola._ID,
            SchemaDb.Tavola.COLUMN_NAME,
            SchemaDb.Tavola.COLUMN_VOTO
    };

    final private static String CREATE_TABLE =
            "CREATE TABLE " + SchemaDb.Tavola.TABLE_NAME+" ("
            + SchemaDb.Tavola._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + SchemaDb.Tavola.COLUMN_NAME + " TEXT NOT NULL, "
            + SchemaDb.Tavola.COLUMN_VOTO + " INTEGER NOT NULL ); ";

    final private static Integer VERSION = 1;
    final private Context context;

    public DatabaseOpenHelper(Context context) {
        super(context, SchemaDb.Tavola.TABLE_NAME,null,VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       //non serve ma deve esserci
    }

    void deleteDatabase(){
        context.deleteDatabase(SchemaDb.Tavola.TABLE_NAME);
    }

}
