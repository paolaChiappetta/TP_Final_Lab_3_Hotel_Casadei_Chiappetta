package com.Hotel;


import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
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
        System.out.println("2- Mis datos");
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
        System.out.println("4- Extender estadía");
        System.out.println("5- Shop");
        System.out.println("6- Listados");
        System.out.println("7- Volver al menú anterior");
        System.out.println("Ingrese 0 para salir");
    }

    public void opcionesReservas() {
        System.out.println("Ingrese una opción");
        System.out.println("1- Nueva reserva");
        System.out.println("2- Modificar una reserva");
        System.out.println("3- Eliminar una reserva");
        System.out.println("4- Ver una reserva");
        System.out.println("5- Ver lista de reservas por habitación");
        System.out.println("6- Volver al menú anterior");
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
        System.out.println("6- Ver lista de habitaciones por estado");
        System.out.println("7- Ver lista de ocupaciones actuales");
        System.out.println("8- Volver al menú anterior");
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

    public void inicio () {
        Archivo archivo=new Archivo();
        hotel.setEmpleados(archivo.readerArchivoEmpleado("empleado.json")); //al ingreso se cargan las listas de empleados p/verificar usuario y contraseña
        do {
            ingreso();
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 0:
                    this.guardarListas();
                    System.exit(0);
                    break;
                case 1:
                    String usuario, contrasenia;
                    /*
                    System.out.println("Ingrese nombre de usuario");
                    usuario = scanner.nextLine();
                    System.out.println("Ingrese su contraseña");
                    contrasenia = scanner.nextLine();
                    this.setEmpleadoActual(hotel.verificarUsuarioyContrasenia(usuario, contrasenia));*/
                    Administrador administrador = new Administrador();
                    this.setEmpleadoActual(administrador);
                    if(empleadoActual!=null){
                        cargaListas();  //si pudo ingresar un empleado, se cargan las demás listas del hotel
                        if (empleadoActual instanceof Recepcionista) {
                            menuInicioRecepcionista();
                        } else {
                            menuInicioAdministrador();
                        }
                    }
                    break;
                default:
                    System.out.println("Opción incorrecta. Ingrese nuevamente");
                    break;
            }

            System.out.println("\nDesea ver otra opción?? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

        System.exit(0);
    }

    public void menuInicioRecepcionista() {
        do {
            opcionesInicioRecepcionista();
            opcion=scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 0:
                    this.guardarListas();
                    System.exit(0);
                    break;
                case 1:
                    menuHotel();
                    break;
                case 2:
                    menuMisDatos();
                    break;
                case 3:
                    inicio();
                    break;
                default:
                    System.out.println("Opción incorrecta. Ingrese nuevamente");
                    break;

            }

            System.out.println("\nDesea ver otra opción?? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

        inicio();
    }

    public void menuInicioAdministrador() {
        do {
            opcionesInicioAdministrador();
            opcion=scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 0:
                    this.guardarListas();
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
                    inicio();
                    break;
                default:
                    System.out.println("Opción incorrecta. Ingrese nuevamente");
                    break;

            }


            System.out.println("\nDesea ver otra opción?? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

        inicio();
    }

    public void menuHotel() {
        do {
            opcionesHotel();
            opcion=scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 0:
                    this.guardarListas();
                    System.exit(0);
                    break;
                case 1:
                    hotel.checkIn();
                    break;
                case 2:
                    System.out.println("Check-Out");
                    int nroHabitacion=0;
                    do{
                        try{
                            System.out.println("\nIngrese el número de habitación: ");
                            nroHabitacion= scanner.nextInt();
                            scanner.nextLine();
                        }catch (InputMismatchException e){
                            System.out.println("Debe ingresar un número");
                            scanner.nextLine();
                        }catch (Exception e){
                            System.out.println("Problema detectado");
                        }
                    }while (nroHabitacion==0);
                    hotel.checkOut(nroHabitacion);
                    break;
                case 3:
                    menuReservas();
                    break;
                case 4:
                    int numero=0;
                    int noches=0;
                    do{
                        try{
                            System.out.println("Ingrese el número de habitación que desea extender la salida");
                            numero=scanner.nextInt();
                            scanner.nextLine();
                        }catch (InputMismatchException e){
                            System.out.println("Debe ingresar un número");
                            scanner.nextLine();
                        }catch (Exception e){
                            System.out.println("Problema detectado");
                            scanner.nextLine();
                        }
                    }while (numero==0);
                    do{
                        try{
                            System.out.println("Ingrese cuántas noches desea extender la salida");
                            noches=scanner.nextInt();
                            scanner.nextLine();
                        }catch (InputMismatchException e){
                            System.out.println("Debe ingresar un número");
                            scanner.nextLine();
                        }catch (Exception e){
                            System.out.println("Problema detectado");
                            scanner.nextLine();
                        }
                    }while (noches==0);
                    hotel.extenderFechaSalida(numero, noches);
                    break;
                case 5:
                    menuShop();
                    break;
                case 6:
                    menuListados();
                    break;
                case 7:
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

            System.out.println("\nDesea ver otra opción?? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

        inicio();
    }

    public void menuAdministracionHotelAdministrador(){
        do {
            opcionesAdministracionHotelAdministrador();
            opcion=scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 0:
                    this.guardarListas();
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

            System.out.println("\nDesea ver otra opción?? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

        inicio();
    }

    public void menuAdministracionAdministrador (){
        do {
            opcionesAdministracionAdministrador();
            opcion=scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 0:
                    this.guardarListas();
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

            System.out.println("\nDesea ver otra opción?? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

        inicio();
    }

    public void menuReservas (){
        do {
            opcionesReservas();
            opcion=scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 0:
                    this.guardarListas();
                    System.exit(0);
                    break;
                case 1:
                    hotel.nuevaReserva();
                    break;
                case 2:
                    hotel.modificarReserva();
                    break;
                case 3:
                    long idReserva=0;
                    do{
                        try{
                            System.out.println("Ingrese el ID de la reserva que desea eliminar");
                            hotel.eliminarReserva(scanner.nextLong());
                            scanner.nextLine();
                        }catch (InputMismatchException e){
                            System.out.println("Debe ingresar un número");
                            scanner.nextLine();
                        }catch (Exception e){
                            System.out.println("Problema detectado");
                            scanner.nextLine();
                        }
                    }while (idReserva==0);
                    break;
                case 4:
                    System.out.println("\nIngrese el Dni del pasajero");
                    hotel.listadoReservasPorDni(scanner.nextLine());
                    break;
                case 5:
                    int nroHabitacion=0;
                    do{
                        try{
                            System.out.println("Ingrese el número de la habitación de la que desea ver las reservas");
                            nroHabitacion=scanner.nextInt();
                            scanner.nextLine();
                        }catch (InputMismatchException e){
                            System.out.println("Debe ingresar un número");
                            scanner.nextLine();
                        }catch (Exception e){
                            System.out.println("Problema detectado");
                            scanner.nextLine();
                        }
                    }while (nroHabitacion==0);
                    hotel.listadoReservasPorHabitacion(nroHabitacion);
                    break;
                case 6:
                    menuHotel();
                    break;
                default:
                    System.out.println("Opción incorrecta. Ingrese nuevamente");
                    break;

            }

            System.out.println("\nDesea ver otra opción?? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

        inicio();
    }

    public void menuShop (){
        do {
            opcionesShop();
            opcion=scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 0:
                    this.guardarListas();
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

            System.out.println("\nDesea ver otra opción?? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

        inicio();
    }

    public void menuListados (){
        do {
            opcionesListados();
            opcion=scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 0:
                    this.guardarListas();
                    System.exit(0);
                    break;
                case 1:
                    hotel.listadoIngresosDelDia();
                    break;
                case 2:
                    hotel.listadoEgresosDelDia();
                    break;
                case 3:
                    LocalDate fechaIngresos=null;
                    do{
                        try{
                            System.out.println("Ingrese la fecha que desea ver (AAAA-MM-DD)");
                            fechaIngresos=LocalDate.parse(scanner.nextLine());
                        } catch (DateTimeParseException e) {
                            System.out.println("\nIngrese la fecha nuevamente en el formato indicado");
                            fechaIngresos= null;
                        } catch (Exception e) {
                            System.out.println("\nIngrese la fecha nuevamente");
                            fechaIngresos = null;
                        }
                    }while (fechaIngresos==null);
                    hotel.listadoIngresosDeReservasDeDiaDeterminado(fechaIngresos);
                    break;
                case 4:
                    LocalDate fechaEgresos=null;
                    do{
                        try{
                            System.out.println("Ingrese la fecha que desea ver (AAAA-MM-DD)");
                            fechaEgresos=LocalDate.parse(scanner.nextLine());
                        } catch (DateTimeParseException e) {
                            System.out.println("\nIngrese la fecha nuevamente en el formato indicado");
                            fechaEgresos= null;
                        } catch (Exception e) {
                            System.out.println("\nIngrese la fecha nuevamente");
                            fechaEgresos = null;
                        }
                    }while (fechaEgresos==null);
                    hotel.listadoEgresosDeDiaDeterminado(fechaEgresos);
                    break;
                case 5:
                    hotel.listadoHabitaciones();
                    break;
                case 6:
                    int estado=0;
                    do{
                        try{
                            System.out.println("\nPara qué tipo de estado desea ver habitaciones?");
                            System.out.println("\n1- DISPONIBLE\n2- OCUPADA\n3- FUERA DE SERVICIO\n");
                            estado=scanner.nextInt();
                            scanner.nextLine();
                        }catch (InputMismatchException e){
                            System.out.println("Debe ingresar un número");
                            scanner.nextLine();
                        }catch (Exception e){
                            System.out.println("Problema detectado");
                            scanner.nextLine();
                        }
                    }while (estado!=1 && estado!=2 && estado!=3);
                    if(estado==1){
                        hotel.listadoHabitacionesPorEstado(EstadoHabitacion.DISPONIBLE);
                    }else if(estado==2){
                        hotel.listadoHabitacionesPorEstado(EstadoHabitacion.OCUPADA);
                    }else{
                        hotel.listadoHabitacionesPorEstado(EstadoHabitacion.FUERA_DE_SERVICIO);
                    }
                    break;
                case 7:
                    hotel.listadoOcupaciones();
                    break;
                case 8:
                    menuHotel();
                    break;
                default:
                    System.out.println("Opción incorrecta. Ingrese nuevamente");
                    break;
            }
            System.out.println("\nDesea ver otra opción?? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

        inicio();
    }

    public void menuMisDatos (){
        do {
            opcionesMisDatos();
            opcion=scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 0:
                    this.guardarListas();
                    System.exit(0);
                    break;
                case 1:
                    String claveActual;
                    String claveNueva;
                    System.out.println("Ingrese su contraseña actual");
                    claveActual=scanner.nextLine();
                    System.out.println("Ingrese la nueva contraseña");
                    claveNueva=scanner.nextLine();
                    empleadoActual.modificarClave(empleadoActual, claveActual, claveNueva);
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

            System.out.println("\nDesea ver otra opción?? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

        inicio();
    }


    public void menuEmpleadosAdministrador (){
        do {
            opcionesEmpleadosAdministrador();
            opcion=scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 0:
                    this.guardarListas();
                    System.exit(0);
                    break;
                case 1:
                   hotel.nuevoEmpleado();
                    break;
                case 2:
                    hotel.llamadaModificarEmpleado(empleadoActual);
                    break;
                case 3:
                    System.out.println("Ingrese el DNI del empleado que desea eliminar");
                    hotel.eliminarEmpleado(scanner.nextLine());
                    break;
                case 4:
                    menuAdministracionAdministrador();
                    break;
                default:
                    System.out.println("Opción incorrecta. Ingrese nuevamente");
                    break;
            }

            System.out.println("\nDesea ver otra opción?? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

        inicio();
    }

    public void menuHabitacionesAdministrador (){
        do {
            opcionesHabitacionesAdministrador();
            opcion=scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 0:
                    this.guardarListas();
                    System.exit(0);
                    break;
                case 1:
                    hotel.llamadaNuevaHabitacion();
                    break;
                case 2:
                    int nroHabitacion=0;
                    do{
                        try{
                            System.out.println("\nIngrese el número de habitación que desea modificar");
                            nroHabitacion=scanner.nextInt();
                            scanner.nextLine();
                        }catch (InputMismatchException e){
                            System.out.println("Debe ingresar un número");
                            scanner.nextLine();
                        }catch (Exception e){
                            System.out.println("Problema detectado");
                            scanner.nextLine();
                        }
                    }while (nroHabitacion==0);
                  hotel.llamadaModificarHabitacion(nroHabitacion, empleadoActual);
                    break;
                case 3:
                    int habitacion=0;
                    do{
                        try{
                            System.out.println("\nIngrese el número de habitación que desea eliminar");
                            habitacion=scanner.nextInt();
                            scanner.nextLine();
                        }catch (InputMismatchException e){
                            System.out.println("Debe ingresar un número");
                            scanner.nextLine();
                        }catch (Exception e){
                            System.out.println("Problema detectado");
                            scanner.nextLine();
                        }
                    }while (habitacion==0);
                    hotel.eliminarHabitacion(habitacion);
                    scanner.nextLine();
                    break;
                case 4:
                    menuAdministracionAdministrador();
                    break;
                default:
                    System.out.println("Opción incorrecta. Ingrese nuevamente");
                    break;
            }


            System.out.println("\nDesea ver otra opción?? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

        inicio();
    }

    public void menuShopAdministrador (){
        do {
            opcionesShopAdministracionAdministrador();
            opcion=scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 0:
                    this.guardarListas();
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

            System.out.println("\nDesea ver otra opción?? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

        inicio();
    }

    public void cargaListas (){
        Archivo archivo = new Archivo();
        hotel.setListaHabitaciones(archivo.readerArchivoHabitaciones("habitacion.json"));
        hotel.setListaReservas(archivo.readerArchivoReserva("reservas.json"));
        hotel.setListaOcupaciones(archivo.readerArchivoOcupaciones("ocupacion.json"));
        hotel.setPasajeros(archivo.readerArchivoPasajeros("pasajero.json"));
        hotel.setFacturasEmitidas(archivo.readerArchivoFacturas("factura.json"));
        hotel.setShop(archivo.readerArchivoShop("shop.json"));

    }
    public void guardarListas(){
        Archivo archivo=new Archivo();
        archivo.writerArchivoHabitaciones("habitacion.json", hotel.getListaHabitaciones());
        archivo.writerArchivoReserva("reservas.json", hotel.getListaReservas());
        archivo.writerArchivoOcupaciones("ocupacion.json", hotel.getListaOcupaciones());
        archivo.writerArchivoPasajeros("pasajero.json", hotel.getPasajeros());
        archivo.writerArchivoFacturas("factura.json", hotel.getFacturasEmitidas());
        archivo.writerArchivoShop("shop.json", hotel.getShop());
        archivo.writerArchivoEmpleado("empleado.json", hotel.getEmpleados());
    }

}
