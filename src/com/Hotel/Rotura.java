package com.Hotel;

import java.io.Serializable;

public class Rotura extends Extra  implements Serializable {

    private String causa;

    public Rotura() {
    }

    public Rotura(String nombre, Double precio, String causa) {
        super(nombre, precio);
        this.causa = causa;
    }

    public Rotura(String nombre, Double precio, boolean alta, Integer cantidad, String causa) {
        super(nombre, precio, alta, cantidad);
        this.causa = causa;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    @Override
    public String mostrarExtra() {
        return this.causa + " de " + super.mostrarExtra();
    }
}
