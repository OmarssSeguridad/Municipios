package com.example.municipios;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class sql extends SQLiteOpenHelper {
    private static final String database = "Municipios";
    private static final int VERSION=1;

    private final String tablaMun="CREATE TABLE MUNICIPIOS(ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            "NOMBRE TEXT NOT NULL, " +
            "SIGNIFICADO TEXT NOT NULL, " +
            "CABECERA TEXT NOT NULL, " +
            "SUPERFICIE TEXT NOT NULL, " +
            "ALTITUD TEXT NOT NULL, " +
            "CLIMA TEXT NOT NULL, " +
            "LATITUD TEXT NOT NULL," +
            "LONGITUD TEXT NOT NULL" +
            ") ";
      private final String tablaZonRie="CREATE TABLE ZONASRIESGO(ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
              "NOMBRE TEXT NOT NULL, " +
              "DESCRIPCION TEXT NOT NULL)";
    public sql(Context context){
        super(context, database,null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(tablaMun);
        //sqLiteDatabase.execSQL(tablaZonRie);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int anterior, int nueva) {
        if(nueva>anterior){

            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS MUNICIPIOS");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS ZONASRIESGO");
            sqLiteDatabase.execSQL(tablaMun);
            sqLiteDatabase.execSQL(tablaZonRie);

        }
    }
}

