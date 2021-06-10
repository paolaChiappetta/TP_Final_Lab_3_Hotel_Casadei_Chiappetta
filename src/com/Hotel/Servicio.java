package com.Hotel;

import org.w3c.dom.ls.LSOutput;

import java.io.Serializable;
import java.util.Scanner;

public class Servicio extends Extra  implements Serializable {

    //Atributos
    private String empleadoEncargado;

    //Constructor vacío
    public Servicio() {
    }

    //Constructor con algunos datos
    public Servicio(String nombre, Double precio, String empleadoEncargado) {
        super(nombre, precio);
        this.empleadoEncargado = empleadoEncargado;
    }

    //Constructor completo
    public Servicio(String nombre, Double precio, boolean alta, Integer cantidad, String empleadoEncargado) {
        super(nombre, precio, alta, cantidad);
        this.empleadoEncargado = empleadoEncargado;
    }

    //Getters y setters
    public String getEmpleadoEncargado() {
        return empleadoEncargado;
    }

    public void setEmpleadoEncargado(String empleadoEncargado) {
        this.empleadoEncargado = empleadoEncargado;
    }

    @Override
    public void modificarExtra(Extra extra, int opcion) {

        if(opcion==1 || opcion==2){
            super.modificarExtra(extra, opcion);
        }else{
            Scanner scanner = new Scanner(System.in);
            Servicio servicio= (Servicio) extra;
            System.out.println("Ingrese el nuevo empleado a cargo");
            servicio.setEmpleadoEncargado(scanner.nextLine());
        }
    }

    @Override
    public String mostrarExtra() {
        return super.mostrarExtra() + "Solicitar a el/la " + this.empleadoEncargado + "\n";
    }
}
