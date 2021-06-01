package com.Hotel;

import java.time.LocalDate;

public class Reserva {


    private static long reservaId= 0;

    private String pasajeroNombre;
    private String pasajeroApellido;
    private String pasajeroDni;
    private Integer numeroHabitacion;
    private Integer numeroPasajeros;
    private Integer deposito;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private Long numeroReserva;


    //constructores

    public Reserva (){ this.numeroReserva= reservaId ++; }

    public Reserva(String pasajeroNombre, String pasajeroApellido, String pasajeroDni,
                   Integer numeroHabitacion, Integer numeroPasajeros, Integer deposito,
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

    public Integer getDeposito() {   return deposito;  }

    public void setDeposito(Integer deposito) {    this.deposito = deposito;  }

    public LocalDate getFechaIngreso() {    return fechaIngreso;  }

    public void setFechaIngreso(LocalDate fechaIngreso) {   this.fechaIngreso = fechaIngreso;  }

    public LocalDate getFechaSalida() {     return fechaSalida;  }

    public void setFechaSalida(LocalDate fechaSalida) {    this.fechaSalida = fechaSalida;  }

    public Long getNumeroReserva() {     return numeroReserva;   }



}
