package com.Hotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Administrador extends Empleado implements InterfazAccion {


    Scanner scanner = new Scanner(System.in);

    //constructores

    public Administrador() { }

    public Administrador(String nombre, String apellido, String numeroTel) {

        super(nombre, apellido, numeroTel);

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


    public Empleado generarNuevoEmpleado (){

        String nombre, apellido, telefono;
        int opcion;

        System.out.println("Nombre:");
        nombre= scanner.nextLine();
        System.out.println("Apellio:");
        apellido= scanner.nextLine();
        System.out.println("Telefono:");
        telefono= scanner.nextLine();

        System.out.println("Indique:  1= Recepcionista   2= Administrador");
        opcion= scanner.nextInt();

        if(opcion== 1){

            Recepcionista recepcionista= new Recepcionista(nombre, apellido, telefono);

            return recepcionista;
        }else{

            Administrador administrador= new Administrador(nombre, apellido, telefono);

            return administrador;
        }

    }



    @Override
    public String toString() {
        return super.toString();
    }


}

