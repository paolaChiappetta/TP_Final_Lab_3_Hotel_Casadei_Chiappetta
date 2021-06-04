package com.Hotel;

public class Rotura extends Extra {

    private String causa;

    public Rotura() {
    }

    public Rotura(String nombre, Double precio, String causa) {
        super(nombre, precio);
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
