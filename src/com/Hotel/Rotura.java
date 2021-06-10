package com.Hotel;

import java.io.Serializable;
import java.util.Scanner;

public class Rotura extends Extra  implements Serializable{

    //Atributos
    private String causa;

    //Constructor vacío
    public Rotura() {
    }

    //Constructor con algunos datos
    public Rotura(String nombre, Double precio, String causa) {
        super(nombre, precio);
        this.causa = causa;
    }

    //Constructor completo
    public Rotura(String nombre, Double precio, boolean alta, Integer cantidad, String causa) {
        super(nombre, precio, alta, cantidad);
        this.causa = causa;
    }

    //Getters y setters
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

    @Override
    public void modificarExtra(Extra extra, int opcion) {

        if(opcion==1 || opcion==2){
            super.modificarExtra(extra, opcion);
        }else{
            Scanner scanner = new Scanner(System.in);
            Rotura rotura= (Rotura)  extra;
            System.out.println("Ingrese la nueva causa");
            rotura.setCausa(scanner.nextLine());
        }
    }
}
