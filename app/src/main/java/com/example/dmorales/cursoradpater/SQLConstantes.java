package com.example.dmorales.cursoradpater;

/**
 * Created by dmorales on 12/02/2018.
 */

public class SQLConstantes {
    public static final String NAME_DATABASE = "datos.db";


    public static final String tablaItems = "items";

    public static final String ITEM_ID = "_id";
    public static final String ITEM_DNI = "dni";
    public static final String ITEM_NOMBRES = "nombres";
    public static final String ITEM_APELLIDOS = "apellidos";
    public static final String ITEM_CELULAR = "celular";


    public static final String SQL_CREATE_TABLA_ITEMS =
            "CREATE TABLE " + tablaItems + "(" +
                    ITEM_ID + " TEXT PRIMARY KEY," +
                    ITEM_DNI + " TEXT, " +
                    ITEM_NOMBRES + " TEXT, " +
                    ITEM_APELLIDOS + " TEXT, " +
                    ITEM_CELULAR + " TEXT" +");"
            ;



    public static final String SQL_DELETE_TABLA_ITEMS = "DROP TABLE " + tablaItems;

    public static final String CLAUSULA_WHERE_DNI = "dni?= " + tablaItems;


    public static final String[] ALL_COLUMNS_ITEMS = {
            ITEM_DNI, ITEM_NOMBRES, ITEM_APELLIDOS, ITEM_CELULAR
    };
}
