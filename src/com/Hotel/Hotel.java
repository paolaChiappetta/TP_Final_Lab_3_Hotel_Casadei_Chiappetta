package com.Hotel;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Hotel implements Serializable {

    private List<Habitacion> listaHabitaciones;
    private List<Reserva> listaReservas;
    private List<Empleado> empleados;
    private List<Pasajero> pasajeros;
    private List<Ocupacion> listaOcupaciones;
    private Shop shop;
    private List<String> facturasEmitidas;

    public Hotel() {
        this.listaHabitaciones = new ArrayList<>();
        this.listaReservas = new ArrayList<>();
        this.listaOcupaciones = new ArrayList<>();
        this.empleados = new ArrayList<>();
        this.pasajeros = new ArrayList<>();
        this.shop = new Shop();
    }

    public Hotel(List<Habitacion> listaHabitaciones, List<Reserva> listaReservas,
                 List<Empleado> empleados, List<Pasajero> pasajeros, List<Ocupacion> listaOcupaciones,
                 Shop shop, List<String> facturasEmitidas) {
        this.listaHabitaciones = listaHabitaciones;
        this.listaReservas = listaReservas;
        this.empleados = empleados;
        this.pasajeros = pasajeros;
        this.listaOcupaciones = listaOcupaciones;
        this.shop = shop;
        this.facturasEmitidas = facturasEmitidas;
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

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public List<Pasajero> getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(List<Pasajero> pasajeros) {
        this.pasajeros = pasajeros;
    }

    public List<Ocupacion> getListaOcupaciones() {
        return listaOcupaciones;
    }

    public void setListaOcupaciones(List<Ocupacion> listaOcupaciones) {
        this.listaOcupaciones = listaOcupaciones;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<String> getFacturasEmitidas() {
        return facturasEmitidas;
    }

    public void setFacturasEmitidas(List<String> facturasEmitidas) {
        this.facturasEmitidas = facturasEmitidas;
    }

    //BUSCA HABS LIBRES CON DETERMINADA FECHA DE INGRESO O DE SALIDA
    public List<Integer> habitacionesLibres(LocalDate ingreso, LocalDate salida) {

        List<Reserva> reservasHab = new ArrayList<>();
        List<Integer> habslibres = new ArrayList<>();
        if (!listaHabitaciones.isEmpty()) {
            for (Habitacion listaHab : this.listaHabitaciones) {
                for (Reserva listaRva : this.listaReservas) {
                    if (listaHab.getNumero() == listaRva.getNumeroHabitacion()) {
                        reservasHab.add(listaRva);
                    }
                }
                if (!reservasHab.isEmpty()) {
                    Collections.sort(reservasHab);
                    boolean encontrada = false;
                    for (int i = 0; i < reservasHab.size(); i++) {

                        if (i == 0 && salida.isBefore(reservasHab.get(i).getFechaIngreso()) || //si es la 1er reserva y salida
                                salida.isEqual(reservasHab.get(i).getFechaIngreso())) {         //es <= que la fecha de ingreso de la reserva

                            if (listaHab.getEstado().compareTo(EstadoHabitacion.FUERA_DE_SERVICIO) != 0) {  //si la hab no está fuera de servicio
                                System.out.println("\nHabitación: " + listaHab.getNumero() +                                                  //muestro nro de hab y tarifa
                                        "\nTarifa: " + listaHab.getTarifa() + "\nNoches desde la reserva anterior: sin reservas anteriores" + //muestro cuantas noches hay hasta la prox reserva
                                        "\nNoches hasta la reserva siguiente: " +
                                        ChronoUnit.DAYS.between(salida, reservasHab.get(i).getFechaIngreso()));

                                habslibres.add(listaHab.getNumero()); //agrego esa hab a la lista de habs disponibles

                            }
                            encontrada = true;

                        } else if (encontrada == false && i == reservasHab.size() - 1 &&       //si es la última reserva e ingreso es >=
                                ingreso.isAfter(reservasHab.get(i).getFechaSalida()) ||        //a la fecha de salida de la reserva
                                ingreso.isEqual(reservasHab.get(i).getFechaSalida())) {

                            if (listaHab.getEstado().compareTo(EstadoHabitacion.FUERA_DE_SERVICIO) != 0) {              //si la hab no está fuera de servicio
                                System.out.println("\nHabitación: " + listaHab.getNumero() +                            //muestro nro de hab y tarifa
                                        "\nTarifa: " + listaHab.getTarifa() + "\nNoches desde la reserva anterior: " +  //muestro cuantas noches hay desde la última reserva
                                        +ChronoUnit.DAYS.between(reservasHab.get(i).getFechaSalida(), ingreso) +
                                        "\nNoches hasta la reserva siguiente: sin reservas posteriores");

                                habslibres.add(listaHab.getNumero());
                            }
                            encontrada = true;

                        } else if (!encontrada && (ingreso.isAfter(reservasHab.get(i).getFechaSalida()) || //si estoy en una reserva del medio
                                ingreso.equals(reservasHab.get(i).getFechaSalida())) &&                           //verifico si ingreso es <=a la fecha de salida
                                (salida.isEqual(reservasHab.get(i + 1).getFechaIngreso()) ||                      //de la reserva y <= a la fecha de ingreso de
                                        salida.isBefore(reservasHab.get(i + 1).getFechaIngreso()))) {             //la proxima reserva
                            if (listaHab.getEstado().compareTo(EstadoHabitacion.FUERA_DE_SERVICIO) != 0) {        //si la hab no está fuera de servicio

                                System.out.println("\nHabitación: " + listaHab.getNumero() +                                      //muestro nro de hab y tarifa
                                        "\nTarifa: " + listaHab.getTarifa() + "\nNoches desde la reserva anterior: " +            //muestro cuantas noches hay desde la última reserva
                                        +ChronoUnit.DAYS.between(reservasHab.get(i).getFechaSalida(), ingreso) +  //y muestro cuantas noches hay hasta la prox reserva
                                        "\nNoches hasta la reserva siguiente: " +                                                                 //sirve para ver qué hab conviene reservar
                                        ChronoUnit.DAYS.between(salida, reservasHab.get(i + 1).getFechaIngreso()));

                                habslibres.add(listaHab.getNumero());
                            }

                            encontrada = true;
                        }
                    }
                } else {
                    System.out.println("\nHabitación: " + listaHab.getNumero() +
                            "\nTarifa: " + listaHab.getTarifa() + "\nNoches desde la reserva anterior: sin reservas anteriores" +
                            "\nNoches hasta la reserva siguiente: sin reservas posteriores");

                    habslibres.add(listaHab.getNumero()); //si no tiene reservas la agrego a la lista de habitaciones libres

                }

            }
        } else {
            System.out.println("No hay habitaciones cargadas");
        }

        return habslibres;

    }

    /*
        //BUSCA HABS LIBRES CON DETERMINADA FECHA DE INGRESO O DE SALIDA
        public List<Integer> habitacionesLibres(LocalDate ingreso, LocalDate salida) {
            List<Integer> habitaciones = new ArrayList<>();
            boolean encontrada = false;

            if (!listaHabitaciones.isEmpty()) { //si hay lista de habitaciones

                for (int i = 0; i < listaHabitaciones.size(); i++) { //recorro la lista de hab

                    if (!listaHabitaciones.get(i).getReservasHab().isEmpty()) { //si cada hab tiene su lista de reservas
                        Collections.sort(listaHabitaciones.get(i).getReservasHab()); //las ordeno por fecha en orden ascendente
                        encontrada = false;

                        for (int it = 0; it < listaHabitaciones.get(i).getReservasHab().size(); it++) {                             //recorro la lista de reservas de  esa hab
                            if (it == 0 && salida.isBefore(listaHabitaciones.get(i).getReservasHab().get(it).getFechaIngreso()) || //si es la 1er reserva y salida
                                    salida.isEqual(listaHabitaciones.get(i).getReservasHab().get(it).getFechaIngreso())) {         //es <= que la fecha de ingreso de la reserva

                                if (listaHabitaciones.get(i).getEstado().compareTo(EstadoHabitacion.FUERA_DE_SERVICIO) != 0) {  //si la hab no está fuera de servicio
                                    System.out.println("\nHabitación: " + listaHabitaciones.get(i).getNumero() +                                                  //muestro nro de hab y tarifa
                                            "\nTarifa: " + listaHabitaciones.get(i).getTarifa() + "\nNoches desde la reserva anterior: sin reservas anteriores" + //muestro cuantas noches hay hasta la prox reserva
                                            "\nNoches hasta la reserva siguiente: " +
                                            ChronoUnit.DAYS.between(salida, listaHabitaciones.get(i).getReservasHab().get(it).getFechaIngreso()));

                                    habitaciones.add(listaHabitaciones.get(i).getReservasHab().get(it).getNumeroHabitacion()); //agrego esa hab a la lista de habs disponibles

                                }

                                encontrada = true;

                            } else if (encontrada == false && it == listaHabitaciones.get(i).getReservasHab().size() - 1 &&       //si es la última reserva e ingreso es >=
                                    ingreso.isAfter(listaHabitaciones.get(i).getReservasHab().get(it).getFechaSalida()) ||        //a la fecha de salida de la reserva
                                    ingreso.isEqual(listaHabitaciones.get(i).getReservasHab().get(it).getFechaSalida())) {

                                if (listaHabitaciones.get(i).getEstado().compareTo(EstadoHabitacion.FUERA_DE_SERVICIO) != 0) {              //si la hab no está fuera de servicio
                                    System.out.println("\nHabitación: " + listaHabitaciones.get(i).getNumero() +                            //muestro nro de hab y tarifa
                                            "\nTarifa: " + listaHabitaciones.get(i).getTarifa() + "\nNoches desde la reserva anterior: " +  //muestro cuantas noches hay desde la última reserva
                                            +ChronoUnit.DAYS.between(listaHabitaciones.get(i).getReservasHab().get(it).getFechaSalida(), ingreso) +
                                            "\nNoches hasta la reserva siguiente: sin reservas posteriores");

                                    habitaciones.add(listaHabitaciones.get(i).getReservasHab().get(it).getNumeroHabitacion());
                                }
                                encontrada = true;


                            } else if (!encontrada && (ingreso.isAfter(listaHabitaciones.get(i).getReservasHab().get(it).getFechaSalida()) || //si estoy en una reserva del medio
                                    ingreso.equals(listaHabitaciones.get(i).getReservasHab().get(it).getFechaSalida())) &&                           //verifico si ingreso es <=a la fecha de salida
                                    (salida.isEqual(listaHabitaciones.get(i).getReservasHab().get(it + 1).getFechaIngreso()) ||                      //de la reserva y <= a la fecha de ingreso de
                                            salida.isBefore(listaHabitaciones.get(i).getReservasHab().get(it + 1).getFechaIngreso()))) {             //la proxima reserva
                                if (listaHabitaciones.get(i).getEstado().compareTo(EstadoHabitacion.FUERA_DE_SERVICIO) != 0) {        //si la hab no está fuera de servicio

                                    System.out.println("\nHabitación: " + listaHabitaciones.get(i).getNumero() +                                      //muestro nro de hab y tarifa
                                            "\nTarifa: " + listaHabitaciones.get(i).getTarifa() + "\nNoches desde la reserva anterior: " +            //muestro cuantas noches hay desde la última reserva
                                            +ChronoUnit.DAYS.between(listaHabitaciones.get(i).getReservasHab().get(it).getFechaSalida(), ingreso) +  //y muestro cuantas noches hay hasta la prox reserva
                                            "\nNoches hasta la reserva siguiente: " +                                                                 //sirve para ver qué hab conviene reservar
                                            ChronoUnit.DAYS.between(salida, listaHabitaciones.get(i).getReservasHab().get(it + 1).getFechaIngreso()));

                                    habitaciones.add(listaHabitaciones.get(i).getReservasHab().get(it).getNumeroHabitacion());
                                }


                                encontrada = true;
                            }

                        }
                    } else {
                        System.out.println("\nHabitación: " + listaHabitaciones.get(i).getNumero() +
                                "\nTarifa: " + listaHabitaciones.get(i).getTarifa() + "\nNoches desde la reserva anterior: sin reservas anteriores" +
                                "\nNoches hasta la reserva siguiente: sin reservas posteriores");

                        habitaciones.add(listaHabitaciones.get(i).getNumero()); //si no tiene reservas la agrego a la lista de habitaciones libres
                    }
                }

            } else {
                System.out.println("No hay habitaciones cargadas");
            }

            return habitaciones;
        }
    */
    public Ocupacion buscarOcupacionPorHabitacion(int numeroHab) {
        Ocupacion ocupacion = null;
        if (!this.listaOcupaciones.isEmpty()) {
            for (Ocupacion lista : this.listaOcupaciones) {
                if (lista.getNroHabitacion() == numeroHab) {
                    ocupacion = lista;
                }
            }
        }
        return ocupacion;
    }

    public boolean verificarHabitacionExistente(int nroHabitacion) {
        boolean habEncontrada = false;
        if (!this.listaHabitaciones.isEmpty()) {  //verifico que exista la hab
            for (Habitacion lista : listaHabitaciones) {
                if (lista.getNumero() == nroHabitacion) {
                    habEncontrada = true;
                }
            }
        }
        return habEncontrada;
    }

    public boolean verificarOcupacionExistente(int nroHabitacion) {
        boolean ocupacionEncontrada = false;
        if (!this.listaOcupaciones.isEmpty()) {  //verifico que exista la hab
            for (Ocupacion lista : listaOcupaciones) {
                if (lista.getNroHabitacion() == nroHabitacion) {
                    ocupacionEncontrada = true;
                }
            }
        }
        return ocupacionEncontrada;
    }

    public boolean nuevaReserva() {
        Scanner scanner = new Scanner(System.in);
        LocalDate ingreso;
        LocalDate salida;
        int nroHab;
        String continuar = "s";
        boolean habLibre = false;
        boolean reservaCargada = false;


        System.out.println("Ingrese fecha de ingreso de la nueva reserva (AAAA-MM-DD)");
        ingreso = LocalDate.parse(scanner.nextLine());
        System.out.println("Ingrese fecha de salida de la nueva reserva (AAAA-MM-DD)");
        salida = LocalDate.parse(scanner.nextLine());

        List<Integer> libres = this.habitacionesLibres(ingreso, salida);
        if (libres.isEmpty()) {
            System.out.println("No hay habitaciones disponibles en las fechas indicadas");
        } else {
            Reserva reserva = new Reserva();
            System.out.println("\nIndique el número de la habitación elegida");
            nroHab = scanner.nextInt();
            for (Integer lista : libres) {
                if (lista == nroHab) {
                    reserva.cargarReserva(reserva, nroHab, ingreso, salida);
                    System.out.println("Reserva cargada satisfactoriamente");
                    System.out.println(reserva);
                    this.listaReservas.add(reserva);
                    habLibre = true;
                    reservaCargada = true;
                }
            }
            if (habLibre == false) {
                System.out.println("La habitación no existe o no está libre en las fechas indicadas");
            }

        }
        return reservaCargada;

    }

    public boolean verificarExistenciaReserva(Long idReserva) {
        boolean encontrada = false;
        int i = 0;

        if (!this.listaReservas.isEmpty()) {

            while (!encontrada && i < this.listaReservas.size()) {

                if (this.listaReservas.get(i).getNumeroReserva().equals(idReserva)) {
                    encontrada = true;
                }
                i++;
            }

        }
        return encontrada;
    }

    //METODO REALIZAR CHECK IN CON O SIN RESERVA PREVIA

    public void checkIn() {
        Scanner scanner = new Scanner(System.in);
        int tieneReserva;
        Long idReserva;

        System.out.println("Indique si el pasajero tiene reserva: \n1- Si\n2- No"); //se consulta si el pasajero tiene reserva
        tieneReserva = scanner.nextInt();
        scanner.nextLine();

        if (tieneReserva == 1) {   //si tiene reserva
            System.out.println("Indique el Id de la reserva: ");  //se solicita el id al recepcionista
            idReserva = scanner.nextLong();
            if (verificarExistenciaReserva(idReserva)) { //se verifica

                boolean encontrada = false;
                int i = 0;
                while (!encontrada && i < listaReservas.size()) {
                    if (listaReservas.get(i).getNumeroReserva() == idReserva) {  //si esta en la lista de reservas
                        nuevaOcupacion(listaReservas.get(i));  //se genera una ocupación
                        encontrada = true;
                    }
                    i++;
                }

            } else {
                System.out.println("No hay reservas que coincidan con el id indicado");
            }
        } else {
            Boolean res = nuevaReserva();  //si no tiene reserva, se genera una al momento del ingreso
            if (res == true) {
                nuevaOcupacion(listaReservas.get(listaReservas.size() - 1));  //y se genera una nueva ocupación a partir de la reserva
            } else {
                System.out.println("no se pudo realizar check in");
            }
        }
    }

    //CHECK OUT DE OCUPACIÓN - SE ELIMINA LA OCUPACION/RESERVA/SE EMITE FACTURA/SE CARGA FACTURA A LA LISTA DE EMITIDAS DEL HOTEL
    public void checkOut(int nroHabitacion) {
        Scanner scanner = new Scanner(System.in);
        boolean ocupacionEncontrada = false;
        int i = 0;

        if (!this.listaOcupaciones.isEmpty()) { //verifica que existan ocupaciones

            while (!ocupacionEncontrada && i < this.listaOcupaciones.size()) { //recorro la lista para hacer el check Out de la hab indicada

                if (this.listaOcupaciones.get(i).getNroHabitacion() == nroHabitacion) { //cuando la encuentra
                    Factura nuevaFactura = new Factura();                                    //genera nueva factura
                    String factura;
                    nuevaFactura.setOcupacion(this.listaOcupaciones.get(i));                 //le paso la ocupacion a la factura
                    int tipoFactura = 0;
                    System.out.println("\nQué tipo de factura desea emitir?");               //solicito el tipo de factura a emitir
                    System.out.println("\n1- Factura Tipo A\n2- Factura Tipo B\n3- Factura Tipo C");
                    tipoFactura = scanner.nextInt();
                    if (tipoFactura == 1) {                                                      //le paso el tipo a la factura
                        nuevaFactura.setTipoFactura(TipoFactura.FACTURA_A);
                    } else if (tipoFactura == 2) {
                        nuevaFactura.setTipoFactura(TipoFactura.FACTURA_B);
                    } else {
                        nuevaFactura.setTipoFactura(TipoFactura.FACTURA_C);
                    }
                    System.out.println(nuevaFactura);                                      //muestro la factura
                    facturasEmitidas.add(factura = nuevaFactura.toString());                 //la guardo como string en el listado de facturas del hotel
                    this.listaOcupaciones.remove(this.listaOcupaciones.get(i));            //elimino la ocupación de la lista

                    if (!this.listaReservas.isEmpty()) {
                        int j = 0;
                        boolean reservaEncontrada = false;

                        while (!reservaEncontrada && j < this.listaReservas.size()) {

                            if (this.listaReservas.get(j).getNumeroReserva() == this.listaOcupaciones.get(i).getIdReserva()) { //busco reserva por id
                                this.listaReservas.remove(this.listaReservas.get(j));       //elimino la reserva de la lista general de reservas
                                reservaEncontrada = true;

                            }

                            j++;
                        }
                    }
                    ocupacionEncontrada = true;
                }
                i++;
            }
        } else {
            System.out.println("El hotel no tiene habitaciones ocupadas");
        }
        if (!ocupacionEncontrada) {
            System.out.println("No se encontró la ocupación");
        }
    }

    //MUESTRA EL LISTADO DE INGRESOS DEL DIA DE HOY
    public void listadoIngresosDelDia() {
        if (!this.listaReservas.isEmpty()) { //busca en la lista de reservas
            for (Reserva lista : listaReservas) {
                System.out.println("\nIngresos del día\n");
                if (lista.getFechaIngreso().isEqual(LocalDate.now())) { //coincidencias en la fecha de ingreso
                    System.out.println(lista);
                }
            }
        } else {
            System.out.println("El hotel no posee reservas");
        }
    }

    //MUESTRA EL LISTADO DE EGRESOS DEL DIA DE HOY
    public void listadoEgresosDelDia() {
        if (!this.listaOcupaciones.isEmpty()) {
            for (Ocupacion lista : listaOcupaciones) { //busca en la lista de ocupaciones
                System.out.println("\nEgresos del día\n");
                if (lista.getFechaSalida().isEqual(LocalDate.now())) { //coincidencias en la fecha de salida
                    System.out.println(lista);
                }
            }
        } else {
            System.out.println("El hotel no posee habitaciones ocupadas");
        }
    }

    //MUESTRA EL LISTADO DE INGRESOS DE UN DIA DETERMINADO
    public void listadoIngresosDeReservasDeDiaDeterminado(LocalDate dia) {
        if (!this.listaReservas.isEmpty()) {
            for (Reserva lista : listaReservas) { //busca en la lista de reservas
                System.out.println("\nIngresos del día: " + dia + "\n");
                if (lista.getFechaIngreso().isEqual(dia)) { //coincidencias en la fecha de ingreso indicada
                    System.out.println(lista);
                }
            }
        } else {
            System.out.println("El hotel no posee ingresos el día " + dia);
        }
    }

    //MUESTRA EL LISTADO DE EGRESOS DE UN DIA DETERMINADO
    public void listadoEgresosDeDiaDeterminado(LocalDate dia) {
        if (!this.listaReservas.isEmpty()) {
            for (Reserva lista : listaReservas) { //busca en la lista de reservas
                System.out.println("\nEgresos del día: " + dia + "\n");
                if (lista.getFechaSalida().isEqual(dia)) { //coincidencias en la fecha de egreso indicada
                    System.out.println(lista);
                }
            }
        } else {
            System.out.println("El hotel no posee egresos el día " + dia);
        }
    }

    //MUESTRA EL LISTADO DE HABITACIONES
    public void listadoHabitaciones() {
        if (!this.listaHabitaciones.isEmpty()) {
            System.out.println("Listado de habitaciones\n");
            for (Habitacion lista : listaHabitaciones) {
                System.out.println(lista);
            }
        } else {
            System.out.println("El hotel no tiene habitaciones cargadas");
        }
    }

    //MUESTRA EL LISTADO DE HABITACIONES OCUPADAS Y SUS DATOS
    public void listadoOcupaciones() {
        if (!this.listaOcupaciones.isEmpty()) {
            System.out.println("Listado de ocupaciones\n");
            for (Ocupacion lista : listaOcupaciones) {
                System.out.println(lista);
            }
        } else {
            System.out.println("El hotel no tiene habitaciones ocupadas");
        }
    }
/*
    public LocalDate fechaProximaOcupacion(int nroHabitacion) {
        LocalDate proxima = null;

        for (Habitacion listaHab : this.listaHabitaciones) {  //Busco la habitación
            if (listaHab.getNumero() == nroHabitacion) {
                Collections.sort(listaHab.getReservasHab()); //ordeno sus reservas
                if (listaHab.getEstado().compareTo(EstadoHabitacion.OCUPADA) == 0) { //si la habitación está ocupada
                    boolean encontrada = false;
                    int i = 0;
                    while (!encontrada && i < listaHab.getReservasHab().size()) {  //busca en su lista de reservas el próximo ingreso
                        for (Ocupacion listaOcup : this.listaOcupaciones) {
                            if (listaOcup.getIdReserva() == listaHab.getReservasHab().get(i).getNumeroReserva()) {
                                proxima = listaHab.getReservasHab().get(i + 1).getFechaIngreso(); //si no hay proxima, queda en null
                                encontrada = true;
                            }
                        }
                        i++;
                    }
                } else if (listaHab.getEstado().compareTo(EstadoHabitacion.DISPONIBLE) == 0) { //si está disponible
                    proxima = listaHab.getReservasHab().get(0).getFechaIngreso();   //se indica la primer reserva, si no hay queda en null
                }
            }
        }
        return proxima;
    }

    public void extenderFechaSalida(int nroHabitacion, long nochesExtra) {
        LocalDate fecha = fechaProximaOcupacion(nroHabitacion);
        boolean posible = false;
        long diasExtendibles = 0;
        if (fecha == null) {
            for (Ocupacion ocupacion : this.listaOcupaciones) {
                if (ocupacion.getHabitacion().getNumero() == nroHabitacion) {
                    diasExtendibles = 300;
                    posible = true;
                }
            }
        } else {
            for (Ocupacion ocupacion : this.listaOcupaciones) {
                if (ocupacion.getHabitacion().getNumero() == nroHabitacion) {
                    diasExtendibles = ChronoUnit.DAYS.between(ocupacion.getFechaSalida(), fecha);
                    posible = true;
                }
            }
        }

        if (posible) {
            if (fecha == null || diasExtendibles >= nochesExtra) {
                for (Ocupacion listaOcup : this.listaOcupaciones) {
                    if (listaOcup.getHabitacion().getNumero() == nroHabitacion) {
                        listaOcup.setFechaSalida(listaOcup.getFechaSalida().plusDays(nochesExtra));
                        for (Reserva listaRva : this.listaReservas) {
                            if (listaRva.getNumeroReserva() == listaOcup.getIdReserva()) {
                                listaRva.setFechaSalida(listaRva.getFechaSalida().plusDays(nochesExtra));
                                for (Habitacion listaHabs : this.listaHabitaciones) {
                                    for (Reserva reservas : listaHabs.getReservasHab()) {
                                        if (reservas.getNumeroReserva() == listaRva.getNumeroReserva()) {
                                            reservas.setFechaSalida(reservas.getFechaSalida().plusDays(nochesExtra));
                                            System.out.println("\nSe extendió existosamente la fecha de salida");
                                            System.out.println(listaOcup);
                                        }
                                    }
                                }
                            }
                        }

                    }

                }
            } else {
                System.out.println("La habitación no posee " + nochesExtra + " noches disponibles");
            }
        } else {
            System.out.println("La habitación indicada no se encuentra ocupada");
        }
    }
    */


    /// Nueva ocupacion con reserva previa (si el pasajero no tiene, se genera una en el momento del ingreso


    public void nuevaOcupacion(Reserva reserva) {
        Scanner scanner = new Scanner(System.in);
        Ocupacion ocupacion = new Ocupacion();

        ocupacion.setIdReserva(reserva.getNumeroReserva());  //se toman estos datos de la reserva
        ocupacion.setFechaIngreso(reserva.getFechaIngreso());
        ocupacion.setFechaSalida(reserva.getFechaSalida());
        System.out.println("Cantidad cocheras: ");  //se agrega cantidad de cocheras si el pasajero quiere una o más
        ocupacion.setCochera(scanner.nextInt());
        boolean encontrada = false;
        int i = 0;
        while (!encontrada && i < this.listaHabitaciones.size()) {
            if (this.listaHabitaciones.get(i).getNumero() == reserva.getNumeroHabitacion()) {
                ocupacion.setNroHabitacion(this.listaHabitaciones.get(i).getNumero());  //se le agrega la hab a la ocupación
                this.listaHabitaciones.get(i).setEstado(EstadoHabitacion.OCUPADA); //cambio el estado de la hab
            }
            i++;
        }

        ocupacion.setCantidadPax(reserva.getNumeroPasajeros());  //cantidad de pasajeros
        System.out.println("Tipo de pensión");
        ocupacion.asignarTipoPension(); //tipo de pensión (desayuno, media pensión o pensión completa)
        ocupacion.agregarPasajerosLista(reserva, this.pasajeros); //agrego pasajero titular
        ocupacion.agregarPasajerosLista(this.pasajeros);         //agrego acompañantes
        ocupacion.setDeposito(reserva.getDeposito());  //monto del depósito

        this.listaOcupaciones.add(ocupacion);  //se agrega la nueva ocupación a la lista
        System.out.println("\nOcupación cargada satisfactoriamente");
        System.out.println(ocupacion);  //se muestra
    }

    //LISTADO RESERVAS POR DNI

    public void listadoReservasPorDni(String dni) {
        boolean encontrada = false;
        if (!this.listaReservas.isEmpty()) {

            System.out.println("\nReservas del pasajero: \n");
            for (Reserva reserva : this.listaReservas) { //busca en la lista de reservas
                if (reserva.getPasajeroDni().compareTo(dni) == 0) {  //si hay coincidencias del dni
                    System.out.println(reserva);  //muestra sus reservas (puede ser una o más de una para el mismo pasajero
                    encontrada = true;
                }
            }
        } else {
            System.out.println("El hotel no posee reservas");
        }
        if (!encontrada) {
            System.out.println("El pasajero no tiene reservas");
        }
    }

    //LISTADO DE HABITACIONES POR ESTADO: DISPONIBLE/OCUPADA/FUERA DE SERVICIO
    public void listadoHabitacionesPorEstado(EstadoHabitacion estado) {
        int contador = 0;
        if (!this.listaHabitaciones.isEmpty()) {
            System.out.println("Habitaciones de estado " + estado + "\n");
            for (Habitacion lista : this.listaHabitaciones) {
                if (lista.getEstado().compareTo(estado) == 0) {
                    System.out.println(lista);
                    contador++;
                }
            }
        } else {
            System.out.println("El hotel no posee habitaciones cargadas");
        }
        if (contador == 0) {
            System.out.println("El hotel no posee habitaciones de estado " + estado);
        } else {
            System.out.println("\nCantidad de habitaciones de estado " + estado + ": " + contador);
        }

    }

    public Habitacion buscarHabPorNro(int nroHabitacion) {
        Habitacion habitacion = null;
        if (!this.listaHabitaciones.isEmpty()) {
            for (Habitacion lista : this.listaHabitaciones) {
                if (lista.getNumero() == nroHabitacion) {
                    habitacion = lista;
                }
            }
        }
        return habitacion;
    }


    // CREAR NUEVA HABITACION, LA CREA EN EL INTERIOR DEL METODO

    public void crearNuevaHabitacion() {
        Habitacion habitacion = new Habitacion();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nueva habitacion:\n");

        System.out.println("Numero de habitacion:");
        habitacion.setNumero(scanner.nextInt());
        System.out.println("Piso:");
        habitacion.setPiso(scanner.nextInt());
        System.out.println("Tarifa:");
        habitacion.indicarTipoHabitacion();
        System.out.println("Estado de la habitacion:");
        habitacion.indicarEstadoHabitacion();

        System.out.println("Datos nueva habitacion: ");
        System.out.println(habitacion);
    }

    //CREA UNA HABITACION Y LA DEVUELVE

    public Habitacion crearYdevolverHabitacion() {

        Habitacion habitacion = new Habitacion();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nueva habitacion:\n");

        System.out.println("Numero de habitacion:");
        habitacion.setNumero(scanner.nextInt());
        System.out.println("Piso:");
        habitacion.setPiso(scanner.nextInt());
        System.out.println("Tarifa:");
        habitacion.indicarTipoHabitacion();
        System.out.println("Estado de la habitacion:");
        habitacion.indicarEstadoHabitacion();


        System.out.println("Datos nueva habitacion: ");
        System.out.println(habitacion);

        return habitacion;
    }


    //MENU MODIFICAR HABITACION

    //MUESTRA EL LISTADO DE RESERVAS X HABITACION

    public void listadoReservasPorHabitacion(int numeroHab) {
        if (!this.listaReservas.isEmpty()) {
            for (Reserva reserva : listaReservas) { //busca en la lista de reservas
                System.out.println("\nReservas de Habitacion numero " + numeroHab + "\n");
                if (reserva.getNumeroHabitacion() == numeroHab) { //coincidencias en num d ehab
                    System.out.println(reserva);
                }
            }
        } else {
            System.out.println("La habitacion numero " + numeroHab + " no tiene reservas");
        }
    }


    public Reserva proximaOcupacionDeHabitacion(int numeroHab) {
        List<Reserva> listReservaHab = new ArrayList<>();

        if (!this.listaReservas.isEmpty()) {
            for (Reserva lista : listaReservas) { //busca en la lista de reservas
                System.out.println("\nReservas de Habitacion numero " + numeroHab + "\n");
                if (lista.getNumeroHabitacion() == numeroHab) { //coincidencias en la fecha de ingreso indicada
                    listReservaHab.add(lista);
                }
            }

            Collections.sort(listReservaHab);                   //ordena la lista de las reservas de esa hab

        } else {
            System.out.println("La habitacion numero " + numeroHab + " no tiene reservas");
        }
        return listReservaHab.get(0);           //devuelve lña primera reserva
    }

    //FUNCION MODIFICAR DATOS RESERVA

    public void menuModificarReserva() {

        System.out.println("1: Nombre");
        System.out.println("2: Apellido");
        System.out.println("3: Dni");
        System.out.println("4: Numero de telefono");
        System.out.println("5: Numero de pasajeros");
        System.out.println("6: Fecha de Ingreso");
        System.out.println("7: Fecha de salida");
        System.out.println("8: Numero de habitacion");
        System.out.println("9: Deposito");

        System.out.println("\n0 para finalizar");

    }

    //////////////////////// METODO MODIFICAR RESERVA TIENE ERROR AL LEER STRINGS 

    public void modificarReserva(Reserva reserva) {


        String continuar= "s";
        int opcion = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Indique que datos desea modificar: ");


            menuModificarReserva();

            opcion = scanner.nextInt();

            scanner.nextLine();
            switch (opcion) {
                case 1:
                    scanner.nextLine();
                    System.out.println("Indique el Nombre:");
                    reserva.setPasajeroNombre(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("Indique el Apellido:");
                    reserva.setPasajeroApellido(scanner.nextLine());
                    break;
                case 3:
                    System.out.println("Indique el Dni:");
                    reserva.setPasajeroDni(scanner.nextLine());
                    break;
                case 4:
                    System.out.println("Numero de telefono:");
                    reserva.setTelefono(scanner.nextLine());
                    break;
                case 5:
                    System.out.println("Numero de pasajeros:");
                    reserva.setNumeroPasajeros(scanner.nextInt());
                    break;
                case 6:
                    System.out.println("Fecha de ingreso:");
                    reserva.setFechaIngreso(LocalDate.parse(scanner.next(), DateTimeFormatter.BASIC_ISO_DATE));
                    break;
                case 7:
                    System.out.println("Fecha de salida:");
                    reserva.setFechaSalida(LocalDate.parse(scanner.next(), DateTimeFormatter.BASIC_ISO_DATE));
                    break;
                case 8:
                    System.out.println("Numero de habitacion:");

                    List<Integer> listHabLibres = habitacionesLibres(reserva.getFechaIngreso(), reserva.getFechaSalida());

                    if (listHabLibres.isEmpty()) {
                        System.out.println("No hay habitaciones disponibles en las fechas indicadas");
                    } else {
                        int habAnterior = reserva.getNumeroHabitacion();  // guarda num de hab original
                        System.out.println("Indique el numero de habitacion que desea reservar: ");
                        int numeroHab = scanner.nextInt();

                        reserva.setNumeroHabitacion(numeroHab);
                    }
                    break;
                case 9:
                    System.out.println("Deposito:");
                    reserva.setDeposito(scanner.nextDouble());
                    break;

                default:
                    System.out.println("Opcion incorrecta, ingrese nuevamente");
                    break;
            }

            scanner.nextLine();
            System.out.println("Desea modificar otro dato? ");
            continuar= scanner.nextLine();

        } while (continuar.compareTo("s")==0);

        System.out.println(reserva);
    }

    //ELIMINAR RESERVA

    public void eliminarReserva (Long id){
       if(!listaReservas.isEmpty()){
           for(int i=0; i < listaReservas.size(); i++){
               if(listaReservas.get(i).getNumeroReserva()== id){
                   listaReservas.remove(1);
                   System.out.println("Reserva eliminada");
               }else{
                   System.out.println("no se encontro reserva con id "+ id);
               }
           }
       }
    }

    //ELIMINAR EMPLEADO

    public void eliminarEmpleado (String dni){
        if(!empleados.isEmpty()){
            for(int i=0; i < empleados.size(); i++){
                if(empleados.get(i).getDni().compareTo(dni) == 0){
                    empleados.remove(1);
                    System.out.println("Empleado eliminado");
                }else{
                    System.out.println("no se encontro empleado con dni "+ dni);
                }
            }
        }
    }

    //ELIMINAR HABITACION

    public void eliminarHabitacion (int numero){
        if(!listaHabitaciones.isEmpty()){
            for(int i=0; i < listaHabitaciones.size(); i++){
                if(listaHabitaciones.get(i).getNumero() == numero){
                    listaHabitaciones.remove(1);
                    System.out.println("Habitacion eliminada");
                }else{
                    System.out.println("no se encontro habitacion numero "+ numero);
                }
            }
        }
    }


    public void generarNuevoEmpleado() {
        Scanner scanner = new Scanner(System.in);
        String nombre, apellido, telefono, dni;
        int opcion;

        System.out.println("Nombre:");
        nombre = scanner.nextLine();
        System.out.println("Apellio:");
        apellido = scanner.nextLine();
        System.out.println("Dni:");
        dni = scanner.nextLine();
        System.out.println("Telefono:");
        telefono = scanner.nextLine();

        System.out.println("Indique:  1= Recepcionista   2= Administrador");
        opcion = scanner.nextInt();

        if (opcion == 1) {

            Recepcionista recepcionista = new Recepcionista(nombre, apellido, telefono, dni);

            empleados.add(recepcionista);
        } else {

            Administrador administrador = new Administrador(nombre, apellido, telefono, dni);

            empleados.add(administrador);

        }

    }




    public Empleado generarYdevolverNuevoEmpleado() {
        Scanner scanner = new Scanner(System.in);
        String nombre, apellido, telefono, dni;
        int opcion;

        System.out.println("Nombre:");
        nombre = scanner.nextLine();
        System.out.println("Apellio:");
        apellido = scanner.nextLine();
        System.out.println("Dni:");
        dni = scanner.nextLine();
        System.out.println("Telefono:");
        telefono = scanner.nextLine();

        System.out.println("Indique:  1= Recepcionista   2= Administrador");
        opcion = scanner.nextInt();

        if (opcion == 1) {

            Recepcionista recepcionista = new Recepcionista(nombre, apellido, telefono, dni);

            empleados.add(recepcionista);
            return recepcionista;
        } else {

            Administrador administrador = new Administrador(nombre, apellido, telefono, dni);

            empleados.add(administrador);

            return administrador;
        }
    }

    public Empleado verificarUsuarioyContrasenia(String usuario, String clave){
        Empleado empleado=null;
        if(!this.empleados.isEmpty()){
            for(Empleado lista : this.empleados){
                if(lista.getUsuario().compareTo(usuario)==0){
                    if(lista.getClave().compareTo(clave)==0){
                        empleado=lista;
                    }else{
                        System.out.println("\nContraseña incorrecta. Intente nuevamente");
                    }
                }else{
                    System.out.println("\nUsuario incorrecto. Intente nuevamente");
                }
            }
        }
        return empleado;
    }




}