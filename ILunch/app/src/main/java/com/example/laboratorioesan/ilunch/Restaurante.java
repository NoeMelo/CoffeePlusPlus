package com.example.laboratorioesan.ilunch;


public class Restaurante{

    String nombre;
    String descripcion;
    int fotores;
    String lat;
    String lon;


    Restaurante(String nombre,String descripcion,  int fotores, String lat, String lon) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fotores = fotores;
        this.lat = lat;
        this.lon = lon;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }

    public int getFotores() {
        return fotores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFotores(int fotores) {
        this.fotores = fotores;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }
}
