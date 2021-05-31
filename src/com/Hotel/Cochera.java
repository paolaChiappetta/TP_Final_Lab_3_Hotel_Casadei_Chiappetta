package com.Hotel;

public enum Cochera {
    COCHERA_CUB("Cochera cubierta", 500);

    private String descripcion;
    private double precio;

    Cochera(String descripcion, double precio) {
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }
}
