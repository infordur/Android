package com.example.yacic.animalitos;

/**
 * Created by Yacic on 19/02/2016.
 */
public class Animal {
    int imagen;
    int sonido;
    int imagen2;

    public Animal(int imagen, int sonido, int imagen2) {
        this.imagen = imagen;
        this.sonido = sonido;
        this.imagen2 = imagen2;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getSonido() {
        return sonido;
    }

    public void setSonido(int sonido) {
        this.sonido = sonido;
    }

    public int getImagen2() {
        return imagen2;
    }

    public void setImagen2(int imagen2) {
        this.imagen2 = imagen2;
    }
}
