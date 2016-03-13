package com.example.yacic.adaptador1;

import java.io.Serializable;

/**
 * Created by Yacic on 13/01/2016.
 */
public class Zona implements Serializable {
    String nombre;
    String descripcion;
    int imagen;

    public Zona(String nombre, String descripcion, int imagen) {
        this.nombre = nombre;
        this.descripcion=descripcion;
        this.imagen=imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getTextoCorto(){
        return descripcion.substring(0,100)+"...";
    }
}
