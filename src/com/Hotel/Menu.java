package com.Hotel;

import java.util.Scanner;

public class Menu {
    private Empleado empleadoActual;
    private Scanner scanner = new Scanner(System.in);
    private String continuar = "n";
    private int opcion;

    public Menu(Empleado empleadoActual) {
        this.empleadoActual = empleadoActual;
    }

    public Empleado getEmpleadoActual() {
        return empleadoActual;
    }

    public void setEmpleadoActual(Empleado empleadoActual) {
        this.empleadoActual = empleadoActual;
    }

    public void ingreso (){
        System.out.println("1- Iniciar sesión");
        System.out.println("Ingrese 0 para salir");

    }

    public void opcionesInicioRecepcionista (){
        System.out.println("Ingrese una opción");
        System.out.println("1- Hotel");
        System.out.println("2- Mis datos");  //modif clave
        System.out.println("Ingrese 0 para salir");
    }

    public void opcionesInicioAdministrador (){
        System.out.println("Ingrese una opción");
        System.out.println("1- Administración Hotel");
        System.out.println("2- Mis datos");  //modif clave
        System.out.println("3- Backup");
        System.out.println("Ingrese 0 para salir");
    }

    public void opcionesHotel() {
        System.out.println("Ingrese una opción");
        System.out.println("1- Check-in");
        System.out.println("2- Check-out");
        System.out.println("3- Reservas");
        System.out.println("4- Shop");
        System.out.println("5- Listados");
        System.out.println("6- Volver al menú anterior");
        System.out.println("Ingrese 0 para salir");
    }

    public void opcionesReservas(){
        System.out.println("Ingrese una opción");
        System.out.println("1- Nueva reserva");
        System.out.println("2- Modificar una reserva");
        System.out.println("3- Eliminar una reserva");
        System.out.println("4- Volver al menú anterior");
        System.out.println("Ingrese 0 para salir");
    }

    public void opcionesShop() {
        System.out.println("Ingrese una opción");
        System.out.println("1- Cargar extra a una habitación");
        System.out.println("2- Eliminar extra de una habitación");
        System.out.println("3- Ver lista de servicios");
        System.out.println("4- Ver Ver lista de amenities");
        System.out.println("5- Ver lista de productos del minibar");
        System.out.println("6- Ver lista de roturas");
        System.out.println("7- Volver al menú anterior");
        System.out.println("Ingrese 0 para salir");
    }

    public void opcionesListados(){
        System.out.println("Ingrese una opción");
        System.out.println("1- Ver lista de ingresos del día");
        System.out.println("2- Ver lista de egresos del día");
        System.out.println("3- Ver lista de habitaciones");
        System.out.println("4- Ver lista de ocupaciones actuales");
        System.out.println("5- Volver al menú anterior");
        System.out.println("Ingrese 0 para salir");
    }

    public void opcionesAdministracionHotelAdministrador(){
        System.out.println("Ingrese una opción");
        System.out.println("1- Administración");
        System.out.println("2- Hotel");
        System.out.println("3- Volver al menú anterior");
        System.out.println("Ingrese 0 para salir");
    }

    public void opcionesAdministracionAdministrador(){
        System.out.println("Ingrese una opción");
        System.out.println("1- Empleados");
        System.out.println("2- Habitaciones");
        System.out.println("3- Shop");
        System.out.println("4- Volver al menú anterior");
        System.out.println("Ingrese 0 para salir");

    }

    public void opcionesEmpleadosAdministrador(){
        System.out.println("Ingrese una opción");
        System.out.println("1- Nuevo empleado");
        System.out.println("2- Modificar datos empleado");
        System.out.println("3- Eliminar empleado");
        System.out.println("4- Volver al menú anterior");
        System.out.println("Ingrese 0 para salir");
    }

    public void opcionesHabitacionesAdministrador(){
        System.out.println("Ingrese una opción");
        System.out.println("1- Nueva habitación");
        System.out.println("2- Modificar habitación");
        System.out.println("3- Eliminar habitación");
        System.out.println("4- Volver al menú anterior");
        System.out.println("Ingrese 0 para salir");
    }

    public void opcionesShopAdministracionAdministrador(){
        System.out.println("Ingrese una opción");
        System.out.println("1- Nuevo extra");
        System.out.println("2- Modificar un extra");
        System.out.println("3- Dar de baja un extra");
        System.out.println("4- Dar de alta un extra");
        System.out.println("5- Eliminar un extra");
        System.out.println("6- Volver al menú anterior");
        System.out.println("Ingrese 0 para salir");
    }





/*
    public void menuPrincipal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        do {
            opcionesPrincipales();

            opcion = scanner.nextInt();

            switch (opcion) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    menuPasajero();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                default:
                    System.out.println("Opción incorrecta. Ingrese nuevamente");
                    break;


            }
            scanner.nextLine();
            System.out.println("Desea ver otra opción?? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

    }

    public void menuPasajero() {
        do {

            opcionesPasajero();
            opcion = scanner.nextInt();


            switch (opcion) {
                case 0:
                    menuPrincipal();
                    break;

                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                default:
                    System.out.println("Opción incorrecta. Ingrese nuevamente");
                    break;
            }
            scanner.nextLine();
            System.out.println("Desea ver otra opción? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

    }

    public void menuEmpleadoRecepcionista() {
        do {

            opcionesEmpleadoRecepcionista();
            opcion = scanner.nextInt();


            switch (opcion) {
                case 0:

                    break;

                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                default:
                    System.out.println("Opción incorrecta. Ingrese nuevamente");
                    break;
            }
            scanner.nextLine();
            System.out.println("Desea ver otra opción? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

    }

    public void menuEmpleadoAdminstrador() {
        do {

            opcionesEmpleadoAdministrador();
            opcion = scanner.nextInt();


            switch (opcion) {
                case 0:

                    break;

                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                default:
                    System.out.println("Opción incorrecta. Ingrese nuevamente");
                    break;
            }
            scanner.nextLine();
            System.out.println("Desea ver otra opción? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

    }

    public void menuHotelRecepcionista() {
        do {

            opcionesHotelRecepcionista();
            opcion = scanner.nextInt();


            switch (opcion) {
                case 0:

                    break;

                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                default:
                    System.out.println("Opción incorrecta. Ingrese nuevamente");
                    break;
            }
            scanner.nextLine();
            System.out.println("Desea ver otra opción? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

    }

    public void menuHotelAdminstrador() {
        do {

            opcionesHotelAdministrador();
            opcion = scanner.nextInt();


            switch (opcion) {
                case 0:

                    break;

                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                default:
                    System.out.println("Opción incorrecta. Ingrese nuevamente");
                    break;
            }
            scanner.nextLine();
            System.out.println("Desea ver otra opción? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

    }

    public void menuShopRecepcionista() {
        do {

            opcionesShopRecepcionista();
            opcion = scanner.nextInt();


            switch (opcion) {
                case 0:

                    break;

                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                default:
                    System.out.println("Opción incorrecta. Ingrese nuevamente");
                    break;
            }
            scanner.nextLine();
            System.out.println("Desea ver otra opción? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

    }

    public void menuShopAdminstrador() {
        do {

            opcionesShopAdministrador();
            opcion = scanner.nextInt();


            switch (opcion) {
                case 0:

                    break;

                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                default:
                    System.out.println("Opción incorrecta. Ingrese nuevamente");
                    break;
            }
            scanner.nextLine();
            System.out.println("Desea ver otra opción? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

    }*/
}
