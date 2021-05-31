package com.Hotel;

public enum TipoFactura {
    FACTURA_A ("A"),
    FACTURA_B ("B"),
    FACTURA_C ("C");

    private String descripcion;

    TipoFactura(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
