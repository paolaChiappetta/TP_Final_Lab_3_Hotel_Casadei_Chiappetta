package com.Hotel;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.util.ArrayList;
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
    private List<Pasajero> listaPaxs = new ArrayList<>();
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
        this.deposito = deposito;
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

    public Double getDeposito() {
        return deposito;
    }

    public void setDeposito(Double deposito) {
        this.deposito = deposito;
    }

    public void verListaPaxsHabitacion() {
        for (Pasajero lista : this.listaPaxs) {
            if (lista != null) {
                System.out.println(lista);
            }
        }
    }

    public Pasajero titularHabitacion() {
        Pasajero titular = null;
        for (Pasajero lista : this.listaPaxs) {
            if (this.listaPaxs != null) {
                if (lista.getTitularreserva() == true) {
                    titular = lista;
                }
            }
        }
        return titular;
    }

    Scanner scanner = new Scanner(System.in);


    /// metodos para asignar tipo de pension en ocupacion

    public void menuTipoPension() {
        System.out.println("1: Desayuno");
        System.out.println("2: Media pension");
        System.out.println("3: Pension Completa");


    }

    public void asignarTipoPension() {
        int opcion = 0;

        menuTipoPension();
        opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                this.setTipoPension(TipoPension.DESAYUNO);
                break;

            case 2:
                this.setTipoPension(TipoPension.MEDIA_PENSION);
                break;
            case 3:
                this.setTipoPension(TipoPension.PENSION_COMPLETA);

                break;
            default:
                this.setTipoPension(TipoPension.DESAYUNO);
                break;
        }

    }

    public void agregarPasajerosLista(Reserva reserva, List<Pasajero> pasajeros) {
        boolean encontrado = false;
        int i = 0;
        boolean existe = buscarPasajeroDni(reserva.getPasajeroDni(), pasajeros);

        if (existe) {
            while (!encontrado && i < pasajeros.size()) {
                if (reserva.getPasajeroDni() == pasajeros.get(i).getDni()) {
                    if (pasajeros.get(i).getTitularreserva()) {
                        this.listaPaxs.add(pasajeros.get(i));
                    } else {
                        pasajeros.get(i).setTitularreserva(true);
                        System.out.println(pasajeros.get(i));
                        System.out.println("\nDesea modificar algún dato?\n1-Si\n2-No");
                        if (scanner.nextInt() == 1) {
                            pasajeros.get(i).modificarPasajero(pasajeros.get(i));
                        }
                        this.listaPaxs.add(pasajeros.get(i));

                    }


                }
                i++;
            }
        }
        Pasajero pasajero = new Pasajero();
        this.listaPaxs.add(pasajero.cargarPasajeroTitular(reserva));

    }

    public void agregarPasajerosLista(List<Pasajero> pasajeros) {
        int rta = 1;
        boolean encontrado = false;
        int i = 0;

        do {
            String dni;
            System.out.println("\nAgregar acompañantes:");
            scanner.nextLine();
            System.out.println("\nIngrese el Dni:");
            dni = scanner.nextLine();
            boolean existe = buscarPasajeroDni(dni, pasajeros);
            if (existe) {
                while (!encontrado && i < pasajeros.size()) {
                    if (dni == pasajeros.get(i).getDni()) {
                        pasajeros.get(i).setTitularreserva(false);
                        this.listaPaxs.add(pasajeros.get(i));
                    }
                }
                i++;
            } else {
                Pasajero pasajero = new Pasajero();
                this.listaPaxs.add(pasajero.cargarPasajeroAcompaniante());
            }
            System.out.println("\nDesea agregar otro acompañante?:\n1- Si\n2- No");
            rta = scanner.nextInt();

        } while (rta == 1);
    }

            public boolean buscarPasajeroDni (String dni, List < Pasajero > pasajeros){
                int i = 0;
                boolean encontrado = false;

                while (!encontrado && i < pasajeros.size()) {

                    if (pasajeros.get(i).getDni() == dni) {
                        encontrado = true;
                    }
                }
                return encontrado;
            }

            public String mostrarListaPaxs () {
                String s = "";
                for (Pasajero lista : this.listaPaxs) {
                    if (lista.getTitularreserva()) {
                        s = "\nTitular: " + lista.getNombre() + " " + lista.getApellido();
                    }
                }
                for (Pasajero lista : this.listaPaxs) {
                    if (!lista.getTitularreserva()) {
                        s += "\nAcompañante: " + lista.getNombre() + " " + lista.getApellido();
                    }
                }
                return s;
            }


            @Override
            public String toString () {
                return "Ocupación: \nHabitación: " + habitacion.getNumero() +
                        "\nFecha de ingreso: " + this.fechaIngreso +
                        "\nFecha de Salida: " + this.fechaSalida +
                        "\nTipo de pensión: " + this.tipoPension +
                        "\nCantidad de cocheras: " + this.cochera +
                        "\nPasajeros: " + this.mostrarListaPaxs();


            }
        }
