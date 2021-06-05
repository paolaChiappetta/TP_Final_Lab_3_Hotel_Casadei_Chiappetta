package com.Hotel;

import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    private Hotel hotel = new Hotel();
    private Empleado empleadoActual;
    private Scanner scanner = new Scanner(System.in);
    private String continuar = "n";
    private int opcion;

    public Menu() {
    }

    public Empleado getEmpleadoActual() {
        return empleadoActual;
    }

    public void setEmpleadoActual(Empleado empleadoActual) {
        this.empleadoActual = empleadoActual;
    }


    public void ingreso() {
        System.out.println("1- Iniciar sesión");
        System.out.println("Ingrese 0 para salir");

    }

    public void opcionesInicioRecepcionista() {
        System.out.println("Ingrese una opción");
        System.out.println("1- Hotel");
        System.out.println("2- Mis datos");  //modif clave
        System.out.println("3- Cerrar sesión");
        System.out.println("Ingrese 0 para salir");
    }

    public void opcionesInicioAdministrador() {
        System.out.println("Ingrese una opción");
        System.out.println("1- Administración Hotel");
        System.out.println("2- Mis datos");  //modif clave
        System.out.println("3- Backup");
        System.out.println("4- Cerrar sesión");
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

    public void opcionesReservas() {
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

    public void opcionesListados() {
        System.out.println("Ingrese una opción");
        System.out.println("1- Ver lista de ingresos del día");
        System.out.println("2- Ver lista de egresos del día");
        System.out.println("3- Ver lista de ingresos de un día determinado");
        System.out.println("4- Ver lista de egresos de un día determinado");
        System.out.println("5- Ver lista de habitaciones");
        System.out.println("6- Ver lista de ocupaciones actuales");
        System.out.println("7- Volver al menú anterior");
        System.out.println("Ingrese 0 para salir");
    }

    public void opcionesAdministracionHotelAdministrador() {
        System.out.println("Ingrese una opción");
        System.out.println("1- Administración");
        System.out.println("2- Hotel");
        System.out.println("3- Volver al menú anterior");
        System.out.println("Ingrese 0 para salir");
    }

    public void opcionesAdministracionAdministrador() {
        System.out.println("Ingrese una opción");
        System.out.println("1- Empleados");
        System.out.println("2- Habitaciones");
        System.out.println("3- Shop");
        System.out.println("4- Volver al menú anterior");
        System.out.println("Ingrese 0 para salir");

    }

    public void opcionesEmpleadosAdministrador() {
        System.out.println("Ingrese una opción");
        System.out.println("1- Nuevo empleado");
        System.out.println("2- Modificar datos empleado");
        System.out.println("3- Eliminar empleado");
        System.out.println("4- Volver al menú anterior");
        System.out.println("Ingrese 0 para salir");
    }

    public void opcionesHabitacionesAdministrador() {
        System.out.println("Ingrese una opción");
        System.out.println("1- Nueva habitación");
        System.out.println("2- Modificar habitación");
        System.out.println("3- Eliminar habitación");
        System.out.println("4- Volver al menú anterior");
        System.out.println("Ingrese 0 para salir");
    }

    public void opcionesShopAdministracionAdministrador() {
        System.out.println("Ingrese una opción");
        System.out.println("1- Nuevo extra");
        System.out.println("2- Modificar un extra");
        System.out.println("3- Dar de baja un extra");
        System.out.println("4- Dar de alta un extra");
        System.out.println("5- Eliminar un extra");
        System.out.println("6- Volver al menú anterior");
        System.out.println("Ingrese 0 para salir");
    }

    public void opcionesMisDatos(){
        System.out.println("Ingrese una opción");
        System.out.println("1- Modificar contraseña");
        System.out.println("2- Volver al menú anterior");
        System.out.println("Ingrese 0 para salir");
    }



    public void inicio(Empleado empleado) {
        String usuario, contrasenia;
        do {
            ingreso();
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("Ingrese nombre de usuario");
                    usuario = scanner.nextLine();
                    System.out.println("Ingrese su contraseña");
                    contrasenia = scanner.nextLine();
                    this.setEmpleadoActual(empleado);
                    if (empleadoActual instanceof Recepcionista) {
                        menuInicioRecepcionista();
                    } else {
                        menuInicioAdministrador();
                    }
                    break;
                default:
                    System.out.println("Opción incorrecta. Ingrese nuevamente");
                    break;
            }
            scanner.nextLine();
            System.out.println("\nDesea ver otra opción?? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

        System.exit(0);
    }

    public void menuInicioRecepcionista() {
        do {
            opcionesInicioRecepcionista();
            opcion=scanner.nextInt();
            switch (opcion){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    menuHotel();
                    break;
                case 2:
                    menuMisDatos();
                    break;
                case 3:
                    inicio(empleadoActual);
                    break;
                default:
                    System.out.println("Opción incorrecta. Ingrese nuevamente");
                    break;

            }
            scanner.nextLine();
            System.out.println("\nDesea ver otra opción?? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

        inicio(empleadoActual);
    }

    public void menuInicioAdministrador() {
        do {
            opcionesInicioAdministrador();
            opcion=scanner.nextInt();
            switch (opcion){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    menuAdministracionHotelAdministrador();
                    break;
                case 2:
                    menuMisDatos();
                    break;
                case 3:
                    //backup
                    break;
                case 4:
                    inicio(empleadoActual);
                    break;
                default:
                    System.out.println("Opción incorrecta. Ingrese nuevamente");
                    break;

            }

            scanner.nextLine();
            System.out.println("\nDesea ver otra opción?? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

        inicio(empleadoActual);
    }

    public void menuHotel() {
        do {
            opcionesHotel();
            opcion=scanner.nextInt();
            switch (opcion){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    //check in
                    break;
                case 2:
                    //check out
                    break;
                case 3:
                    menuReservas();
                    break;
                case 4:
                    menuShop();
                    break;
                case 5:
                    menuListados();
                    break;
                case 6:
                    if(empleadoActual instanceof Recepcionista){
                        menuInicioRecepcionista();
                    }else {
                        menuAdministracionHotelAdministrador();
                    }
                    break;
                default:
                    System.out.println("Opción incorrecta. Ingrese nuevamente");
                    break;

            }

            scanner.nextLine();
            System.out.println("\nDesea ver otra opción?? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

        inicio(empleadoActual);
    }

    public void menuAdministracionHotelAdministrador(){
        do {
            opcionesAdministracionHotelAdministrador();
            opcion=scanner.nextInt();
            switch (opcion){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    menuAdministracionAdministrador();
                    break;
                case 2:
                    menuHotel();
                    break;
                case 3:
                    menuInicioAdministrador();
                    break;
                default:
                    System.out.println("Opción incorrecta. Ingrese nuevamente");
                    break;

            }

            scanner.nextLine();
            System.out.println("\nDesea ver otra opción?? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

        inicio(empleadoActual);
    }

    public void menuAdministracionAdministrador (){
        do {
            opcionesAdministracionAdministrador();
            opcion=scanner.nextInt();
            switch (opcion){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    menuEmpleadosAdministrador();
                    break;
                case 2:
                    menuHabitacionesAdministrador();
                    break;
                case 3:
                    menuShopAdministrador();
                    break;
                case 4:
                    menuAdministracionHotelAdministrador();
                    break;
                default:
                    System.out.println("Opción incorrecta. Ingrese nuevamente");
                    break;

            }

            scanner.nextLine();
            System.out.println("\nDesea ver otra opción?? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

        inicio(empleadoActual);
    }

    public void menuReservas (){
        do {
            opcionesReservas();
            opcion=scanner.nextInt();
            switch (opcion){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    hotel.nuevaReserva();
                    break;
                case 2:
                    //modif reserva
                    break;
                case 3:
                    //eliminar reserva
                    break;
                case 4:
                    menuHotel();
                    break;
                default:
                    System.out.println("Opción incorrecta. Ingrese nuevamente");
                    break;

            }

            scanner.nextLine();
            System.out.println("\nDesea ver otra opción?? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

        inicio(empleadoActual);
    }

    public void menuShop (){
        do {
            opcionesShop();
            opcion=scanner.nextInt();
            switch (opcion){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    hotel.getShop().cargarExtraHabitacion(hotel, empleadoActual);
                    break;
                case 2:
                    hotel.getShop().eliminarExtraHabitacion(hotel);
                    break;
                case 3:
                    hotel.getShop().verListaServicios(empleadoActual);
                    break;
                case 4:
                    hotel.getShop().verListaAmenities(empleadoActual);
                    break;
                case 5:
                    hotel.getShop().verListaMinibar(empleadoActual);
                    break;
                case 6:
                    hotel.getShop().verListaRotura(empleadoActual);
                    break;
                case 7:
                    menuHotel();
                    break;
                default:
                    System.out.println("Opción incorrecta. Ingrese nuevamente");
                    break;
            }

            scanner.nextLine();
            System.out.println("\nDesea ver otra opción?? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

        inicio(empleadoActual);
    }

    public void menuListados (){
        do {
            opcionesListados();
            opcion=scanner.nextInt();
            switch (opcion){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    hotel.listadoIngresosDelDia();
                    break;
                case 2:
                    hotel.listadoEgresosDelDia();
                    break;
                case 3:
                    System.out.println("Ingrese la fecha que desea ver (AAAA-MM-DD)");
                    hotel.listadoIngresosDeReservasDeDiaDeterminado(LocalDate.parse(scanner.nextLine()));
                    break;
                case 4:
                    System.out.println("Ingrese la fecha que desea ver (AAAA-MM-DD)");
                    hotel.listadoEgresosDeDiaDeterminado(LocalDate.parse(scanner.nextLine()));
                    break;
                case 5:
                    hotel.listadoHabitaciones();
                    break;
                case 6:
                    hotel.listadoOcupaciones();
                    break;
                case 7:
                    menuHotel();
                    break;
                default:
                    System.out.println("Opción incorrecta. Ingrese nuevamente");
                    break;
            }

            scanner.nextLine();
            System.out.println("\nDesea ver otra opción?? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

        inicio(empleadoActual);
    }

    public void menuMisDatos (){
        do {
            opcionesMisDatos();
            opcion=scanner.nextInt();
            switch (opcion){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    //modif contraseña
                    break;
                case 2:
                    if(empleadoActual instanceof Recepcionista){
                        menuInicioRecepcionista();
                    }else{
                        menuInicioAdministrador();
                    }
                    break;
                default:
                    System.out.println("Opción incorrecta. Ingrese nuevamente");
                    break;
            }

            scanner.nextLine();
            System.out.println("\nDesea ver otra opción?? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

        inicio(empleadoActual);
    }


    public void menuEmpleadosAdministrador (){
        do {
            opcionesEmpleadosAdministrador();
            opcion=scanner.nextInt();
            switch (opcion){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    //nuevo empleado
                    break;
                case 2:
                    //modif empleado
                    break;
                case 3:
                    //eliminar empleado
                    break;
                case 4:
                    menuAdministracionAdministrador();
                    break;
                default:
                    System.out.println("Opción incorrecta. Ingrese nuevamente");
                    break;
            }

            scanner.nextLine();
            System.out.println("\nDesea ver otra opción?? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

        inicio(empleadoActual);
    }

    public void menuHabitacionesAdministrador (){
        do {
            opcionesHabitacionesAdministrador();
            opcion=scanner.nextInt();
            switch (opcion){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    //nuevo hab
                    break;
                case 2:
                    //modif hab
                    break;
                case 3:
                    //eliminar hab
                    break;
                case 4:
                    menuAdministracionAdministrador();
                    break;
                default:
                    System.out.println("Opción incorrecta. Ingrese nuevamente");
                    break;
            }

            scanner.nextLine();
            System.out.println("\nDesea ver otra opción?? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

        inicio(empleadoActual);
    }

    public void menuShopAdministrador (){
        do {
            opcionesShopAdministracionAdministrador();
            opcion=scanner.nextInt();
            switch (opcion){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    hotel.getShop().nuevoExtra();
                    break;
                case 2:
                    hotel.getShop().modificarExtra();
                    break;
                case 3:
                    hotel.getShop().bajaExtra();
                    break;
                case 4:
                    hotel.getShop().altaExtra();
                    break;
                case 5:
                    hotel.getShop().eliminarExtra();
                    break;
                case 6:
                    menuAdministracionAdministrador();
                    break;
                default:
                    System.out.println("Opción incorrecta. Ingrese nuevamente");
                    break;
            }

            scanner.nextLine();
            System.out.println("\nDesea ver otra opción?? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

        inicio(empleadoActual);
    }
}
