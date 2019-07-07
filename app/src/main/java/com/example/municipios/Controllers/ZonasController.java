package com.example.municipios.Controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.municipios.Base.BaseDatos;
import com.example.municipios.Modelos.ZonaRiesgo;

import java.util.ArrayList;

public class ZonasController {

    private BaseDatos ayudanteBaseDeDatos;
    private String NOMBRE_TABLA = "zonariesgos";

    public ZonasController(Context contexto) {
        ayudanteBaseDeDatos = new BaseDatos(contexto);
    }


    public int eliminarZona(ZonaRiesgo zona) {

        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getWritableDatabase();
        String[] argumentos = {String.valueOf(zona.getId())};
        return baseDeDatos.delete(NOMBRE_TABLA, "id = ?", argumentos);
    }

    public long nuevaZona(ZonaRiesgo zona) {
        // writable porque vamos a insertar
        //int id, int idMunicipio, String desastreNatural
        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getWritableDatabase();
        ContentValues valoresParaInsertar = new ContentValues();
        valoresParaInsertar.put("idmunicipio", zona.getIdMunicipio());
        valoresParaInsertar.put("desastrenatural", zona.getDesastreNatural());
        return baseDeDatos.insert(NOMBRE_TABLA, null, valoresParaInsertar);
    }

    public int guardarCambios(ZonaRiesgo zona) {
        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getWritableDatabase();
        ContentValues valoresParaActualizar = new ContentValues();
        valoresParaActualizar.put("idmunicipio", zona.getIdMunicipio());
        valoresParaActualizar.put("desastrenatural", zona.getDesastreNatural());
        // where id...
        String campoParaActualizar = "id = ?";
        // ... = idMascota
        String[] argumentosParaActualizar = {String.valueOf(zona.getId())};
        return baseDeDatos.update(NOMBRE_TABLA, valoresParaActualizar, campoParaActualizar, argumentosParaActualizar);
        //baseDeDatos.
    }



    public ArrayList<String> obtenerZonas(int id) {
        ArrayList<String> zonas = new ArrayList<>();
        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getReadableDatabase();
        String[] columnasAConsultar = {"id", "idmunicipio", "desastrenatural"};
        Cursor cursor = baseDeDatos.query(
                NOMBRE_TABLA,//from mascotas
                columnasAConsultar,
                "idmunicipio = "+id,
                null,
                null,
                null,
                null
        );

        if (cursor == null) {
            return zonas;
        }
        if (!cursor.moveToFirst()) return zonas;
        do {
            String item="";

           // item+= cursor.getInt(0)+"\r\n";
           // item+= cursor.getInt(1)+"\r\n";
            item+=cursor.getString(2)+"\r\n";
            zonas.add(item);
        } while (cursor.moveToNext());
        cursor.close();
        return zonas;
    }

    public Cursor getCantidad(int id){
        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getReadableDatabase();
        // SELECT nombre, edad, id
        Cursor cursor = baseDeDatos.rawQuery("SELECT * FROM "+NOMBRE_TABLA+ " WHERE id = "+id,null);
        return cursor;
    }
}
