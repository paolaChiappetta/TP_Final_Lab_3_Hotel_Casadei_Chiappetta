package com.Hotel;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Habitacion {

    private Integer numero;
    private Integer piso;
    private EstadoHabitacion estado;
    private Tarifa tarifa;
    private LocalDate fechaProximaOcupacion;
    private List<Reserva> reservasHab;


    public Habitacion() {
    }

    public Habitacion(Integer numero, Integer piso,
                      EstadoHabitacion estado, Tarifa tarifa,
                      LocalDate fechaProximaOcupacion,
                      List<Reserva> reservasHab) {
        this.numero = numero;
        this.piso = piso;
        this.estado = estado;
        this.tarifa = tarifa;
        this.fechaProximaOcupacion = fechaProximaOcupacion;
        this.reservasHab = reservasHab;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getPiso() {
        return piso;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    }

    public EstadoHabitacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoHabitacion estado) {
        this.estado = estado;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public LocalDate getFechaProximaOcupacion(LocalDate parse) {
        return fechaProximaOcupacion;
    }

    public void setFechaProximaOcupacion(LocalDate fechaProximaOcupacion) {
        this.fechaProximaOcupacion = fechaProximaOcupacion;
    }

    public List<Reserva> getReservasHab() {
        return reservasHab;
    }

    public void setReservasHab(List<Reserva> reservasHab) {
        this.reservasHab = reservasHab;
    }



    ///agrego funciones para asignar tipo y etsaod de habitaciones

    Scanner scanner= new Scanner(System.in);


    public void menuTipoHabitacion() {
        System.out.println("1: Single standard");
        System.out.println("2: Single superior");
        System.out.println("3: Doble standard");
        System.out.println("4: Doble superior");
        System.out.println("5: Triple standard");
        System.out.println("6: Departamento 4 pasajeros");
        System.out.println("7: Departamento 6 pasajeros");
        System.out.println("8: Suite");

        System.out.println("\n0 para finalizar");

    }


    public void indicarTipoHabitacion (){


        System.out.println("Indique tipo de habitacion: ");
        int opcion = 0;


        do {
            menuTipoHabitacion();
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    this.setTarifa(Tarifa.SINGLE_STANDAR);
                    break;

                case 2:
                    this.setTarifa(Tarifa.SINGLE_SUPERIOR);
                    break;
                case 3:
                    this.setTarifa(Tarifa.DOBLE_STANDAR);
                    break;

                case 4:
                    this.setTarifa(Tarifa.DOBLE_SUPERIOR);
                    break;
                case 5:
                    this.setTarifa(Tarifa.TRIPLE_STANDAR);
                    break;
                case 6:
                    this.setTarifa(Tarifa.DEPARTAMENTO_4PAX);
                    break;
                case 7:
                    this.setTarifa(Tarifa.DEPARTAMENTO_6PAX);
                    break;
                case 8:
                    this.setTarifa(Tarifa.SUITE);
                    break;

                default:
                    System.out.println("Opcion incorrecta, ingrese nuevamente");
                    break;

            }


        } while (opcion != 0);


    }

    public void menuEstadoHabitacion () {

        System.out.println("1: Disponible");
        System.out.println("2: Ocupada");
        System.out.println("3: Fuera de servicio");

    }


    public void indicarEstadoHabitacion (){


        System.out.println("Indique estado de habitacion: ");
        int opcion = 0;


        do {
            menuEstadoHabitacion();
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    this.setEstado(EstadoHabitacion.DISPONIBLE);
                    break;

                case 2:
                    this.setEstado(EstadoHabitacion.OCUPADA);
                    break;
                case 3:
                    this.setEstado(EstadoHabitacion.FUERA_DE_SERVICIO);
                    break;
                default:
                    System.out.println("Opcion incorrecta, ingrese nuevamente");
                    break;

            }


        } while (opcion != 0);

    }



    @Override
    public String toString() {
        return "Habitación " + this.numero + ":" +
                "\nPiso: " + this.piso +
                "\nDescripción: " + this.tarifa.getDescripcion() +
                "\nTarifa: $" + this.tarifa.getPrecio() +
                "\nEstado: " + this.estado +
                "\nPróxima ocupación: " + this.fechaProximaOcupacion;
    }
}
