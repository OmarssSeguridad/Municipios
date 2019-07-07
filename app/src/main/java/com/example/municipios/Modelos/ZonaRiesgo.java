package com.example.municipios.Modelos;

public class ZonaRiesgo {
    private int id;
    private int idMunicipio;
    private String desastreNatural;

    public ZonaRiesgo() {

    }

    public ZonaRiesgo(int id, int idMunicipio, String desastreNatural) {
        this.id = id;
        this.idMunicipio = idMunicipio;
        this.desastreNatural = desastreNatural;
    }

    public ZonaRiesgo(int idMunicipio, String desastreNatural) {
        this.idMunicipio = idMunicipio;
        this.desastreNatural = desastreNatural;
    }

    public String getDesastreNatural() {
        return desastreNatural;
    }

    public void setDesastreNatural(String desastreNatural) {
        this.desastreNatural = desastreNatural;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

}
