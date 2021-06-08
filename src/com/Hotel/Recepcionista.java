package com.Hotel;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Recepcionista extends Empleado implements InterfazAccion, Serializable {

    //constructor vacío
    public Recepcionista() {
    }

    //constructor con datos p/ generación de usuario y contraseña
    public Recepcionista(String nombre, String apellido, String numeroTel, String dni) {
        super(nombre, apellido, numeroTel, dni);
    }

    //constructor completo
    public Recepcionista(String nombre, String apellido, String numerotel, String dni, String usuario, String clave) {
        super(nombre, apellido, numerotel, dni, usuario, clave);
    }

    //Overrides de InterfazAccion

    /// modificar estado de habitacion

    @Override
    public void menuModificarHabitacion() {

        System.out.println("1: Estado");

        System.out.println("0 para Finalizar");

    }


    @Override
    public void modificarHabitacion(Habitacion habitacion) {
        Scanner scanner = new Scanner(System.in);
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


                default:
                    System.out.println("Opcion incorrecta, ingrese nuevamente");
                    break;
            }

        } while (opcion != 0);

    }


}
