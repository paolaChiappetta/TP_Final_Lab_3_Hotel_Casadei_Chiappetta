package com.Hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Hotel {

    private List<Habitacion> listaHabitaciones;
    private List<Reserva> listaReservas;
    private List<Recepcionista> recepcionistas;
    //private List<Ocupacion> listaOcupaciones;

    private Administrador administrador;
    private Recepcionista recpecionista;

    private Shop shop;

    public Hotel() {
    }

    public Hotel(List<Habitacion> listaHabitaciones,
                 List<Reserva> listaReservas, List<Recepcionista> recepcionistas,
                 Administrador administrador, Recepcionista recpecionista, Shop shop) {
        this.listaHabitaciones = listaHabitaciones;
        this.listaReservas = listaReservas;
        this.recepcionistas = recepcionistas;
        this.administrador = administrador;
        this.recpecionista = recpecionista;
        this.shop = shop;
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

    public Recepcionista getRecpecionista() {
        return recpecionista;
    }

    public void setRecpecionista(Recepcionista recpecionista) {
        this.recpecionista = recpecionista;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<Integer> habsLibre(LocalDate ingreso, LocalDate salida) {
        List<Integer> habitaciones = new ArrayList<>();
        boolean encontrada = false;

        if (listaHabitaciones != null) {
            for (int i = 0; i < listaHabitaciones.size(); i++) {
                if (listaHabitaciones.get(i).getReservasHab() != null) {
                    Collections.sort(listaHabitaciones.get(i).getReservasHab());
                    encontrada = false;
                    for (int it = 0; it < listaHabitaciones.get(i).getReservasHab().size(); it++) {
                        if (it == 0 && salida.isBefore(listaHabitaciones.get(i).getReservasHab().get(it).getFechaIngreso()) || salida.isEqual(listaHabitaciones.get(i).getReservasHab().get(it).getFechaIngreso())) {
                            habitaciones.add(listaHabitaciones.get(i).getReservasHab().get(it).getNumeroHabitacion());
                            encontrada = true;
                        } else if (encontrada == false && it == listaHabitaciones.get(i).getReservasHab().size() - 1 && ingreso.isAfter(listaHabitaciones.get(i).getReservasHab().get(it).getFechaSalida()) || ingreso.isEqual(listaHabitaciones.get(i).getReservasHab().get(it).getFechaSalida())) {
                            habitaciones.add(listaHabitaciones.get(i).getReservasHab().get(it).getNumeroHabitacion());
                            encontrada = true;
                        } else if (encontrada == false && it != 0 && it != listaHabitaciones.get(i).getReservasHab().size() - 1 && (ingreso.isAfter(listaHabitaciones.get(i).getReservasHab().get(it).getFechaSalida()) || ingreso.equals(listaHabitaciones.get(i).getReservasHab().get(it).getFechaSalida())) && (salida.isEqual(listaHabitaciones.get(i).getReservasHab().get(it + 1).getFechaIngreso()) || salida.isBefore(listaHabitaciones.get(i).getReservasHab().get(it + 1).getFechaIngreso()))) {
                            habitaciones.add(listaHabitaciones.get(i).getReservasHab().get(it).getNumeroHabitacion());
                            encontrada = true;
                        }
                    }
                } else {
                    habitaciones.add(listaHabitaciones.get(i).getNumero());
                }
            }

        } else {
            System.out.println("No hay habitaciones cargadas");
        }

        return habitaciones;
    }
}
