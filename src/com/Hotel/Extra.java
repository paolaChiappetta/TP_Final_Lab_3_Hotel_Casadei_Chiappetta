package com.Hotel;

import java.io.Serializable;
import java.util.Scanner;

public class Extra implements Serializable {

    private String nombre;
    private Double precio;
    private boolean alta = true;
    private Integer cantidad = 1;

    public Extra() {
    }

    public Extra(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;

    }

    public Extra(String nombre, Double precio, boolean alta, Integer cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.alta = alta;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public double calculoExtraPorCantidad() {
        return this.precio * this.cantidad;

    }

    public String mostrarExtra (){
        return this.nombre + "\nPrecio $" + this.precio + "\n";
    }

    public void modificarExtra (Extra extra, int opcion){
        Scanner scanner = new Scanner(System.in);
        if(opcion==1){
            System.out.println("Ingrese el nuevo nombre");
            extra.setNombre(scanner.nextLine());
        }else{
            System.out.println("Ingrese el nuevo precio");
            extra.setPrecio(scanner.nextDouble());
        }

    }

    @Override
    public String toString() {
        return "         " + this.nombre + "              $" + this.precio  + "             "
                + this.cantidad  +  "               "  + this.calculoExtraPorCantidad() + "\n";

    }
}
