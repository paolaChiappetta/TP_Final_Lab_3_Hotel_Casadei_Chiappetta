package com.Hotel;

import java.io.Serializable;

public class ProductoMinibar extends Extra implements Serializable {
    
    private String marca;

    public ProductoMinibar() {
    }

    public ProductoMinibar(String nombre, Double precio, String marca) {
        super(nombre, precio);
        this.marca = marca;
    }

    public ProductoMinibar(String nombre, Double precio, boolean alta, Integer cantidad, String marca) {
        super(nombre, precio, alta, cantidad);
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String mostrarExtra() {
        return super.mostrarExtra() + "Marca: " + this.marca + "\n";
    }
}
