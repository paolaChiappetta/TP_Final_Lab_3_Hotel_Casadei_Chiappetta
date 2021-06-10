package com.Hotel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Habitacion implements Serializable, Comparable<Habitacion> {

    //Atributos
    private Integer numero;
    private Integer piso;
    private EstadoHabitacion estado;
    private Tarifa tarifa;
    private LocalDate fechaProximaOcupacion;

    //Constructor vacío
    public Habitacion() {
    }

    //Constructor completo
    public Habitacion(Integer numero, Integer piso,
                      EstadoHabitacion estado, Tarifa tarifa,
                      LocalDate fechaProximaOcupacion) {
        this.numero = numero;
        this.piso = piso;
        this.estado = estado;
        this.tarifa = tarifa;
        this.fechaProximaOcupacion = fechaProximaOcupacion;
    }

    //Getters y Setters
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

    //Métodos

    public Habitacion nuevaHabitacion(Habitacion habitacion) {
        Scanner scanner = new Scanner(System.in);
        int numero= 0;
        int piso= 0;
        do{
            try{
                System.out.println("Ingrese el número de la habitación:");
                numero= scanner.nextInt();
                habitacion.setNumero(numero);
            }catch (InputMismatchException e){
                System.out.println("Dato incorrecto");
                scanner.nextLine();
            }catch (Exception e){
                System.out.println("Problema detecatdo");
                scanner.nextLine();
            }
        }while (numero== 0);

        do{
            try{
                System.out.println("Ingrese el piso:");
                piso= scanner.nextInt();
                habitacion.setPiso(piso);
            }catch (InputMismatchException e){
                System.out.println("Dato incorrecto");
                scanner.nextLine();
            }catch (Exception e){
                System.out.println("Problema detecatdo");
                scanner.nextLine();
            }
        }while (piso== 0);

        habitacion.indicarTipoHabitacion();
        habitacion.indicarEstadoHabitacion();
        System.out.println("Nueva habitación:\n");
        System.out.println(habitacion);

        return habitacion;
    }

    public void menuTipoHabitacion() {
        System.out.println("1- Single standard");
        System.out.println("2- Single superior");
        System.out.println("3- Doble standard");
        System.out.println("4- Doble superior");
        System.out.println("5- Triple standard");
        System.out.println("6- Departamento 4 pasajeros");
        System.out.println("7- Departamento 6 pasajeros");
        System.out.println("8- Suite");
    }

    public void indicarTipoHabitacion() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        do{
            try{
                System.out.println("Indique el tipo de habitacion:");
                menuTipoHabitacion();
                opcion = scanner.nextInt();
                scanner.nextLine();
            }catch (InputMismatchException e){
                System.out.println("Debe ingresar un número");
                scanner.nextLine();
            }catch (Exception e){
                System.out.println("Problema detectado");
                scanner.nextLine();
            }
        }while (opcion==0);
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
                this.setTarifa(Tarifa.DOBLE_STANDAR);
                break;
        }
    }

    public void menuEstadoHabitacion() {

        System.out.println("1- Disponible");
        System.out.println("2- Ocupada");
        System.out.println("3- Fuera de servicio");
    }

    public void indicarEstadoHabitacion() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        do{
            try{
                System.out.println("Indique el estado de la habitación");
                menuEstadoHabitacion();
                opcion = scanner.nextInt();
                scanner.nextLine();
            }catch (InputMismatchException e){
                System.out.println("Debe ingresar un número");
                scanner.nextLine();
            }catch (Exception e){
                System.out.println("Problema detectado");
                scanner.nextLine();
            }
        }while (opcion==0);
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
                this.setEstado(EstadoHabitacion.DISPONIBLE);
                break;
        }
    }


    @Override
    public String toString() {
        return "Habitación " + this.numero + ":" +
                "\nPiso: " + this.piso +
                "\nDescripción: " + this.tarifa.getNombre() +
                "\nTarifa: $" + this.tarifa.getPrecio() +
                "\nEstado: " + this.estado;
    }

    @Override
    public int compareTo(Habitacion o) {
        if (numero<o.getNumero()) {
            return -1;
        }
        if (numero>o.getNumero()) {
            return 1;
        }
        return 0;
    }
}
