package com.Hotel;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Administrador extends Empleado implements InterfazAccion, Serializable {

    //constructor vacío
    public Administrador() {
    }

    //constructor con datos p/ generación de usuario y contraseña
    public Administrador(String nombre, String apellido, String numeroTel, String dni) {
        super(nombre, apellido, numeroTel, dni);
    }

    //constructor completo
    public Administrador(String nombre, String apellido, String numerotel, String dni, String usuario, String clave) {
        super(nombre, apellido, numerotel, dni, usuario, clave);
    }

    ///Override de la interfazAccion


@Override
    public void menuModificarHabitacion() {

        System.out.println("1: Numero habitacion");
        System.out.println("2: Piso");
        System.out.println("3: Tipo de Habitacion- Tarifa");
        System.out.println("4: Estado de habitacion");

        System.out.println("\n0 para finalizar");

    }

    //MODIFICAR UNA HABITACION, la recibe por parametro
    @Override
    public void modificarHabitacion(Habitacion habitacion) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Indique que datos desea modificar: ");
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
                    System.out.println("Tarifa:");
                    habitacion.indicarTipoHabitacion();
                    break;
                case 4:
                    System.out.println("Estado:");
                    habitacion.indicarEstadoHabitacion();
                    break;

                default:
                    System.out.println("Opcion incorrecta, ingrese nuevamente");
                    break;
            }
        } while (opcion != 0);
    }




    public void menuModificarEmpleado() {
        System.out.println("1: Nombre");
        System.out.println("2: Apellido");
        System.out.println("3: Dni");
        System.out.println("4: Telefono");


        System.out.println("\n0 para finalizar");
    }


    public void modificarEmpleado(Empleado empleado) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Indique que datos desea modificar: ");
        int opcion = 0;


        do {
            menuModificarEmpleado();
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Nombre:");
                    empleado.setNombre(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("Apellido:");
                    empleado.setApellido(scanner.nextLine());
                    break;
                case 3:
                    System.out.println("Dni:");
                    empleado.setDni(scanner.nextLine());
                    break;
                case 4:
                    System.out.println("Telefono:");
                    empleado.setNumeroTel(scanner.nextLine());
                    break;


                default:
                    System.out.println("Opcion incorrecta, ingrese nuevamente");
                    break;
            }
        } while (opcion != 0);
    }

}

