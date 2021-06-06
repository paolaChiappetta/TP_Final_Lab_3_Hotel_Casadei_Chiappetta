package com.Hotel;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Hotel {

    private List<Habitacion> listaHabitaciones;
    private List<Reserva> listaReservas;
    private List<Recepcionista> recepcionistas;
    private List<Administrador> administradores;
    private List<Ocupacion> listaOcupaciones;
    private Administrador administrador;
    private Recepcionista recepcionista;
    private List<Pasajero> pasajeros;
    private Shop shop;
    private Scanner scanner = new Scanner(System.in);

    public Hotel() {
        this.listaHabitaciones = new ArrayList<>();
        this.listaReservas = new ArrayList<>();
        this.recepcionistas = new ArrayList<>();
        this.administradores = new ArrayList<>();
        this.listaOcupaciones = new ArrayList<>();
        this.pasajeros = new ArrayList<>();
        this.shop = new Shop();
    }

    public Hotel(List<Habitacion> listaHabitaciones, List<Reserva> listaReservas) {
        this.listaHabitaciones = listaHabitaciones;
        this.listaReservas = listaReservas;
        this.listaOcupaciones = new ArrayList();
        this.pasajeros = new ArrayList();
    }

    public Hotel(List<Habitacion> listaHabitaciones,
                 List<Reserva> listaReservas, List<Recepcionista> recepcionistas,
                 List<Administrador> administradores, List<Pasajero> pasajeros,
                 Administrador administrador, Recepcionista recepcionista, Shop shop,
                 List<Ocupacion> listaOcupaciones) {
        this.listaHabitaciones = listaHabitaciones;
        this.listaReservas = listaReservas;
        this.recepcionistas = recepcionistas;
        this.administrador = administrador;
        this.recepcionista = recepcionista;
        this.shop = shop;
        this.listaOcupaciones = listaOcupaciones;
        this.administradores = administradores;
        this.pasajeros = pasajeros;
    }

    public List<Habitacion> getListaHabitaciones() {
        return listaHabitaciones;
    }

    public void setListaHabitaciones(List<Habitacion> listaHabitaciones) {
        this.listaHabitaciones = listaHabitaciones;
    }

    public List<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public List<Recepcionista> getRecepcionistas() {
        return recepcionistas;
    }

    public void setRecepcionistas(List<Recepcionista> recepcionistas) {
        this.recepcionistas = recepcionistas;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public Recepcionista getRecepcionista() {
        return recepcionista;
    }

    public void setRecepcionista(Recepcionista recepcionista) {
        this.recepcionista = recepcionista;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<Ocupacion> getListaOcupaciones() {
        return listaOcupaciones;
    }

    public void setListaOcupaciones(List<Ocupacion> listaOcupaciones) {
        this.listaOcupaciones = listaOcupaciones;
    }

    public List<Administrador> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(List<Administrador> administradores) {
        this.administradores = administradores;
    }

    public List<Pasajero> getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(List<Pasajero> pasajeros) {
        this.pasajeros = pasajeros;
    }

    //BUSCA HABS LIBRES CON DETERMINADA FECHA DE INGRESO O DE SALIDA
    public List<Integer> habitacionesLibres(LocalDate ingreso, LocalDate salida) {
        List<Integer> habitaciones = new ArrayList<>();
        boolean encontrada = false;

        if (!listaHabitaciones.isEmpty()) { //si hay lista de habitaciones

            for (int i = 0; i < listaHabitaciones.size(); i++) { //recorro la lista de hab

                if (!listaHabitaciones.get(i).getReservasHab().isEmpty()) { //si cada hab tiene su lista de reservas
                    Collections.sort(listaHabitaciones.get(i).getReservasHab()); //las ordeno por fecha en orden ascendente
                    encontrada = false;

                    for (int it = 0; it < listaHabitaciones.get(i).getReservasHab().size(); it++) {                             //recorro la lista de reservas de  esa hab
                        if (it == 0 && salida.isBefore(listaHabitaciones.get(i).getReservasHab().get(it).getFechaIngreso()) || //si es la 1er reserva y salida
                                salida.isEqual(listaHabitaciones.get(i).getReservasHab().get(it).getFechaIngreso())) {         //es <= que la fecha de ingreso de la reserva

                            System.out.println("\nHabitación: " + listaHabitaciones.get(i).getNumero() +                                                  //muestro nro de hab y tarifa
                                    "\nTarifa: " + listaHabitaciones.get(i).getTarifa() + "\nNoches desde la reserva anterior: sin reservas anteriores" + //muestro cuantas noches hay hasta la prox reserva
                                    "\nNoches hasta la reserva siguiente: " +
                                    ChronoUnit.DAYS.between(salida, listaHabitaciones.get(i).getReservasHab().get(it).getFechaIngreso()));

                            habitaciones.add(listaHabitaciones.get(i).getReservasHab().get(it).getNumeroHabitacion());        //agrego esa hab a la lista de habs disponibles

                            encontrada = true;

                        } else if (encontrada == false && it == listaHabitaciones.get(i).getReservasHab().size() - 1 &&       //si es la última reserva e ingreso es >=
                                ingreso.isAfter(listaHabitaciones.get(i).getReservasHab().get(it).getFechaSalida()) ||        //a la fecha de salida de la reserva
                                ingreso.isEqual(listaHabitaciones.get(i).getReservasHab().get(it).getFechaSalida())) {

                            System.out.println("\nHabitación: " + listaHabitaciones.get(i).getNumero() +                            //muestro nro de hab y tarifa
                                    "\nTarifa: " + listaHabitaciones.get(i).getTarifa() + "\nNoches desde la reserva anterior: " +  //muestro cuantas noches hay desde la última reserva
                                    +ChronoUnit.DAYS.between(listaHabitaciones.get(i).getReservasHab().get(it).getFechaSalida(), ingreso) +
                                    "\nNoches hasta la reserva siguiente: sin reservas posteriores");

                            habitaciones.add(listaHabitaciones.get(i).getReservasHab().get(it).getNumeroHabitacion());

                            encontrada = true;

                        } else if (!encontrada && (ingreso.isAfter(listaHabitaciones.get(i).getReservasHab().get(it).getFechaSalida()) || //si estoy en una reserva del medio
                                ingreso.equals(listaHabitaciones.get(i).getReservasHab().get(it).getFechaSalida())) &&                           //verifico si ingreso es <=a la fecha de salida
                                (salida.isEqual(listaHabitaciones.get(i).getReservasHab().get(it + 1).getFechaIngreso()) ||                      //de la reserva y <= a la fecha de ingreso de
                                        salida.isBefore(listaHabitaciones.get(i).getReservasHab().get(it + 1).getFechaIngreso()))) {             //la proxima reserva

                            System.out.println("\nHabitación: " + listaHabitaciones.get(i).getNumero() +                                      //muestro nro de hab y tarifa
                                    "\nTarifa: " + listaHabitaciones.get(i).getTarifa() + "\nNoches desde la reserva anterior: " +            //muestro cuantas noches hay desde la última reserva
                                    +ChronoUnit.DAYS.between(listaHabitaciones.get(i).getReservasHab().get(it).getFechaSalida(), ingreso) +  //y muestro cuantas noches hay hasta la prox reserva
                                    "\nNoches hasta la reserva siguiente: " +                                                                 //sirve para ver qué hab conviene reservar
                                    ChronoUnit.DAYS.between(salida, listaHabitaciones.get(i).getReservasHab().get(it + 1).getFechaIngreso()));

                            habitaciones.add(listaHabitaciones.get(i).getReservasHab().get(it).getNumeroHabitacion());

                            encontrada = true;
                        }

                    }
                } else {
                    System.out.println("\nHabitación: " + listaHabitaciones.get(i).getNumero() +
                            "\nTarifa: " + listaHabitaciones.get(i).getTarifa() + "\nNoches desde la reserva anterior: sin reservas anteriores" +
                            "\nNoches hasta la reserva siguiente: sin reservas posteriores");

                    habitaciones.add(listaHabitaciones.get(i).getNumero()); //si no tiene reservas la agrego a la lista de habitaciones libres
                }
            }

        } else {
            System.out.println("No hay habitaciones cargadas");
        }

        return habitaciones;
    }

    public Ocupacion buscarOcupacionPorHabitacion(int numeroHab) {
        Ocupacion ocupacion = null;
        if (!this.listaOcupaciones.isEmpty()) {
            for (Ocupacion lista : this.listaOcupaciones) {
                if (lista.getHabitacion().getNumero() == numeroHab) {
                    ocupacion = lista;
                }
            }
        }
        return ocupacion;
    }

    public boolean verificarHabitacionExistente(int nroHabitacion) {
        boolean habEncontrada = false;
        if (!this.listaHabitaciones.isEmpty()) {  //verifico que exista la hab
            for (Habitacion lista : listaHabitaciones) {
                if (lista.getNumero() == nroHabitacion) {
                    habEncontrada = true;
                }
            }
        }
        return habEncontrada;
    }

    public boolean verificarOcupacionExistente(int nroHabitacion) {
        boolean ocupacionEncontrada = false;
        if (!this.listaOcupaciones.isEmpty()) {  //verifico que exista la hab
            for (Ocupacion lista : listaOcupaciones) {
                if (lista.getHabitacion().getNumero() == nroHabitacion) {
                    ocupacionEncontrada = true;
                }
            }
        }
        return ocupacionEncontrada;
    }

    public boolean nuevaReserva() {
        LocalDate ingreso;
        LocalDate salida;
        int nroHab;
        String continuar = "s";
        boolean habLibre = false;
        boolean reservaCargada = false;


        System.out.println("Ingrese fecha de ingreso de la nueva reserva (AAAA-MM-DD)");
        ingreso = LocalDate.parse(scanner.nextLine());
        System.out.println("Ingrese fecha de salida de la nueva reserva (AAAA-MM-DD)");
        salida = LocalDate.parse(scanner.nextLine());

        List<Integer> libres = this.habitacionesLibres(ingreso, salida);
        if (libres.isEmpty()) {
            System.out.println("No hay habitaciones disponibles en las fechas indicadas");
        } else {
            Reserva reserva = new Reserva();
            System.out.println("\nIndique el número de la habitación elegida");
            nroHab = scanner.nextInt();
            for (Integer lista : libres) {
                if (lista == nroHab) {
                    reserva.cargarReserva(reserva, nroHab, ingreso, salida);
                    System.out.println("Reserva cargada satisfactoriamente");
                    System.out.println(reserva);
                    this.listaReservas.add(reserva);
                    habLibre = true;
                    reservaCargada = true;
                }
            }
            if (habLibre == false) {
                System.out.println("La habitación no existe o no está libre en las fechas indicadas");
            }

        }
        return reservaCargada;

    }

    public boolean verificarExistenciaReserva(Long idReserva) {
        boolean encontrada = false;
        int i = 0;

        if (!this.listaReservas.isEmpty()) {

            while (!encontrada && i < this.listaReservas.size()) {

                if (this.listaReservas.get(i).getNumeroReserva().equals(idReserva)) {
                    encontrada = true;
                }
                i++;
            }

        }
        return encontrada;
    }

    //METODO REALIZAR CHECK IN CON O SIN RESERVA PREVIA

    public void checkIn() {
        int tieneReserva;
        Long idReserva;

        System.out.println("Indique si el pasajero tiene reserva: \n1- Si\n2- No");
        tieneReserva = scanner.nextInt();
        scanner.nextLine();

        if (tieneReserva == 1) {
            System.out.println("Indique el Id de la reserva: ");
            idReserva = scanner.nextLong();
            if (verificarExistenciaReserva(idReserva)) {

                boolean encontrada = false;
                int i = 0;
                while (!encontrada && i < listaReservas.size()) {
                    if (listaReservas.get(i).getNumeroReserva() == idReserva) {
                        nuevaOcupacion(listaReservas.get(i));
                        encontrada = true;
                    }
                    i++;
                }

            } else {
                System.out.println("No hay reservas que coincidan con el id indicado");
            }
        } else {
            Boolean res = nuevaReserva();
            if (res == true) {
                nuevaOcupacion(listaReservas.get(listaReservas.size() - 1));
            } else {
                System.out.println("no se pudo realizar check in");
            }
        }
    }


    //MUESTRA EL LISTADO DE INGRESOS DEL DIA DE HOY
    public void listadoIngresosDelDia() {
        if (!this.listaReservas.isEmpty()) { //busca en la lista de reservas
            for (Reserva lista : listaReservas) {
                System.out.println("\nIngresos del día\n");
                if (lista.getFechaIngreso().isEqual(LocalDate.now())) { //coincidencias en la fecha de ingreso
                    System.out.println(lista);
                }
            }
        } else {
            System.out.println("El hotel no posee reservas");
        }
    }

    //MUESTRA EL LISTADO DE EGRESOS DEL DIA DE HOY
    public void listadoEgresosDelDia() {
        if (!this.listaOcupaciones.isEmpty()) {
            for (Ocupacion lista : listaOcupaciones) { //busca en la lista de ocupaciones
                System.out.println("\nEgresos del día\n");
                if (lista.getFechaSalida().isEqual(LocalDate.now())) { //coincidencias en la fecha de salida
                    System.out.println(lista);
                }
            }
        } else {
            System.out.println("El hotel no posee habitaciones ocupadas");
        }
    }

    //MUESTRA EL LISTADO DE INGRESOS DE UN DIA DETERMINADO
    public void listadoIngresosDeReservasDeDiaDeterminado(LocalDate dia) {
        if (!this.listaReservas.isEmpty()) {
            for (Reserva lista : listaReservas) { //busca en la lista de reservas
                System.out.println("\nIngresos del día: " + dia + "\n");
                if (lista.getFechaIngreso().isEqual(dia)) { //coincidencias en la fecha de ingreso indicada
                    System.out.println(lista);
                }
            }
        } else {
            System.out.println("El hotel no posee ingresos el día " + dia);
        }
    }

    //MUESTRA EL LISTADO DE EGRESOS DE UN DIA DETERMINADO
    public void listadoEgresosDeDiaDeterminado(LocalDate dia) {
        if (!this.listaReservas.isEmpty()) {
            for (Reserva lista : listaReservas) { //busca en la lista de reservas
                System.out.println("\nEgresos del día: " + dia + "\n");
                if (lista.getFechaSalida().isEqual(dia)) { //coincidencias en la fecha de egreso indicada
                    System.out.println(lista);
                }
            }
        } else {
            System.out.println("El hotel no posee egresos el día " + dia);
        }
    }

    //MUESTRA EL LISTADO DE HABITACIONES
    public void listadoHabitaciones() {
        if (!this.listaHabitaciones.isEmpty()) {
            System.out.println("Listado de habitaciones\n");
            for (Habitacion lista : listaHabitaciones) {
                System.out.println(lista);
            }
        } else {
            System.out.println("El hotel no tiene habitaciones cargadas");
        }
    }

    //MUESTRA EL LISTADO DE HABITACIONES OCUPADAS Y SUS DATOS
    public void listadoOcupaciones() {
        if (!this.listaOcupaciones.isEmpty()) {
            System.out.println("Listado de ocupaciones\n");
            for (Ocupacion lista : listaOcupaciones) {
                System.out.println(lista);
            }
        } else {
            System.out.println("El hotel no tiene habitaciones ocupadas");
        }
    }

    public LocalDate fechaProximaOcupacionHabitacion(int nroHabitacion) {
        boolean habEncontrada = false;
        int i = 0;
        LocalDate fecha = null;
        if (!this.listaReservas.isEmpty()) {
            while (!habEncontrada && i < listaReservas.size()) {
                if (listaReservas.get(i).getNumeroHabitacion() == nroHabitacion) {
                    fecha = listaReservas.get(0).getFechaIngreso();
                    habEncontrada = true;
                }
                i++;
            }
        }
        return fecha;
    }

    public boolean verifarExistenciaHabitacionPorNumero(List<Habitacion> listaHabitaciones, int numero) {
        boolean encontrada = false;
        int i = 0;
        if (!listaHabitaciones.isEmpty()) {
            while (!encontrada && i < listaHabitaciones.size()) {
                if (listaHabitaciones.get(i).getNumero() == numero) {
                    encontrada = true;
                }
            }
            i++;
        }
        return encontrada;
    }

    /// nueva ocupacion con reserva previa


    public void nuevaOcupacion(Reserva reserva) {
        Ocupacion ocupacion = new Ocupacion();

        ocupacion.setIdReserva(reserva.getNumeroReserva());
        ocupacion.setFechaIngreso(reserva.getFechaIngreso());
        ocupacion.setFechaSalida(reserva.getFechaSalida());
        System.out.println("Cantidad cocheras: ");
        ocupacion.setCochera(scanner.nextInt());
        boolean encontrada = false;
        int i = 0;
        while (!encontrada && i < this.listaHabitaciones.size()) {
            if (this.listaHabitaciones.get(i).getNumero() == reserva.getNumeroHabitacion()) {
                ocupacion.setHabitacion(this.listaHabitaciones.get(i));
            }
            i++;
        }

        ocupacion.setCantidadPax(reserva.getNumeroPasajeros());
        System.out.println("Tipo de pensión");
        ocupacion.asignarTipoPension();
        ocupacion.agregarPasajerosLista(reserva, this.pasajeros);
        ocupacion.agregarPasajerosLista(this.pasajeros);
        ocupacion.setDeposito(reserva.getDeposito());

        this.listaOcupaciones.add(ocupacion);
        System.out.println("\nOcupación cargada satisfactoriamente");
        System.out.println(ocupacion);
    }

    //LISTADO RESERVAS POR DNI

    public void listadoReservasPorDni( String dni) {
        if (!this.listaReservas.isEmpty()) {

            System.out.println("\nReservas por dni: \n");
            for (Reserva reserva : this.listaReservas) { //busca en la lista de reservas
                if (reserva.getPasajeroDni().compareTo(dni)==0) {
                    System.out.println(reserva);
                }
            }
        } else {
            System.out.println("El pasajero no posee reservas");
        }
    }



}
