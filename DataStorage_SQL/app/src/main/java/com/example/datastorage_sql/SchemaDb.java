package com.example.datastorage_sql;

import android.provider.BaseColumns;

public class SchemaDb {
    public SchemaDb(){

    }

    public static abstract class Tavola implements BaseColumns{
        public static final String TABLE_NAME = "studenti";
        public static final String COLUMN_NAME= "nome";
        public static final String COLUMN_VOTO= "voto";

    }

}
