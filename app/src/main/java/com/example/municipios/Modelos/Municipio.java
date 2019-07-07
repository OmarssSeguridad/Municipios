package com.example.municipios.Modelos;

public class Municipio {
    private int id;
    private String municipio;
    private String significado;
    private String cabecera;
    private double superficie;
    private double altitud;
    private String clima;
    private double latitud;
    private double longitud;

    public Municipio(int id, String municipio, String significado, String cabecera, double superficie, double altitud, String clima, double latitud, double longitud) {
        this.id = id;
        this.municipio = municipio;
        this.significado = significado;
        this.cabecera = cabecera;
        this.superficie = superficie;
        this.altitud = altitud;
        this.clima = clima;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getSignificado() {
        return significado;
    }

    public void setSignificado(String significado) {
        this.significado = significado;
    }

    public String getCabecera() {
        return cabecera;
    }

    public void setCabecera(String cabecera) {
        this.cabecera = cabecera;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public double getAltitud() {
        return altitud;
    }

    public void setAltitud(double altitud) {
        this.altitud = altitud;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "Municipio{" +
                "id='" + id + '\'' +
                "municipio='"+municipio+'\''+

               // ", edad=" + edad +
                '}';
    }
}
