package com.Hotel;

import java.io.Serializable;
import java.util.Scanner;

public class ProductoMinibar extends Extra implements Serializable{

    //Atributos
    private String marca;

    //Constructor vacío
    public ProductoMinibar() {
    }

    //Constructor con algunos datos
    public ProductoMinibar(String nombre, Double precio, String marca) {
        super(nombre, precio);
        this.marca = marca;
    }

    //Constructor completo
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

    @Override
    public void modificarExtra(Extra extra, int opcion) {

        if(opcion==1 || opcion==2){
            super.modificarExtra(extra, opcion);
        }else {
            Scanner scanner = new Scanner(System.in);
            ProductoMinibar producto= (ProductoMinibar) extra;
            System.out.println("Ingrese la nueva marca");
            producto.setMarca(scanner.nextLine());
        }
    }
}
