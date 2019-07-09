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
        //String[] argumentos = {String.valueOf(zona.getId())};
        return baseDeDatos.delete(NOMBRE_TABLA, "id = "+zona.getId(), null);
    }


    public ArrayList<String> obtenerMunicipios(int id) {
        ArrayList<String> lista = new ArrayList<>();
        // readable porque no vamos a modificar, solamente leer
        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getReadableDatabase();
        // SELECT nombre, edad, id
        String[] columnasAConsultar = {"municipio", "significado", "cabecera", "superficie", "altitud", "clima", "latitud", "longitud", "id"};

        Cursor cursor = baseDeDatos.query(
                "municipios",//from municipios
                columnasAConsultar,
                "id = "+id,
                null,
                null,
                null,
                null
        );

        if (cursor == null) {

            return lista;

        }
        if (!cursor.moveToFirst()) return lista;

        do {
            // ZonasController zona = new ZonasController(getContext);
            String item = "";
            // El 0 es el número de la columna, como seleccionamos
            item += "IGECEM: " + cursor.getInt(8) + "\r\n";
            item += "Municipio: " + cursor.getString(0) + "\r\n";
            item += "Significado: " + cursor.getString(1) + "\r\n";
            item += "Cabecera: " + cursor.getString(2) + "\r\n";
            item += "Superficie: " + cursor.getDouble(3) + "\r\n";
            item += "Altitud: " + cursor.getDouble(4) + "\r\n";
            item += "Clima: " + cursor.getString(5) + "\r\n";
            item += "Latitud: " + cursor.getDouble(6) + "\r\n";
            item += "Longitud: " + cursor.getDouble(7) + "\r\n";
            item += "Zonas de Riesgo:\r\n";


            lista.add(item);

        }while (cursor.moveToNext()) ;

        // Fin del ciclo. Cerramos cursor y regresamos la lista de mascotas :)
        cursor.close();
        return lista;
    }

    public ArrayList<String> busquedaZonas(String desastre) {
        ArrayList<String> zonas = new ArrayList<>();
        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getReadableDatabase();
        String[] columnasAConsultar = {"id", "idmunicipio", "desastrenatural"};
        Cursor cursor = baseDeDatos.query(
                "zonariesgos",//from mascotas
                columnasAConsultar,
                "desastrenatural = '"+desastre+"'",
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



            ArrayList<String> municipios = obtenerMunicipios(cursor.getInt(1));
            for(int i=0;i<municipios.size();i++){
                item+=municipios.get(i);
            }
            item+=cursor.getString(2)+"\r\n";
            zonas.add(item);
        } while (cursor.moveToNext());
        cursor.close();
        return zonas;
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



    public ArrayList<ZonaRiesgo> obtenerZonas(int id) {
        ArrayList<ZonaRiesgo> zonas = new ArrayList<>();
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
            ZonaRiesgo zona = new ZonaRiesgo();
            zona.setId(cursor.getInt(0));
            zona.setIdMunicipio(cursor.getInt(1));
            zona.setDesastreNatural(cursor.getString(2));
            zonas.add(zona);
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
