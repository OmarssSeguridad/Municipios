package com.example.municipios.Base;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatos extends SQLiteOpenHelper {
    private static final String NOMBRE_BASE_DE_DATOS = "municipios",
            NOMBRE_TABLA_MUNICIPIOS = "municipios",
            NOMBRE_TABLA_RIESGOS = "zonariesgos";
    private static final int VERSION_BASE_DE_DATOS = 1;

    public BaseDatos(Context context) {
        super(context, NOMBRE_BASE_DE_DATOS, null, VERSION_BASE_DE_DATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s(id integer primary key, municipio text, significado text, cabecera text, " +
                "superficie real, altitud real, clima text, latitud real, longitud real)", NOMBRE_TABLA_MUNICIPIOS));

        db.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s(id integer primary key, idmunicipio int, desastrenatural text)", NOMBRE_TABLA_RIESGOS));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}


