package com.Hotel;

import java.time.LocalDate;
import java.util.Scanner;

public class Reserva implements Comparable<Reserva> {


    private static long reservaId= 1;

    private String pasajeroNombre;
    private String pasajeroApellido;
    private String pasajeroDni;
    private Integer numeroHabitacion;
    private Integer numeroPasajeros;
    private Double deposito;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private Long numeroReserva;


    //constructores

    public Reserva (){ this.numeroReserva= reservaId ++; }

    public Reserva(String pasajeroNombre, String pasajeroApellido, String pasajeroDni,
                   Integer numeroHabitacion, Integer numeroPasajeros, Double deposito,
                   LocalDate fechaIngreso, LocalDate fechaSalida) {

        this.numeroReserva= reservaId++;                // se asigna num de reserva
        this.pasajeroNombre = pasajeroNombre;
        this.pasajeroApellido = pasajeroApellido;
        this.pasajeroDni = pasajeroDni;
        this.numeroHabitacion = numeroHabitacion;
        this.numeroPasajeros = numeroPasajeros;
        this.deposito = deposito;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
    }


    ///getters y setters

    public String getPasajeroNombre() {        return pasajeroNombre;    }

    public void setPasajeroNombre(String pasajeroNombre) {   this.pasajeroNombre = pasajeroNombre;    }

    public String getPasajeroApellido() {   return pasajeroApellido;    }

    public void setPasajeroApellido(String pasajeroApellido) {    this.pasajeroApellido = pasajeroApellido;   }

    public String getPasajeroDni() {     return pasajeroDni;   }

    public void setPasajeroDni(String pasajeroDni) {     this.pasajeroDni = pasajeroDni;   }

    public Integer getNumeroHabitacion() {    return numeroHabitacion;   }

    public void setNumeroHabitacion(Integer numeroHabitacion) {    this.numeroHabitacion = numeroHabitacion;   }

    public Integer getNumeroPasajeros() {     return numeroPasajeros;   }

    public void setNumeroPasajeros(Integer numeroPasajeros) {   this.numeroPasajeros = numeroPasajeros;   }

    public Double getDeposito() {   return deposito;  }

    public void setDeposito(Double deposito) {    this.deposito = deposito;  }

    public LocalDate getFechaIngreso() {    return fechaIngreso;  }

    public void setFechaIngreso(LocalDate fechaIngreso) {   this.fechaIngreso = fechaIngreso;  }

    public LocalDate getFechaSalida() {     return fechaSalida;  }

    public void setFechaSalida(LocalDate fechaSalida) {    this.fechaSalida = fechaSalida;  }

    public Long getNumeroReserva() {     return numeroReserva;   }

    public void cargarReserva (Reserva reserva, int numeroHabitacion, LocalDate ingreso, LocalDate salida){
        Scanner scanner = new Scanner(System.in);
        reserva.setNumeroHabitacion(numeroHabitacion);
        reserva.setFechaIngreso(ingreso);
        reserva.setFechaSalida(salida);
        System.out.println("Ingrese el nombre del pasajero");
        reserva.setPasajeroNombre(scanner.nextLine());
        System.out.println("Ingrese el apellido del pasajero");
        reserva.setPasajeroApellido(scanner.nextLine());
        System.out.println("Ingrese el DNI del pasajero");
        reserva.setPasajeroDni(scanner.nextLine());
        System.out.println("Ingrese la cantidad de pasajeros");
        reserva.setNumeroPasajeros(scanner.nextInt());
        System.out.println("Ingrese el monto del depósito");
        reserva.setDeposito(scanner.nextDouble());
    }

    @Override
    public String toString() {
        return "Reserva ID: " + this.numeroReserva +
                "\nHabitación N°: " + this.numeroHabitacion +
                "\nFecha de ingreso: " + this.fechaIngreso +
                "\nFecha de salida: " + this.fechaSalida +
                "\nTitular de reserva: " + this.pasajeroNombre + " " + this.pasajeroApellido +
                "\nDNI: " + this.pasajeroDni +
                "\nDepósito: $" + this.deposito + "\n";
    }

    @Override
    public int compareTo(Reserva o) {
        if (fechaIngreso.isBefore(o.getFechaIngreso())){
            return -1;
        }
        if (fechaIngreso.isAfter(o.getFechaIngreso())){
            return 1;
        }
        return 0;
    }
}
