package com.Hotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Recepcionista extends Empleado implements InterfazAccion{

    //constructores

    public Recepcionista() { }


    public Recepcionista(String nombre, String apellido) {
        super(nombre, apellido);

    }

    //Overrides de InterfazAccion

    /// modificar estado de habitacion

    Scanner scanner = new Scanner(System.in);

    @Override
    public void menuModificarHabitacion() {

        System.out.println("1: Estado");
        System.out.println("2: Fecha proxima ocupacion");

        System.out.println("0 para Finalizar");

    }


    @Override
    public void modificarHabitacion(Habitacion habitacion) {
        System.out.println("Indique el dato que desea modificar: ");
        int opcion = 0;


        do {
            menuModificarHabitacion();
            opcion = scanner.nextInt();
            switch (opcion) {

                case 1:
                    System.out.println("Estado:");
                    habitacion.indicarEstadoHabitacion();
                    break;


                case 2:
                    System.out.println("Fecha de proxima ocupacion:");
                    habitacion.getFechaProximaOcupacion(LocalDate.parse(scanner.next(), DateTimeFormatter.BASIC_ISO_DATE));
                    break;

                default:
                    System.out.println("Opcion incorrecta, ingrese nuevamente");
                    break;
            }

        } while (opcion != 0);

    }


    @Override
    public String toString() {
        return super.toString();
    }

}
