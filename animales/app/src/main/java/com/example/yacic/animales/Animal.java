package com.example.yacic.animales;

import java.io.Serializable;

/**
 * Created by Yacic on 10/02/2016.
 */
public class Animal implements Serializable {
    int imagen;
    int imagen2;
    int sonido;

    public Animal(int imagen, int color, int sonido) {
        this.imagen = imagen;
        this.imagen2 = color;
        this.sonido = sonido;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getImagen2() {
        return imagen2;
    }

    public void setImagen2(int imagen2) {
        this.imagen2 = imagen2;
    }

    public int getSonido() {
        return sonido;
    }

    public void setSonido(int sonido) {
        this.sonido = sonido;
    }
}
