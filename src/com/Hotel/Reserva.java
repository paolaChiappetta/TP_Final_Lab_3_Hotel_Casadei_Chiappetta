package com.Hotel;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Reserva implements Comparable<Reserva> {

//Atributos
    private static long reservaId = 1;

    private String pasajeroNombre;
    private String pasajeroApellido;
    private String pasajeroDni;
    private Integer numeroHabitacion;
    private Integer numeroPasajeros;
    private Double deposito;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private Long numeroReserva;
    private String telefono;


    //Constructor vacío - asigna id

    public Reserva() {
        this.numeroReserva = reservaId++;
    }

    //Constructor con algunos datos - asigna id
    public Reserva(String pasajeroNombre, String pasajeroApellido, String pasajeroDni,
                   Integer numeroHabitacion, Integer numeroPasajeros, Double deposito,
                   LocalDate fechaIngreso, LocalDate fechaSalida, String telefono) {

        this.numeroReserva = reservaId++;
        this.pasajeroNombre = pasajeroNombre;
        this.pasajeroApellido = pasajeroApellido;
        this.pasajeroDni = pasajeroDni;
        this.numeroHabitacion = numeroHabitacion;
        this.numeroPasajeros = numeroPasajeros;
        this.deposito = deposito;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.telefono = telefono;
    }

    //Constructor completo
    public Reserva(String pasajeroNombre, String pasajeroApellido,
                   String pasajeroDni, Integer numeroHabitacion,
                   Integer numeroPasajeros, Double deposito, LocalDate fechaIngreso,
                   LocalDate fechaSalida, Long numeroReserva, String telefono) {
        this.pasajeroNombre = pasajeroNombre;
        this.pasajeroApellido = pasajeroApellido;
        this.pasajeroDni = pasajeroDni;
        this.numeroHabitacion = numeroHabitacion;
        this.numeroPasajeros = numeroPasajeros;
        this.deposito = deposito;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.numeroReserva = numeroReserva;
        this.telefono = telefono;
    }

    //Getters y setters

    public String getPasajeroNombre() {
        return pasajeroNombre;
    }

    public void setPasajeroNombre(String pasajeroNombre) {
        this.pasajeroNombre = pasajeroNombre;
    }

    public String getPasajeroApellido() {
        return pasajeroApellido;
    }

    public void setPasajeroApellido(String pasajeroApellido) {
        this.pasajeroApellido = pasajeroApellido;
    }

    public String getPasajeroDni() {
        return pasajeroDni;
    }

    public void setPasajeroDni(String pasajeroDni) {
        this.pasajeroDni = pasajeroDni;
    }

    public Integer getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(Integer numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public Integer getNumeroPasajeros() {
        return numeroPasajeros;
    }

    public void setNumeroPasajeros(Integer numeroPasajeros) {
        this.numeroPasajeros = numeroPasajeros;
    }

    public Double getDeposito() {
        return deposito;
    }

    public void setDeposito(Double deposito) {
        this.deposito = deposito;
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

    public Long getNumeroReserva() {
        return numeroReserva;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    @Override
    public String toString() {
        return "Reserva ID: " + this.numeroReserva +
                "\nHabitación N°: " + this.numeroHabitacion +
                "\nFecha de ingreso: " + this.fechaIngreso +
                "\nFecha de salida: " + this.fechaSalida +
                "\nTitular de reserva: " + this.pasajeroNombre + " " + this.pasajeroApellido +
                "\nDNI: " + this.pasajeroDni +
                "\nTeléfono: " + this.telefono +
                "\nDepósito: $" + this.deposito + "\n";
    }

    //Ordena reservas cronológicamente por fecha de ingreso
    @Override
    public int compareTo(Reserva o) {
        if (fechaIngreso.isBefore(o.getFechaIngreso())) {
            return -1;
        }
        if (fechaIngreso.isAfter(o.getFechaIngreso())) {
            return 1;
        }
        return 0;
    }
}
