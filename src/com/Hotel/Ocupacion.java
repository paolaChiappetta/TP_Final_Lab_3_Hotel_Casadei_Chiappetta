package com.Hotel;

import java.time.LocalDate;
import java.util.List;

public class Ocupacion {
    private static long ocupacionId = 0;

    private Integer idReserva = 0;  /// Si es 0, es porque no se realizó reserva anticipada
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private List<Extra> extras;
    private Integer cochera = 0;
    private Habitacion habitacion;
    private Integer cantidadPax;
    private TipoPension tipoPension;
    private Long numeroOcupacion;
    private List<Pasajero> listaPaxs;
    //falta deposito

    public Ocupacion() {
        this.numeroOcupacion = ocupacionId++;
    }

    public Ocupacion(int idReserva, LocalDate fechaIngreso,
                     LocalDate fechaSalida, List<Extra> extras,
                     int cochera, Habitacion habitacion, int cantidadPax,
                     TipoPension tipoPension, List<Pasajero> listaPaxs) {
        this.idReserva = idReserva;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.extras = extras;
        this.cochera = cochera;
        this.habitacion = habitacion;
        this.cantidadPax = cantidadPax;
        this.tipoPension = tipoPension;
        this.listaPaxs = listaPaxs;
        this.numeroOcupacion = ocupacionId++;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public List<Extra> getExtras() {
        return extras;
    }

    public void setExtras(List<Extra> extras) {
        this.extras = extras;
    }

    public Integer getCochera() {
        return cochera;
    }

    public void setCochera(Integer cochera) {
        this.cochera = cochera;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Integer getCantidadPax() {
        return cantidadPax;
    }

    public void setCantidadPax(Integer cantidadPax) {
        this.cantidadPax = cantidadPax;
    }

    public TipoPension getTipoPension() {
        return tipoPension;
    }

    public void setTipoPension(TipoPension tipoPension) {
        this.tipoPension = tipoPension;
    }

    public List<Pasajero> getListaPaxs() {
        return listaPaxs;
    }

    public void setListaPaxs(List<Pasajero> listaPaxs) {
        this.listaPaxs = listaPaxs;
    }

    public void verListaPaxsHabitacion() {
        for (Pasajero lista : this.listaPaxs) {
            if (lista != null) {
                System.out.println(lista);
            }
        }
    }

    public Pasajero titularHabitacion (){
        Pasajero titular=null;
        for (Pasajero lista : this.listaPaxs){
            if(this.listaPaxs!=null){
                if(lista.getTitularreserva()==true){
                    titular=lista;
                }
            }
        }
        return titular;
    }

    @Override
    public String toString() {
        return "Ocupación: \nHabitación: " + habitacion.getNumero() +
                "\nFecha de ingreso: " + this.fechaIngreso +
                "\nFecha de Salida: " + this.fechaSalida +
                "\nTipo de pensión: " + this.tipoPension +
                "\nCantidad de cocheras: " + this.cochera +
                "\nPasajeros: " + listaPaxs.toString();


    }
}
