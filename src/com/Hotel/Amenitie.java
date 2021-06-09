package com.Hotel;

import java.io.Serializable;
import java.util.Scanner;

public class Amenitie extends Extra implements Serializable, InterfazExtra  {

    private String descripcion;
    private String horario;

    public Amenitie() {
    }

    public Amenitie(String nombre, Double precio, String descripcion, String horario) {
        super(nombre, precio);
        this.descripcion = descripcion;
        this.horario = horario;
    }

    public Amenitie(String nombre, Double precio, boolean alta, Integer cantidad, String descripcion, String horario) {
        super(nombre, precio, alta, cantidad);
        this.descripcion = descripcion;
        this.horario = horario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String mostrarExtra() {
        return super.mostrarExtra() + "Descripción: " + this.descripcion +
                "\nHorario: " + this.horario + "\n";
    }

    @Override
    public void modificarExtra(Extra extra, int opcion) {

        if(opcion==1 || opcion==2){
            super.modificarExtra(extra, opcion);
        }else if (opcion==3){
            Scanner scanner = new Scanner(System.in);
            Amenitie amenitie= (Amenitie) extra;
            System.out.println("Ingrese la nueva descripción");
            amenitie.setDescripcion(scanner.nextLine());
        }else{
            Scanner scanner = new Scanner(System.in);
            Amenitie amenitie= (Amenitie) extra;
            System.out.println("Ingrese el nuevo horario");
            amenitie.setHorario(scanner.nextLine());
        }
    }
}
