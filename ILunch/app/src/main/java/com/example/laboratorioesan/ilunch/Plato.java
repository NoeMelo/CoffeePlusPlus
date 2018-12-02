package com.example.laboratorioesan.ilunch;

public class Plato {
    String nombre;
    String tipo;
    String descripcion;
    int fotoplato;

   public Plato(String nombre,String tipo,String descripcion,  int fotoplato) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fotoplato = fotoplato;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFotoplato(int fotoplato) {
        this.fotoplato = fotoplato;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getFotoplato() {
        return fotoplato;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipo() {
        return tipo;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
