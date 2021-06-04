package com.Hotel;

import java.awt.event.KeyEvent;
import java.util.Scanner;

public class Menu {
    private Empleado empleadoActual;
    private Scanner scanner = new Scanner(System.in);
    private String continuar = "n";
    private int opcion;

    public Menu(Empleado empleadoActual) {
        this.empleadoActual = empleadoActual;
    }

    public void opcionesPrincipales(){
        System.out.println("Ingrese una opción");
        System.out.println("1- Pasajero");
        System.out.println("2- Empleado");
        System.out.println("3- Hotel");
        System.out.println("4- Shop");
        System.out.println("Ingrese 0 para salir");
    }

    public void opcionesPasajero(){
        System.out.println("1- Nuevo Pasajero");
        System.out.println("2- Modificar de datos de pasajero");
        System.out.println("3- Ver datos de pasajero");
        System.out.println("4- Ver lista de hospedajes de pasajero");
        System.out.println("5- Ver lista de reservas de pasajero");
        System.out.println("6- Volver al menú anterior");
        System.out.println("Ingrese 0 para salir");
    }

    public void opcionesEmpleadoRecepcionista(){
        System.out.println("1- Modificar mis datos");
        System.out.println("2- Cambiar mi contraseña");
        System.out.println("3- Volver al menú anterior");
        System.out.println("Ingrese 0 para salir");
    }

    public void opcionesEmpleadoAdministrador(){
        System.out.println("1- Modificar mis datos");
        System.out.println("2- Cambiar mi contraseña");
        System.out.println("3- Nuevo empleado");
        System.out.println("4- Modificar datos de empleado");
        System.out.println("5- Volver al menú anterior");
        System.out.println("Ingrese 0 para salir");
    }

    public void opcionesHotelRecepcionista (){
        System.out.println("1- Ver lista de ingresos del día");
        System.out.println("2- Ver lista de habitaciones");
        System.out.println("3- Nuevo empleado");
        System.out.println("4- Modificar datos de empleado");
        System.out.println("5- Volver al menú anterior");
        System.out.println("Ingrese 0 para salir");

    }

    public void opcionesHotelAdministrador (){

    }

    public void menuPrincipal(){
        do{
            opcionesPrincipales();
            opcion=scanner.nextInt();

            switch (opcion){
                case 1:
                    menuPasajero();
                    break;
                case 2:
                    opcionesEmpleadoAdministrador();
                    break;
                case 3:
                    System.out.println("hotel");
                    break;
                case 4:
                    System.out.println("shop");
                    break;
                default:
                    System.out.println("Opción incorrecta. Ingrese nuevamente");
                    break;


            }

            scanner.nextLine();
            System.out.println("Desea ver otra opción?? s/n");
            continuar=scanner.nextLine();

        }while (continuar.equalsIgnoreCase("s"));

    }

    public void menuPasajero(){
        do{

            opcionesPasajero();
            opcion=scanner.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("cargar pasajero");
                    break;
                case 2:
                    System.out.println("modif pasajero");
                    break;
                case 10: //if empleado instance of
                    menuPrincipal();
                    break;
                default:
                    System.out.println("Opción incorrecta. Ingrese nuevamente");
                    break;
            }
            scanner.nextLine();
            System.out.println("Desea ver otra opción? s/n");
            continuar=scanner.nextLine();

        }while (continuar.equalsIgnoreCase("s"));

    }
}
