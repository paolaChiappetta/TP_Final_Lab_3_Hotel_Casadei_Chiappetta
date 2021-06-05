package com.Hotel;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Ocupacion {
    private static long ocupacionId = 0;

    private long idReserva = 0;  /// Si es 0, es porque no se realizó reserva anticipada
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private List<Extra> extras;
    private Integer cochera = 0;
    private Habitacion habitacion;
    private Integer cantidadPax;
    private TipoPension tipoPension;
    private Long numeroOcupacion;
    private List<Pasajero> listaPaxs;
    private Double deposito;

    public Ocupacion() {
        this.numeroOcupacion = ocupacionId++;
    }

    public Ocupacion(long idReserva, LocalDate fechaIngreso,
                     LocalDate fechaSalida, List<Extra> extras,
                     int cochera, Habitacion habitacion, int cantidadPax,
                     TipoPension tipoPension, List<Pasajero> listaPaxs, Double deposito) {
        this.idReserva = idReserva;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.extras = extras;
        this.cochera = cochera;
        this.habitacion = habitacion;
        this.cantidadPax = cantidadPax;
        this.tipoPension = tipoPension;
        this.listaPaxs = listaPaxs;
        this.deposito= deposito;
        this.numeroOcupacion = ocupacionId++;
    }

    public long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(long idReserva) {
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

    public Double getDeposito() {         return deposito;   }

    public void setDeposito(Double deposito) {    this.deposito = deposito;   }

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

    Scanner scanner = new Scanner(System.in);


    /// metodos para asignar tipo de pension en ocupacion

    public void menuTipoPension (){
        System.out.println("1: Desayuno");
        System.out.println("2: Media pension");
        System.out.println("3: Pension Completa");


    }

    public void asignarTipoPension (Ocupacion ocupacion){

        int opcion = 0;

        do {
            menuTipoPension();
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    ocupacion.setTipoPension(TipoPension.DESAYUNO);
                    break;

                case 2:
                    ocupacion.setTipoPension(TipoPension.MEDIA_PENSION);
                    break;
                case 3:
                    ocupacion.setTipoPension(TipoPension.PENSION_COMPLETA);

                    break;
                default:
                    System.out.println("Opcion incorrecta, ingrese nuevamente");
                    break;
            }

        } while (opcion != 0);                     // dejo el opcion 0 para salir

    }


    public void agregarPasajerosLista (){
        int rta=1;
        do {
            System.out.println("Agregar pasajero:");
            Pasajero pasajero= new Pasajero();
            this.listaPaxs.add(pasajero.cargarPasajero());
            System.out.println("Agregar otro pasajero: 1= si  / 0= no");
            rta=scanner.nextInt();
        }while(rta==1);

    }

    /// nueva ocupacion con reserva previa

    public Ocupacion nuevaOcupacion (List <Habitacion> listHabitaciones, Reserva reserva){


        this.idReserva=reserva.getNumeroReserva();
        this.fechaIngreso=reserva.getFechaIngreso();
        this.fechaSalida=reserva.getFechaSalida();
        System.out.println("Cantidad cocheras: ");
        this.cochera= scanner.nextInt();
        this.habitacion= habitacion.buscarHabitacionPorNumero(listHabitaciones, reserva.getNumeroHabitacion());
        this.cantidadPax= reserva.getNumeroPasajeros();
        System.out.println("tipo de pesion");
        asignarTipoPension(this);
        agregarPasajerosLista();
        this.deposito= reserva.getDeposito();


        return this;
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
