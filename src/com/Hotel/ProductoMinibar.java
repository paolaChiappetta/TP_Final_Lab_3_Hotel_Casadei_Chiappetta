package com.Hotel;

public class ProductoMinibar extends Extra {
    
    private String marca;

    public ProductoMinibar() {
    }

    public ProductoMinibar(String nombre, Double precio, String marca) {
        super(nombre, precio);
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }



}
