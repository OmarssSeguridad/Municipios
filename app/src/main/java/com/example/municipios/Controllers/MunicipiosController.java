package com.example.municipios.Controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.municipios.Base.BaseDatos;
import com.example.municipios.Modelos.Municipio;
import com.example.municipios.Modelos.ZonaRiesgo;

import java.util.ArrayList;

public class MunicipiosController {

    private BaseDatos ayudanteBaseDeDatos;
    private String NOMBRE_TABLA = "municipios";

    public MunicipiosController(Context contexto){

        ayudanteBaseDeDatos = new BaseDatos(contexto);
    }


    public int eliminarMunicipio(int id) {

        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getWritableDatabase();

        baseDeDatos.delete("zonariesgos", "idmunicipio = "+id,null);
        return baseDeDatos.delete(NOMBRE_TABLA, "id = "+id, null);
    }



    public long nuevoMunicipio(Municipio municipio) {
        // writable porque vamos a insertar
        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getWritableDatabase();
        ContentValues valoresParaInsertar = new ContentValues();
        valoresParaInsertar.put("id",municipio.getId());
        valoresParaInsertar.put("municipio", municipio.getMunicipio());
        valoresParaInsertar.put("significado", municipio.getSignificado());
        valoresParaInsertar.put("cabecera", municipio.getCabecera());
        valoresParaInsertar.put("superficie", municipio.getSuperficie());
        valoresParaInsertar.put("altitud", municipio.getAltitud());
        valoresParaInsertar.put("clima", municipio.getClima());
        valoresParaInsertar.put("latitud", municipio.getLatitud());
        valoresParaInsertar.put("longitud", municipio.getLongitud());
        return baseDeDatos.insert(NOMBRE_TABLA, null, valoresParaInsertar);
    }

    public int guardarCambios(Municipio municipio) {
        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getWritableDatabase();
        ContentValues valoresParaActualizar = new ContentValues();
        valoresParaActualizar.put("municipio", municipio.getMunicipio());
        valoresParaActualizar.put("significado", municipio.getSignificado());
        valoresParaActualizar.put("cabecera", municipio.getCabecera());
        valoresParaActualizar.put("superficie", municipio.getSuperficie());
        valoresParaActualizar.put("altitud", municipio.getAltitud());
        valoresParaActualizar.put("clima", municipio.getClima());
        valoresParaActualizar.put("latitud", municipio.getLatitud());
        valoresParaActualizar.put("longitud", municipio.getLongitud());
        // where id...
        String campoParaActualizar = "id = ?";
        // ... = idMascota
        String[] argumentosParaActualizar = {String.valueOf(municipio.getId())};
        return baseDeDatos.update(NOMBRE_TABLA, valoresParaActualizar, campoParaActualizar, argumentosParaActualizar);
    }



    public ArrayList<String> obtenerMunicipios() {
        ArrayList<String> lista = new ArrayList<>();
        // readable porque no vamos a modificar, solamente leer
        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getReadableDatabase();
        // SELECT nombre, edad, id
        String[] columnasAConsultar = {"municipio", "significado", "cabecera", "superficie", "altitud", "clima", "latitud", "longitud", "id"};

        Cursor cursor = baseDeDatos.query(
                NOMBRE_TABLA,//from municipios
                columnasAConsultar,
                null,
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
            item += "Municipio" + cursor.getString(0) + "\r\n";
            item += "Significado: " + cursor.getString(1) + "\r\n";
            item += "Cabecera: " + cursor.getString(2) + "\r\n";
            item += "Superficie: " + cursor.getDouble(3) + "\r\n";
            item += "Altitud: " + cursor.getDouble(4) + "\r\n";
            item += "Clima: " + cursor.getString(5) + "\r\n";
            item += "Latitud: " + cursor.getDouble(6) + "\r\n";
            item += "Longitud: " + cursor.getDouble(7) + "\r\n";
            item += "Zonas de Riesgo: ";


            ArrayList<String> zonas = obtenerZonas(cursor.getInt(8));
            for(int i=0;i<zonas.size();i++){
                item+=zonas.get(i)+"\r\n";
            }

            lista.add(item);

            }while (cursor.moveToNext()) ;

        // Fin del ciclo. Cerramos cursor y regresamos la lista de mascotas :)
        cursor.close();
        return lista;
    }

    public Municipio buscarMunicipio(int id) {
        Municipio municipio = new Municipio();
        // readable porque no vamos a modificar, solamente leer
        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getReadableDatabase();
        // SELECT nombre, edad, id
        String[] columnasAConsultar = {"municipio", "significado", "cabecera", "superficie", "altitud", "clima", "latitud", "longitud", "id"};

        Cursor cursor = baseDeDatos.query(
                NOMBRE_TABLA,//from municipios
                columnasAConsultar,
                "id = "+id,
                null,
                null,
                null,
                null
        );

        if (cursor == null) {

            return municipio;

        }
        if (!cursor.moveToFirst()) return municipio;

        do {
            // ZonasController zona = new ZonasController(getContext);
            // El 0 es el número de la columna, como seleccionamos
            municipio.setId(cursor.getInt(8));
            municipio.setMunicipio(cursor.getString(0));
            municipio.setSignificado(cursor.getString(1));
            municipio.setCabecera(cursor.getString(2));
            municipio.setSuperficie(cursor.getDouble(3));
            municipio.setAltitud(cursor.getDouble(4));
            municipio.setClima(cursor.getString(5));
            municipio.setLatitud(cursor.getDouble(6));
            municipio.setLongitud(cursor.getDouble(7));

        }while (cursor.moveToNext()) ;


        // Fin del ciclo. Cerramos cursor y regresamos la lista de mascotas :)
        cursor.close();
        return municipio;
    }


    public ArrayList<String> obtenerZonas(int id) {
        ArrayList<String> zonas = new ArrayList<>();
        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getReadableDatabase();
        String[] columnasAConsultar = {"id", "idmunicipio", "desastrenatural"};
        Cursor cursor = baseDeDatos.query(
                "zonariesgos",//from mascotas
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
