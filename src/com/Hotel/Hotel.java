package com.Hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hotel {

    private List<Habitacion> listaHabitaciones;
    private List<Reserva> listaReservas;
    private List<Recepcionista> recepcionistas;
    private List<Administrador> administradores;
    private List<Ocupacion> listaOcupaciones;
    private Administrador administrador;
    private Recepcionista recepcionista;
    private List<Pasajero>pasajeros;

    private Shop shop;

    public Hotel() {
    }

    public Hotel(List<Habitacion> listaHabitaciones,
                 List<Reserva> listaReservas, List<Recepcionista> recepcionistas,
                 List<Administrador> administradores, List<Pasajero>pasajeros,
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
                        } else if (encontrada == false && (ingreso.isAfter(listaHabitaciones.get(i).getReservasHab().get(it).getFechaSalida()) || ingreso.equals(listaHabitaciones.get(i).getReservasHab().get(it).getFechaSalida())) && (salida.isEqual(listaHabitaciones.get(i).getReservasHab().get(it + 1).getFechaIngreso()) || salida.isBefore(listaHabitaciones.get(i).getReservasHab().get(it + 1).getFechaIngreso()))) {
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

    public Ocupacion buscarOcupacionPorHabitacion (int numeroHab){
        Ocupacion ocupacion=null;
        if (this.listaOcupaciones!=null){
            for(Ocupacion lista : this.listaOcupaciones){
                if(lista.getHabitacion().getNumero()==numeroHab){
                    ocupacion=lista;
                }
            }
        }
        return ocupacion;
    }

    public boolean verificarHabitacionExistente (int nroHabitacion){
        boolean habEncontrada=false;
        if (this.listaHabitaciones != null) {  //verifico que exista la hab
            for (Habitacion lista : listaHabitaciones) {
                if (lista.getNumero() == nroHabitacion) {
                    habEncontrada = true;
                }
            }
        }
        return habEncontrada;
    }

    public boolean verificarOcupacionExistente (int nroHabitacion){
        boolean ocupacionEncontrada=false;
        if (this.listaOcupaciones != null) {  //verifico que exista la hab
            for (Ocupacion lista : listaOcupaciones) {
                if (lista.getHabitacion().getNumero() == nroHabitacion) {
                    ocupacionEncontrada = true;
                }
            }
        }
        return ocupacionEncontrada;
    }
}
