package com.Hotel;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Hotel {

    private List<Habitacion> listaHabitaciones;
    private List<Reserva> listaReservas = new ArrayList<>();
    private List<Recepcionista> recepcionistas;
    private List<Administrador> administradores;
    private List<Ocupacion> listaOcupaciones;
    private Administrador administrador;
    private Recepcionista recepcionista;
    private List<Pasajero> pasajeros;
    private Shop shop;
    private Scanner scanner = new Scanner(System.in);

    public Hotel() {
    }

    public Hotel(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
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

        if (listaHabitaciones != null) { //si hay lista de habitaciones

            for (int i = 0; i < listaHabitaciones.size(); i++) { //recorro la lista de hab

                if (listaHabitaciones.get(i).getReservasHab() != null) { //si cada hab tiene su lista de reservas
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

                        } else if (encontrada == false && (ingreso.isAfter(listaHabitaciones.get(i).getReservasHab().get(it).getFechaSalida()) || //si estoy en una reserva del medio
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
        if (this.listaOcupaciones != null) {
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
        if (this.listaHabitaciones != null) {  //verifico que exista la hab
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
        if (this.listaOcupaciones != null) {  //verifico que exista la hab
            for (Ocupacion lista : listaOcupaciones) {
                if (lista.getHabitacion().getNumero() == nroHabitacion) {
                    ocupacionEncontrada = true;
                }
            }
        }
        return ocupacionEncontrada;
    }

    public void nuevaReserva() {
        LocalDate ingreso;
        LocalDate salida;
        int nroHab;
        String continuar = "s";
        boolean habLibre = false;

        do {
            System.out.println("Ingrese fecha de ingreso de la nueva reserva (AAAA-MM-DD)");
            ingreso = LocalDate.parse(scanner.nextLine());
            System.out.println("Ingrese fecha de salida de la nueva reserva (AAAA-MM-DD)");
            salida = LocalDate.parse(scanner.nextLine());

            List<Integer> libres = this.habitacionesLibres(ingreso, salida);
            if (libres == null) {
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
                    }
                }
                if (habLibre == false) {
                    System.out.println("La habitación no existe o no está libre en las fechas indicadas");
                }

            }

            scanner.nextLine();
            System.out.println("Desea seguir cargando reservas? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

    }


    public Boolean realizarUnaNuevaReservaBoolean() {
        LocalDate ingreso;
        LocalDate salida;
        int nroHab;
        boolean habLibre = false;
        boolean reservaBoolean = false;


        System.out.println("Ingrese fecha de ingreso de la nueva reserva (AAAA-MM-DD)");
        ingreso = LocalDate.parse(scanner.nextLine());
        System.out.println("Ingrese fecha de salida de la nueva reserva (AAAA-MM-DD)");
        salida = LocalDate.parse(scanner.nextLine());

        List<Integer> libres = this.habitacionesLibres(ingreso, salida);
        if (libres == null) {
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
                    reservaBoolean = true;
                }
            }
            if (habLibre == false) {
                System.out.println("La habitación no existe o no está libre en las fechas indicadas");
            }
        }
        return reservaBoolean;
    }


    public Reserva buscarReservaIdReserva(Long idReserva) {
        int encontrado = 0;
        int i = 0;
        Reserva reserva = null;
        if (this.listaReservas != null) {

            while (encontrado == 0 && i < this.listaReservas.size()) {

                if (this.listaReservas.get(i).equals(idReserva)) {
                    encontrado = 1;
                    reserva = this.listaReservas.get(i);
                }
                i++;
            }

        }
        return reserva;
    }


        //METODO REALIZAR CHECK IN CON O SIN RESERVA PREVIA

        public void checkIn () {
            System.out.println("Indique si tiene reserva  1= si  / 0= no");
            int tieneReserva = scanner.nextInt();
            Ocupacion ocupacion = new Ocupacion();

            if (tieneReserva == 1) {
                System.out.println("Id reserva:");
                ocupacion.nuevaOcupacion(listaHabitaciones, buscarReservaIdReserva(scanner.nextLong()));

                System.out.println("ocupacion:");
                System.out.println(ocupacion);
            } else {
                Boolean res = realizarUnaNuevaReservaBoolean();
                if (res == true) {
                    ocupacion.nuevaOcupacion(listaHabitaciones, listaReservas.get(listaReservas.size() - 1));
                } else {
                    System.out.println("no se pudo realizar check in");
                }
            }
        }




    }
