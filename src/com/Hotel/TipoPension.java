package com.Hotel;

public enum TipoPension {
    DESAYUNO ("Desayuno",500),
    MEDIA_PENSION ("Media pensión", 1500),
    PENSION_COMPLETA ("Pensión completa",2500);

    private String nombre;
    private double precio;

    TipoPension(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
