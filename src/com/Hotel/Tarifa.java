package com.Hotel;

import java.io.Serializable;

public enum Tarifa implements Serializable {

    SINGLE_STANDAR ("Single Standar","Cama individual, vista al contrafrente", 2350),
    SINGLE_SUPERIOR ("Single Superior","Cama individual, vista al mar y balcón", 2850),
    DOBLE_STANDAR ("Doble Standar","Cama matrimonial o dos camas, vista al contrafrente", 3500),
    DOBLE_SUPERIOR ("Doble Superior","Cama matrimonial o dos camas, vista al mar y balcón", 4300),
    TRIPLE_STANDAR ("Triple","Cama matrimonial y una individual o tres individuales", 5150),
    DEPARTAMENTO_4PAX ("Departamento 4 PAX","Cama matrimonial y dos individuales o cuatro individuales, cocina", 8500),
    DEPARTAMENTO_6PAX ("Departamento 6 PAX","Cama matrimonial y cuatro individuales o seid individuales, cocina", 9400),
    SUITE ("Suite","Cama matrimonial king-size, hidromasaje, vista al mar y balcón", 7500);

    private String nombre;
    private String descripcion;
    private double precio;

    Tarifa(String nombre, String descripcion, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }
}
