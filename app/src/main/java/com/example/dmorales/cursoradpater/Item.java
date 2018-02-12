package com.example.dmorales.cursoradpater;

import android.content.ContentValues;

/**
 * Created by dmorales on 12/02/2018.
 */

public class Item {
    private String dni;
    private String nombres;
    private String apellidos;
    private String celular;

    public Item() {
        this.dni = "";
        this.nombres = "";
        this.apellidos = "";
        this.celular = "";
    }

    public Item(String dni, String nombres, String apellidos, String celular) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.celular = celular;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.ITEM_DNI,dni);
        contentValues.put(SQLConstantes.ITEM_NOMBRES,nombres);
        contentValues.put(SQLConstantes.ITEM_APELLIDOS,apellidos);
        contentValues.put(SQLConstantes.ITEM_CELULAR,celular);
        return contentValues;
    }
}
