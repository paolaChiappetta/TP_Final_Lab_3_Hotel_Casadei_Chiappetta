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

    public void opcionesPrincipales() {
        System.out.println("Ingrese una opción");
        System.out.println("1- Pasajero");
        System.out.println("2- Empleado");
        System.out.println("3- Hotel");
        System.out.println("4- Shop");
        System.out.println("Ingrese 0 para salir");
    }

    public void opcionesPasajero() {
        System.out.println("1- Nuevo Pasajero");
        System.out.println("2- Modificar de datos de pasajero");
        System.out.println("3- Ver datos de pasajero");
        System.out.println("4- Ver lista de hospedajes de pasajero");
        System.out.println("5- Ver lista de reservas de pasajero");
        System.out.println("6- Volver al menú anterior");
        System.out.println("Ingrese 0 para salir");
    }

    public void opcionesEmpleadoRecepcionista() {
        System.out.println("1- Modificar mis datos");
        System.out.println("2- Cambiar mi contraseña");
        System.out.println("3- Volver al menú anterior");
        System.out.println("Ingrese 0 para salir");
    }

    public void opcionesEmpleadoAdministrador() {
        System.out.println("1- Modificar mis datos");
        System.out.println("2- Cambiar mi contraseña");
        System.out.println("3- Nuevo empleado");
        System.out.println("4- Modificar datos de empleado");
        System.out.println("6- Eliminar empleado");
        System.out.println("5- Volver al menú anterior");
        System.out.println("Ingrese 0 para salir");
    }

    public void opcionesHotelRecepcionista() {
        System.out.println("1- Ver lista de ingresos del día");
        System.out.println("2- Ver lista de egresos del día");
        System.out.println("3- Ver lista de habitaciones");
        System.out.println("4- Ver lista de ocupaciones actuales");
        System.out.println("5- Nueva reserva");
        System.out.println("6- Modificar una reserva");
        System.out.println("7- Eliminar una reserva");
        System.out.println("8- Nueva ocupación sin reserva");
        System.out.println("9- Volver al menú anterior");
        System.out.println("Ingrese 0 para salir");

    }

    public void opcionesHotelAdministrador() {
        System.out.println("1- Ver lista de ingresos del día");
        System.out.println("2- Ver lista de egresos del día");
        System.out.println("3- Ver lista de habitaciones");
        System.out.println("4- Ver lista de ocupaciones actuales");
        System.out.println("5- Nueva reserva");
        System.out.println("6- Modificar una reserva");
        System.out.println("7- Eliminar una reserva");
        System.out.println("8- Nueva ocupación sin reserva");
        System.out.println("9- Nueva habitación");
        System.out.println("10- Modificar datos de una habitación");
        System.out.println("11- Eliminar una habitación");
        System.out.println("12- Volver al menú anterior");
        System.out.println("Ingrese 0 para salir");

    }

    public void opcionesShopRecepcionista() {
        System.out.println("1- Ver lista de servicios");
        System.out.println("2- Ver Ver lista de amenities");
        System.out.println("3- Ver lista de productos del minibar");
        System.out.println("4- Ver lista de roturas");
        System.out.println("5- Cargar extra a una habitación");
        System.out.println("6- Eliminar extra de una habitación");
        System.out.println("7- Volver al menú anterior");
        System.out.println("Ingrese 0 para salir");
    }

    public void opcionesShopAdministrador() {
        System.out.println("1- Ver lista de servicios");
        System.out.println("2- Ver Ver lista de amenities");
        System.out.println("3- Ver lista de productos del minibar");
        System.out.println("4- Ver lista de roturas");
        System.out.println("5- Cargar extra a una habitación");
        System.out.println("6- Eliminar extra de una habitación");
        System.out.println("7- Nuevo extra");
        System.out.println("8- Modificar un extra");
        System.out.println("9- Dar de baja un extra");
        System.out.println("9- Eliminar un extra");
        System.out.println("10- Volver al menú anterior");
        System.out.println("Ingrese 0 para salir");
    }

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

    }
}
