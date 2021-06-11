package com.Hotel;

import org.w3c.dom.ls.LSOutput;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Ocupacion implements Serializable, Comparable<Ocupacion> {

    //Atributos
    private static long ocupacionId = 0;

    private long idReserva = 0;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private List<Extra> extras;
    private Integer cochera = 0;
    private Integer nroHabitacion;
    private Tarifa tarifa;
    private Integer cantidadPax;
    private TipoPension tipoPension;
    private Long numeroOcupacion;
    private List<Pasajero> listaPaxs = new ArrayList<>();
    private Double deposito;

    //Constructor vacío - con asignación de id
    public Ocupacion() {
        this.numeroOcupacion = ocupacionId+1;
    }

    //Cosntructor con datos + asignacion ID
    public Ocupacion(long idReserva, LocalDate fechaIngreso,
                     LocalDate fechaSalida, List<Extra> extras,
                     int cochera, Integer nroHabitacion, Tarifa tarifa, int cantidadPax,
                     TipoPension tipoPension, List<Pasajero> listaPaxs, Double deposito) {
        this.idReserva = idReserva;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.extras = extras;
        this.cochera = cochera;
        this.nroHabitacion = nroHabitacion;
        this.tarifa = tarifa;
        this.cantidadPax = cantidadPax;
        this.tipoPension = tipoPension;
        this.listaPaxs = listaPaxs;
        this.deposito = deposito;
        this.numeroOcupacion = ocupacionId+1;
    }

    //Cosntructor completo
    public Ocupacion(long idReserva, LocalDate fechaIngreso,
                     LocalDate fechaSalida, List<Extra> extras, Integer cochera,
                     Integer nroHabitacion, Tarifa tarifa, Integer cantidadPax, TipoPension tipoPension,
                     Long numeroOcupacion, List<Pasajero> listaPaxs, Double deposito) {
        this.idReserva = idReserva;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.extras = extras;
        this.cochera = cochera;
        this.nroHabitacion = nroHabitacion;
        this.tarifa = tarifa;
        this.cantidadPax = cantidadPax;
        this.tipoPension = tipoPension;
        this.numeroOcupacion = numeroOcupacion;
        this.listaPaxs = listaPaxs;
        this.deposito = deposito;
    }

    //Getters y Setters
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

    public Integer getNroHabitacion() {
        return nroHabitacion;
    }

    public void setNroHabitacion(Integer nroHabitacion) {
        this.nroHabitacion = nroHabitacion;
    }

    public Tarifa getTarifa() {
        return tarifa;
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


    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public Long getNumeroOcupacion() {
        return numeroOcupacion;
    }

    public void setNumeroOcupacion(Long numeroOcupacion) {
        this.numeroOcupacion = numeroOcupacion;
    }

    //Métodos

      public Pasajero titularHabitacion() {  //indica quién es el titular de la reserva p/emitir la factura luego
        Pasajero titular = null;
        for (Pasajero lista : this.listaPaxs) {
            if (this.listaPaxs != null) {
                if (lista.getTitularreserva()) {
                    titular = lista;
                }
            }
        }
        return titular;
    }


    /// Métodos para asignar tipo de pension en ocupacion

    public void menuTipoPension() {
        System.out.println("1- Desayuno");
        System.out.println("2- Media pension");
        System.out.println("3- Pension Completa");


    }

    public void asignarTipoPension() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        do {
            try {
                menuTipoPension();
                opcion = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Problema detectado");
                scanner.nextLine();
            }
        } while (opcion == 0);

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

    //Agrega el pasajero titular de la reserva
    public void agregarPasajerosLista(Reserva reserva, List<Pasajero> pasajeros) {
        Scanner scanner = new Scanner(System.in);
        boolean encontrado = false;
        int i = 0;
        boolean existe = buscarPasajeroDni(reserva.getPasajeroDni(), pasajeros); //se busca si el pasajero se alojó anteriormente en el hotel y tenemos sus datos

        if (existe) {
            while (!encontrado && i < pasajeros.size()) {
                if (reserva.getPasajeroDni().compareTo(pasajeros.get(i).getDni())==0) {
                    if (!pasajeros.get(i).getTitularreserva()) {
                        pasajeros.get(i).setTitularreserva(true);
                    }
                    System.out.println(pasajeros.get(i));
                    int modificar = 0;
                    do {
                        try {
                            System.out.println("\nDesea modificar algún dato?\n1-Si\n2-No");
                            modificar = scanner.nextInt();
                            scanner.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println("Debe ingresar un número");
                            scanner.nextLine();
                        } catch (Exception e) {
                            System.out.println("Problema detectado");
                            scanner.nextLine();
                        }
                    } while (modificar != 1 && modificar != 2);

                    if (modificar == 1) {
                        pasajeros.get(i).modificarPasajero(pasajeros.get(i));
                    }
                    this.listaPaxs.add(pasajeros.get(i));
                    encontrado = true;

                }
                i++;
            }

        }
        Pasajero pasajero = new Pasajero();
        this.listaPaxs.add(pasajero.cargarPasajeroTitular(reserva, pasajeros));
    }

    public void examinaDatosCompletos(String dato) throws ExcepcionDatoVacio {

        if (dato.compareTo("") == 0) {                                   //COMPARA EL DATO RECIBIDO POR PARAMETRO CON ""
            throw new ExcepcionDatoVacio("El dato no está completo");

        }
    }

    //Agrega acompañantes
    public void agregarPasajerosLista(List<Pasajero> pasajeros) {
        Scanner scanner = new Scanner(System.in);
        int rta = 0;
        boolean encontrado = false;
        int i = 0;
        do {
            try {
                System.out.println("\nDesea agregar acompañantes?\n1- Si\n2- No");
                rta = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Problema detectado");
                scanner.nextLine();
            }
        } while (rta == 0);

        if (rta == 1) {
            do {
                String dni = "";
                do {
                    try {
                        System.out.println("\nIngrese el Dni:");
                        dni = scanner.nextLine();
                        examinaDatosCompletos(dni);
                    } catch (ExcepcionDatoVacio e) {
                        System.out.println("Este dato debe ser cargado");

                    } catch (Exception e) {
                        System.out.println("No se ha podido registrar");
                    }
                } while (dni.compareTo("") == 0);

                boolean existe = buscarPasajeroDni(dni, pasajeros);
                if (existe) {
                    while (!encontrado && i < pasajeros.size()) {
                        if (dni.compareTo(pasajeros.get(i).getDni())==0) {
                            pasajeros.get(i).setTitularreserva(false);
                            this.listaPaxs.add(pasajeros.get(i));
                            encontrado = true;
                            System.out.println("El pasajero se encuentra en nuestros registros, fue cargado a la habitación");
                        }
                        i++;
                    }

                } else {
                    Pasajero pasajero = new Pasajero();
                    pasajero.setDni(dni);
                    this.listaPaxs.add(pasajero.cargarPasajeroAcompaniante(pasajeros));
                }
                do {
                    rta = 0;
                    try {
                        System.out.println("\nDesea agregar otro acompañante?:\n1- Si\n2- No");
                        rta = scanner.nextInt();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Debe ingresar un número");
                        scanner.nextLine();
                    } catch (Exception e) {
                        System.out.println("Problema detectado");
                        scanner.nextLine();
                    }
                } while (rta != 1 && rta != 2);

            } while (rta == 1);
        }

    }

    public boolean buscarPasajeroDni(String dni, List<Pasajero> pasajeros) {
        int i = 0;
        boolean encontrado = false;

        while (!encontrado && i < pasajeros.size()) {

            if (pasajeros.get(i).getDni().compareTo(dni)==0) {
                encontrado = true;
            }
            i++;
        }
        return encontrado;
    }

    public String mostrarListaPaxs() {
        String string = "";
        for (Pasajero lista : this.listaPaxs) {
            if (lista.getTitularreserva()) {
                string = "\nTitular: " + lista.getNombre() + " " + lista.getApellido();
            }
        }
        for (Pasajero lista : this.listaPaxs) {
            if (!lista.getTitularreserva()) {
                string += "\nAcompañante: " + lista.getNombre() + " " + lista.getApellido();
            }
        }
        return string;
    }


    @Override
    public String toString() {
        return "Ocupación: \nHabitación: " + this.nroHabitacion +
                "\nFecha de ingreso: " + this.fechaIngreso +
                "\nFecha de Salida: " + this.fechaSalida +
                "\nTipo de pensión: " + this.tipoPension.getNombre() +
                "\nCantidad de cocheras: " + this.cochera +
                "\nPasajeros: " + this.mostrarListaPaxs();
    }


    //Ordena ocupaciones por ID
    @Override
    public int compareTo(Ocupacion o) {
        if (numeroOcupacion < o.getNumeroOcupacion()) {
            return -1;
        }
        if (numeroOcupacion > o.getNumeroOcupacion()) {
            return 1;
        }
        return 0;
    }
}
