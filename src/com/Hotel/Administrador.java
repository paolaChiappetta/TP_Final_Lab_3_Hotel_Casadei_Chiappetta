package com.Hotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Administrador extends Empleado implements InterfazAccion {


    Scanner scanner = new Scanner(System.in);

    //constructores

    public Administrador() { }

    public Administrador(String nombre, String apellido) {
        super(nombre, apellido);
    }


    ///Override de la interfazAccion

    @Override
    public void menuModificarHabitacion() {

        System.out.println("1: Numero");
        System.out.println("2: Piso");
        System.out.println("3: Estado");
        System.out.println("4: Tarifa");
        System.out.println("5: Fecha proxima ocupacion");

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
                    System.out.println("Numero:");
                    habitacion.setNumero(scanner.nextInt());
                    break;

                case 2:
                    System.out.println("Piso:");
                    habitacion.setPiso(scanner.nextInt());
                    break;
                case 3:
                    System.out.println("Estado:");
                    habitacion.indicarEstadoHabitacion();
                    break;

                case 4:
                    System.out.println("Tarifa:");
                    habitacion.indicarTipoHabitacion();
                    break;

                case 5:
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

