package com.example.dmorales.cursoradpater;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by dmorales on 12/02/2018.
 */

public class DBHelper extends SQLiteOpenHelper{
    public static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, SQLConstantes.NAME_DATABASE, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLConstantes.SQL_CREATE_TABLA_ITEMS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQLConstantes.SQL_DELETE_TABLA_ITEMS);
        onCreate(db);
    }
}
