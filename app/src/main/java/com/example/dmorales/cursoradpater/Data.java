package com.example.dmorales.cursoradpater;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by dmorales on 12/02/2018.
 */

public class Data {
    Context context;
    SQLiteOpenHelper sqLiteOpenHelper;
    SQLiteDatabase sqLiteDatabase;

    public Data(Context context) {
        this.context = context;
        this.sqLiteOpenHelper = new DBHelper(context);
        this.sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    public void open(){
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }
    public void close(){
        sqLiteOpenHelper.close();
    }

    public long getNumeroItems(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase,SQLConstantes.tablaItems);
    }

    public void insertarItem(Item item){
        sqLiteDatabase.insert(SQLConstantes.tablaItems,null, item.toValues());
    }


    public void insertarItems(ArrayList<Item> items){
        if(getNumeroItems() == 0){
            for(Item item : items){
                try {
                    insertarItem(item);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public Item getItem(String dni){
        Item item = new Item();
        String[] whereArgs = new String[]{dni};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablaItems,
                    SQLConstantes.ALL_COLUMNS_ITEMS,SQLConstantes.CLAUSULA_WHERE_DNI,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                item.setDni(cursor.getString(cursor.getColumnIndex(SQLConstantes.ITEM_DNI)));
                item.setNombres(cursor.getString(cursor.getColumnIndex(SQLConstantes.ITEM_NOMBRES)));
                item.setCelular(cursor.getString(cursor.getColumnIndex(SQLConstantes.ITEM_CELULAR)));
                item.setApellidos(cursor.getString(cursor.getColumnIndex(SQLConstantes.ITEM_APELLIDOS)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return item;
    }

    public Cursor getAllItems(){
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * from " + SQLConstantes.tablaItems, null);
        if (cursor != null) cursor.moveToFirst();
        return cursor;
    }
}
