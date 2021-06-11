package com.Hotel;

import jdk.jshell.Snippet;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.*;

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
        this.facturasEmitidas = new ArrayList<>();
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


    ///METODO PARA EXCEPTION DE VERIFICAR SI HAY DATOS VACIOS

    public void examinaDatosCompletos(String dato) throws ExcepcionDatoVacio {

        if (dato.compareTo("") == 0) {                                   //COMPARA EL DATO RECIBIDO POR PARAMETRO CON ""
            throw new ExcepcionDatoVacio("El dato no está completo");

        }
    }


    //BUSCA HABS LIBRES CON DETERMINADA FECHA DE INGRESO O DE SALIDA
    public List<Integer> habitacionesLibres(LocalDate ingreso, LocalDate salida) {

        List<Reserva> reservasHab = new ArrayList<>();
        List<Integer> habslibres = new ArrayList<>();
        if (!listaHabitaciones.isEmpty()) {
            System.out.println("\nHabitaciones libres: ");
            for (Habitacion listaHab : this.listaHabitaciones) {  //recorro las habitaciones
                reservasHab.removeAll(reservasHab);
                for (Reserva listaRva : this.listaReservas) {  //recorro las reservas
                    if (listaHab.getNumero() == listaRva.getNumeroHabitacion()) {  //filtro por habitación
                        reservasHab.add(listaRva);  //se arma lista de reservas por habitación
                    }
                }

                if (!reservasHab.isEmpty()) {
                    Collections.sort(reservasHab);  //se ordena la lista
                    boolean encontrada = false;
                    for (int i = 0; i < reservasHab.size(); i++) {  //a partir de ahí se busca el espacio

                        if (i == 0 && (salida.isBefore(reservasHab.get(i).getFechaIngreso()) || //si es la 1er reserva y salida
                                salida.isEqual(reservasHab.get(i).getFechaIngreso()))) {         //es <= que la fecha de ingreso de la reserva

                            if (listaHab.getEstado().compareTo(EstadoHabitacion.FUERA_DE_SERVICIO) != 0) {  //si la hab no está fuera de servicio
                                System.out.println("\nHabitación: " + listaHab.getNumero() +                                                  //muestro nro de hab y tarifa
                                        "\nTarifa: " + listaHab.getTarifa() + "\nNoches desde la reserva anterior: sin reservas anteriores" + //muestro cuantas noches hay hasta la prox reserva
                                        "\nNoches hasta la reserva siguiente: " +
                                        ChronoUnit.DAYS.between(salida, reservasHab.get(i).getFechaIngreso()));

                                habslibres.add(listaHab.getNumero()); //agrego esa hab a la lista de habs disponibles

                            }
                            encontrada = true;

                        } else if (!encontrada && i == reservasHab.size() - 1 &&       //si es la última reserva e ingreso es >=
                                (ingreso.isAfter(reservasHab.get(i).getFechaSalida()) ||        //a la fecha de salida de la reserva
                                        ingreso.isEqual(reservasHab.get(i).getFechaSalida()))) {

                            if (listaHab.getEstado().compareTo(EstadoHabitacion.FUERA_DE_SERVICIO) != 0) {              //si la hab no está fuera de servicio
                                System.out.println("\nHabitación: " + listaHab.getNumero() +                            //muestro nro de hab y tarifa
                                        "\nTarifa: " + listaHab.getTarifa() + "\nNoches desde la reserva anterior: " +  //muestro cuantas noches hay desde la última reserva
                                        ChronoUnit.DAYS.between(reservasHab.get(i).getFechaSalida(), ingreso) +
                                        "\nNoches hasta la reserva siguiente: sin reservas posteriores");

                                habslibres.add(listaHab.getNumero());
                            }
                            encontrada = true;

                        } else if (!encontrada && (ingreso.isAfter(reservasHab.get(i).getFechaSalida()) ||        //si estoy en una reserva del medio
                                ingreso.equals(reservasHab.get(i).getFechaSalida())) &&                           //verifico si ingreso es <=a la fecha de salida
                                (salida.isEqual(reservasHab.get(i + 1).getFechaIngreso()) ||                      //de la reserva y <= a la fecha de ingreso de
                                        salida.isBefore(reservasHab.get(i + 1).getFechaIngreso()))) {             //la proxima reserva
                            if (listaHab.getEstado().compareTo(EstadoHabitacion.FUERA_DE_SERVICIO) != 0) {        //si la hab no está fuera de servicio

                                System.out.println("\nHabitación: " + listaHab.getNumero() +                                      //muestro nro de hab y tarifa
                                        "\nTarifa: " + listaHab.getTarifa() + "\nNoches desde la reserva anterior: " +            //muestro cuantas noches hay desde la última reserva
                                        ChronoUnit.DAYS.between(reservasHab.get(i).getFechaSalida(), ingreso) +                  //y muestro cuantas noches hay hasta la prox reserva
                                        "\nNoches hasta la reserva siguiente: " +                                                 //sirve para ver qué hab conviene reservar
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

    //Busca si una habitación en particular está libre en determinada fecha para modificar las fechas de la reserva
    public boolean habitacionLibre(LocalDate ingreso, LocalDate salida, int nroHabitacion, long idReserva) {
        boolean libre = false;
        List<Reserva> reservas = new ArrayList<>();
        for (Reserva lista : this.listaReservas) {
            if (lista.getNumeroHabitacion() == nroHabitacion) {
                if (lista.getNumeroReserva() != idReserva) {
                    reservas.add(lista);
                }

            }
        }
        Collections.sort(reservas);
        if (!reservas.isEmpty()) {
            for (int i = 0; i < reservas.size(); i++) {  //a partir de ahí se busca el espacio

                if (i == 0 && salida.isBefore(reservas.get(i).getFechaIngreso()) || //si es la 1er reserva y salida
                        salida.isEqual(reservas.get(i).getFechaIngreso())) {         //es <= que la fecha de ingreso de la reserva
                    libre = true;

                } else if (!libre && i == reservas.size() - 1 &&       //si es la última reserva e ingreso es >=
                        ingreso.isAfter(reservas.get(i).getFechaSalida()) ||        //a la fecha de salida de la reserva
                        ingreso.isEqual(reservas.get(i).getFechaSalida())) {

                    libre = true;

                } else if (!libre && (ingreso.isAfter(reservas.get(i).getFechaSalida()) ||        //si estoy en una reserva del medio
                        ingreso.equals(reservas.get(i).getFechaSalida())) &&                           //verifico si ingreso es <=a la fecha de salida
                        (salida.isEqual(reservas.get(i + 1).getFechaIngreso()) ||                      //de la reserva y <= a la fecha de ingreso de
                                salida.isBefore(reservas.get(i + 1).getFechaIngreso()))) {
                    libre = true;
                }
            }

        } else {
            libre = true;
        }
        return libre;
    }

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
        LocalDate ingreso = null;
        LocalDate salida = null;
        int nroHab = 0;
        String continuar = "s";
        boolean habLibre = false;
        boolean reservaCargada = false;

        do {
            try {
                System.out.println("Ingrese fecha de ingreso de la nueva reserva (AAAA-MM-DD)");
                ingreso = LocalDate.parse(scanner.nextLine());
                if(ingreso.isBefore(LocalDate.now())){
                    System.out.println("La fecha de ingreso debe ser posterior al día de hoy");
                    ingreso=null;
                }
            } catch (DateTimeParseException e) {
                System.out.println("\nIngrese la fecha nuevamente en el formato indicado");
                ingreso = null;
            } catch (Exception e) {
                System.out.println("\nIngrese la fecha nuevamente");
                ingreso = null;
            }
        } while (ingreso == null);
        do {
            try {
                System.out.println("Ingrese fecha de salida de la nueva reserva (AAAA-MM-DD)");
                salida = LocalDate.parse(scanner.nextLine());
                if (salida.isBefore(ingreso)) {
                    System.out.println("\nLa fecha de salida no puede ser anterior al ingreso");
                    salida = null;
                }
            } catch (DateTimeParseException e) {
                System.out.println("\nIngrese la fecha nuevamente en el formato indicado");
                salida = null;
            } catch (Exception e) {
                System.out.println("\nIngrese la fecha nuevamente");
                salida = null;
            }
        } while (salida == null);

        List<Integer> libres = this.habitacionesLibres(ingreso, salida);  //busco las habitaciones libres por las fechas indicadas
        if (libres.isEmpty()) {
            System.out.println("No hay habitaciones disponibles en las fechas indicadas");
        } else {

            Reserva reserva = new Reserva();  //se genera
            do {
                try {
                    System.out.println("\nIndique el número de la habitación elegida");
                    nroHab = scanner.nextInt();
                    scanner.nextLine();

                } catch (InputMismatchException e) {
                    System.out.println("Debe ingresar un número");
                    scanner.nextLine();
                } catch (Exception e) {
                    System.out.println("Problema detectado");
                    scanner.nextLine();
                }
            } while (nroHab == 0);

            for (Integer lista : libres) {
                if (lista == nroHab) { //verifico que la hab elegida esté en ese listado de hab libres
                    cargarReserva(reserva, nroHab, ingreso, salida);
                    System.out.println("Reserva cargada satisfactoriamente");
                    System.out.println(reserva);
                    this.listaReservas.add(reserva);
                    habLibre = true;
                    reservaCargada = true;
                }
            }
            if (!habLibre) {
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
        int tieneReserva = 0;
        Long idReserva = 0L;

        do {
            try {
                System.out.println("Indique si el pasajero tiene reserva: \n1- Si\n2- No"); //se consulta si el pasajero tiene reserva
                tieneReserva = scanner.nextInt();
                scanner.nextLine();

            } catch (InputMismatchException e) {
                System.out.println("Opcion incorrecta");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Problema detectado");
                scanner.nextLine();
            }

        } while (tieneReserva != 1 && tieneReserva != 2);

        if (tieneReserva == 1) {   //si tiene reserva
            do {
                try {
                    System.out.println("Indique el Id de la reserva: ");  //se solicita el id al recepcionista
                    idReserva = scanner.nextLong();
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("El dato es incorrecto");
                    scanner.nextLine();
                } catch (Exception e) {
                    System.out.println("Problema detectado");
                    scanner.nextLine();
                }

            } while (idReserva == 0);

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
            boolean res = nuevaReserva();  //si no tiene reserva, se genera una al momento del ingreso
            if (res) {
                nuevaOcupacion(listaReservas.get(listaReservas.size() - 1));  //y se genera una nueva ocupación a partir de la reserva
            } else {
                System.out.println("\nNo se pudo realizar check in");
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
                    nuevaFactura.setOcupacion(this.listaOcupaciones.get(i));                 //le paso la ocupacion a la factura
                    int tipoFactura = 0;
                    System.out.println("\nQué tipo de factura desea emitir?");               //solicito el tipo de factura a emitir
                    do {
                        try {
                            System.out.println("\n1- Factura Tipo A\n2- Factura Tipo B\n3- Factura Tipo C");
                            tipoFactura = scanner.nextInt();

                        } catch (InputMismatchException e) {
                            System.out.println("el dato no es el indicado");
                            scanner.nextLine();
                        } catch (Exception e) {
                            System.out.println("Problema detectado");
                            scanner.nextLine();
                        }
                    } while (tipoFactura == 0);


                    if (tipoFactura == 1) {                                                      //le paso el tipo a la factura
                        nuevaFactura.setTipoFactura(TipoFactura.FACTURA_A);
                    } else if (tipoFactura == 2) {
                        nuevaFactura.setTipoFactura(TipoFactura.FACTURA_B);
                    } else {
                        nuevaFactura.setTipoFactura(TipoFactura.FACTURA_C);
                    }
                    System.out.println(nuevaFactura);                                      //muestro la factura
                    facturasEmitidas.add(nuevaFactura.toString());                 //la guardo como string en el listado de facturas del hotel
                    //elimino la ocupación de la lista

                    if (!this.listaReservas.isEmpty()) {
                        int j = 0;
                        boolean reservaEncontrada = false;

                        while (!reservaEncontrada && j < this.listaReservas.size()) {

                            if (this.listaReservas.get(j).getNumeroReserva() == this.listaOcupaciones.get(i).getIdReserva()) { //busco reserva por id
                                for(Pasajero pax : this.listaOcupaciones.get(i).getListaPaxs()){
                                    pax.getOcupacionesAnteriores().add(this.listaReservas.get(j));
                                }


                                this.listaReservas.remove(this.listaReservas.get(j));       //elimino la reserva de la lista general de reservas
                                reservaEncontrada = true;

                            }

                            j++;
                        }
                    }

                    Habitacion hab = buscarHabPorNro(nroHabitacion);
                    hab.setEstado(EstadoHabitacion.DISPONIBLE);
                    this.listaOcupaciones.remove(this.listaOcupaciones.get(i));
                    ocupacionEncontrada = true;
                }
                i++;
            }
        } else {
            System.out.println("El hotel no tiene habitaciones ocupadas");
        }
        if (!ocupacionEncontrada) {
            System.out.println("No se encontró la ocupación con el número de habitación ingresado");
        }
    }

    //MUESTRA EL LISTADO DE INGRESOS DEL DIA DE HOY
    public void listadoIngresosDelDia() {
        if (!this.listaReservas.isEmpty()) { //busca en la lista de reservas
            System.out.println("\nIngresos del día\n");
            for (Reserva lista : listaReservas) {
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
            System.out.println("\nEgresos del día\n");
            for (Ocupacion lista : listaOcupaciones) { //busca en la lista de ocupaciones

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
            System.out.println("\nIngresos del día: " + dia + "\n");
            for (Reserva lista : listaReservas) { //busca en la lista de reservas

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
            System.out.println("\nEgresos del día: " + dia + "\n");
            for (Reserva lista : listaReservas) { //busca en la lista de reservas

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
                System.out.println("\n");
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

    public LocalDate fechaProximaOcupacion(int nroHabitacion) {
        LocalDate proxima = null;
        List<Reserva> reservasHab = new ArrayList<>();
        if (!this.listaReservas.isEmpty()) {
            for (Reserva lista : this.listaReservas) {
                if (lista.getNumeroHabitacion() == nroHabitacion) {
                    reservasHab.add(lista);
                }
            }
            Collections.sort(reservasHab);
            Habitacion habitacion = buscarHabPorNro(nroHabitacion);
            if (habitacion.getEstado().compareTo(EstadoHabitacion.OCUPADA) == 0) {
                proxima = reservasHab.get(1).getFechaIngreso();
            } else if (habitacion.getEstado().compareTo(EstadoHabitacion.DISPONIBLE) == 0) { //si está disponible
                proxima = reservasHab.get(0).getFechaIngreso();  //se indica la primer reserva, si no hay queda en null
            }


        }
        return proxima;
    }


    public void extenderFechaSalida(int nroHabitacion, int nochesExtra) {
        LocalDate fecha = fechaProximaOcupacion(nroHabitacion);
        boolean posible = false;
        long diasExtendibles = 0;
        if (fecha == null) {  //si la habitación no tiene reservas próximas
            diasExtendibles = 300;  //se pone un monto grande, factible de ser mayor que las noches extras
            posible = true;
        } else {
            for (Ocupacion ocupacion : this.listaOcupaciones) {  ///si tiene próximas reservas
                if (ocupacion.getNroHabitacion() == nroHabitacion) {
                    diasExtendibles = ChronoUnit.DAYS.between(ocupacion.getFechaSalida(), fecha); //calculo la diferencia entre la fecha de salida actual
                    posible = true;                                                               //y la fecha de ingreso de la proxima reserva
                }
            }
        }
        if (posible) {  //si es posible ingreso
            if (fecha == null || diasExtendibles >= nochesExtra) {  //si se da alguna de las dos alternativas posteriores
                for (Ocupacion listaOcup : this.listaOcupaciones) {
                    if (listaOcup.getNroHabitacion() == nroHabitacion) {
                        listaOcup.setFechaSalida(listaOcup.getFechaSalida().plusDays(nochesExtra)); //extiendo la fecha de salida
                        for (Reserva listaRva : this.listaReservas) {
                            if (listaRva.getNumeroReserva() == listaOcup.getIdReserva()) {
                                listaRva.setFechaSalida(listaRva.getFechaSalida().plusDays(nochesExtra));
                                System.out.println("Fecha de salida extendida");
                                System.out.println(listaOcup);
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


    /// Nueva ocupacion con reserva previa (si el pasajero no tiene, se genera una en el momento del ingreso


    public void nuevaOcupacion(Reserva reserva) {
        Scanner scanner = new Scanner(System.in);
        Ocupacion ocupacion = new Ocupacion();
        int cochera = -1;

        ocupacion.setIdReserva(reserva.getNumeroReserva());  //se toman estos datos de la reserva
        ocupacion.setFechaIngreso(reserva.getFechaIngreso());
        ocupacion.setFechaSalida(reserva.getFechaSalida());

        do {
            try {
                System.out.println("Cantidad cocheras: ");  //se agrega cantidad de cocheras si el pasajero quiere una o más
                cochera = scanner.nextInt();
                ocupacion.setCochera(cochera);
            } catch (InputMismatchException e) {
                System.out.println("Dato incorrecto");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Problema detectado");
            }

        } while (cochera == -1);

        boolean encontrada = false;
        int i = 0;
        while (!encontrada && i < this.listaHabitaciones.size()) {
            if (this.listaHabitaciones.get(i).getNumero().equals(reserva.getNumeroHabitacion())) {
                ocupacion.setNroHabitacion(listaHabitaciones.get(i).getNumero());  //se le agrega la hab a la ocupación
                this.listaHabitaciones.get(i).setEstado(EstadoHabitacion.OCUPADA); //cambio el estado de la hab
                ocupacion.setTarifa(listaHabitaciones.get(i).getTarifa());
                encontrada=true;
            }
            i++;
        }
        System.out.println("Tipo de pensión");
        ocupacion.asignarTipoPension(); //tipo de pensión (desayuno, media pensión o pensión completa)
        ocupacion.agregarPasajerosLista(reserva, this.pasajeros); //agrego pasajero titular
        ocupacion.agregarPasajerosLista(this.pasajeros);         //agrego acompañantes
        ocupacion.setDeposito(reserva.getDeposito());  //monto del depósito
        ocupacion.setCantidadPax(ocupacion.getListaPaxs().size());  //cantidad de pasajeros
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

    public void llamadaNuevaHabitacion() {
        Habitacion habitacion = new Habitacion();
        habitacion.nuevaHabitacion(habitacion);
        this.listaHabitaciones.add(habitacion);
    }

    public void llamadaModificarHabitacion(int nroHabitacion, Empleado empleado) {
        boolean encontrada = false;
        if (!this.listaHabitaciones.isEmpty()) {
            for (Habitacion lista : this.listaHabitaciones) {
                if (lista.getNumero() == nroHabitacion) {
                    if (empleado instanceof Recepcionista) {
                        ((Recepcionista) empleado).modificarHabitacion(lista);
                    } else {
                        ((Administrador) empleado).modificarHabitacion(lista);
                    }
                    encontrada = true;
                }
            }
            if (!encontrada) {
                System.out.println("No se encontraron coincidencia con el número de habotación indicada");
            }
        } else {
            System.out.println("No hay habitaciones cargadas");
        }
    }

    //MUESTRA EL LISTADO DE RESERVAS X HABITACION

    public void listadoReservasPorHabitacion(int numeroHab) {
        if (!this.listaReservas.isEmpty()) {
            System.out.println("\nReservas de Habitacion numero " + numeroHab + "\n");
            for (Reserva reserva : listaReservas) { //busca en la lista de reservas
                if (reserva.getNumeroHabitacion() == numeroHab) { //coincidencias en num de hab
                    System.out.println(reserva);
                    System.out.println("\n");
                }
            }
        } else {
            System.out.println("La habitacion numero " + numeroHab + " no tiene reservas");
        }
    }


    //FUNCION MODIFICAR DATOS RESERVA
    public void menuModificarReserva() {
        System.out.println("1- Nombre");
        System.out.println("2- Apellido");
        System.out.println("3- Dni");
        System.out.println("4- Numero de telefono");
        System.out.println("5- Numero de pasajeros");
        System.out.println("6- Fecha de Ingreso/Salida");
        System.out.println("7- Numero de habitacion");
        System.out.println("8- Deposito");
    }

    //////////////////////// METODO MODIFICAR RESERVA TIENE ERROR AL LEER STRINGS
    public void modificarReserva() {
        Scanner scanner = new Scanner(System.in);
        int idReserva= 0;
        Reserva reserva = null;
       do{
           try{
               System.out.println("Indique el número de reserva que desea modificar");
               idReserva = scanner.nextInt();
               scanner.nextLine();
           }catch(InputMismatchException e){
               System.out.println("Debe ingresar un numero");
               scanner.nextLine();
           }catch(Exception e){
               System.out.println("Problema detectado" );
               scanner.nextLine();
           }
       }while (idReserva ==0);

        if (!listaReservas.isEmpty()) {
            for (Reserva lista : this.listaReservas) {
                if (lista.getNumeroReserva() == idReserva) {
                    reserva = lista;
                }
            }
        }
        if (reserva != null) {
            String continuar = "s";
            do {
                int opcion = 0;
                System.out.println(reserva);
                System.out.println("Indique qué dato desea modificar:");
                menuModificarReserva();
                opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    case 1:
                        String nombre = "";
                        do {
                            try {
                                System.out.println("Indique el nombre:");
                                nombre = scanner.nextLine();
                                examinaDatosCompletos(nombre);
                                reserva.setPasajeroNombre(nombre);
                            } catch (ExcepcionDatoVacio e) {
                                System.out.println("Este dato debe ser cargado");

                            } catch (Exception e) {

                                System.out.println("No se ha podido registrar");

                            }
                        } while (nombre.compareTo("") == 0);


                        break;
                    case 2:
                        String apellido = "";
                        do {
                            try {
                                System.out.println("Indique el apellido:");
                                apellido = scanner.nextLine();
                                examinaDatosCompletos(apellido);
                                reserva.setPasajeroApellido(apellido);
                            } catch (ExcepcionDatoVacio e) {
                                System.out.println("Este dato debe ser cargado");

                            } catch (Exception e) {

                                System.out.println("No se ha podido registrar");

                            }
                        } while (apellido.compareTo("") == 0);


                        break;
                    case 3:
                        String dni = "";
                        do {
                            try {
                                System.out.println("Indique el dni:");
                                dni = scanner.nextLine();
                                examinaDatosCompletos(dni);
                                reserva.setPasajeroDni(dni);
                            } catch (ExcepcionDatoVacio e) {
                                System.out.println("Este dato debe ser cargado");

                            } catch (Exception e) {

                                System.out.println("No se ha podido registrar");

                            }
                        } while (dni.compareTo("") == 0);

                        break;
                    case 4:
                        String tel = "";
                        do {
                            try {
                                System.out.println("Indique el telefono:");
                                tel = scanner.nextLine();
                                examinaDatosCompletos(tel);
                                reserva.setPasajeroNombre(tel);
                            } catch (ExcepcionDatoVacio e) {
                                System.out.println("Este dato debe ser cargado");

                            } catch (Exception e) {

                                System.out.println("No se ha podido registrar");

                            }
                        } while (tel.compareTo("") == 0);

                        break;
                    case 5:
                        int numero = 0;
                        do {
                            try {
                                System.out.println("Numero de pasajeros:");
                                numero = scanner.nextInt();
                                reserva.setNumeroPasajeros(numero);
                            } catch (InputMismatchException e) {
                                System.out.println("No se ha podido registrar este dato");
                            } catch (Exception e) {
                                System.out.println("No se ha podido registrar este dato");
                            }
                        } while (numero == 0);

                        break;
                    case 6:
                        LocalDate ingreso;
                        LocalDate salida;
                        do {
                            try {
                                System.out.println("Ingrese la nueva fecha de ingreso (AAAA-MM-DD)");
                                ingreso = LocalDate.parse(scanner.nextLine());
                                if(ingreso.isBefore(LocalDate.now())){
                                    System.out.println("La fecha debe ser posterior al día de hoy");
                                    ingreso=null;
                                }
                            } catch (DateTimeParseException e) {
                                System.out.println("\nIngrese la fecha nuevamente en el formato indicado");
                                ingreso = null;
                            } catch (Exception e) {
                                System.out.println("\nIngrese la fecha nuevamente");
                                ingreso = null;
                            }
                        } while (ingreso == null);

                        do {
                            try {
                                System.out.println("Ingrese la nueva fecha de salida (AAAA-MM-DD)");
                                salida = LocalDate.parse(scanner.nextLine());
                                if (salida.isBefore(ingreso)) {
                                    System.out.println("\nLa fecha de salida no puede ser anterior al inreso");
                                    salida = null;
                                }
                            } catch (DateTimeParseException e) {
                                System.out.println("\nIngrese la fecha nuevamente en el formato indicado");
                                salida = null;
                            } catch (Exception e) {
                                System.out.println("\nIngrese la fecha nuevamente");
                                salida = null;
                            }
                        } while (salida == null);

                        if (habitacionLibre(ingreso, salida, reserva.getNumeroHabitacion(), reserva.getNumeroReserva())) {
                            reserva.setFechaIngreso(ingreso);
                            reserva.setFechaSalida(salida);
                        } else {
                            System.out.println("La habitación no está disponible en las fechas indicadas");
                        }
                        break;
                    case 7:
                        System.out.println("Habitaciones disponibles para las fechas de la reserva:");
                        List<Integer> listaHabLibres = habitacionesLibres(reserva.getFechaIngreso(), reserva.getFechaSalida());
                        if (listaHabLibres.isEmpty()) {
                            System.out.println("No hay habitaciones disponibles en las fechas indicadas");
                        } else {
                            System.out.println("Indique el número de la nueva habitacion que desea para esta reserva:");
                            int numeroHab = scanner.nextInt();
                            for (Integer lista : listaHabLibres) {
                                if (numeroHab == lista) {
                                    reserva.setNumeroHabitacion(numeroHab);
                                }
                            }
                        }
                        break;
                    case 8:
                        Double deposito = 0D;
                        do {
                            try {
                                System.out.println("Depósito:");
                                deposito = scanner.nextDouble();
                                reserva.setDeposito(deposito);
                            } catch (InputMismatchException e) {
                                System.out.println("dato incorrecto");
                                scanner.nextLine();
                            } catch (Exception e) {
                                System.out.println("Problema detectado");
                                scanner.nextLine();
                            }
                        } while (deposito == 0);

                        break;
                    default:
                        System.out.println("Opcion incorrecta, ingrese nuevamente");
                        break;
                }

                System.out.println(reserva);
                System.out.println("Desea modificar otro dato? ");
                continuar = scanner.nextLine();

            } while (continuar.equalsIgnoreCase("s"));
        }

    }

    //ELIMINAR RESERVA

    public void eliminarReserva(Long id) {
        boolean encontrada = false;
        if (!listaReservas.isEmpty()) {
            int i = 0;
            while (!encontrada && i < listaReservas.size()) {
                if (listaReservas.get(i).getNumeroReserva() == id) {
                    listaReservas.remove(listaReservas.get(i));
                    System.out.println("Reserva eliminada");
                    encontrada = true;
                }
                i++;
            }
            if (!encontrada) {
                System.out.println("No se encontró reserva con el ID " + id);
            }
        } else {
            System.out.println("El hotel no posee reservas");
        }
    }

    //ELIMINAR EMPLEADO

    public void eliminarEmpleado(String dni) {
        boolean encontrado = false;
        if (!this.empleados.isEmpty()) {
            int i = 0;
            while (!encontrado && i < empleados.size()) {
                if (empleados.get(i).getDni().compareTo(dni) == 0) {
                    empleados.remove(empleados.get(i));
                    System.out.println("Empleado eliminado");
                    encontrado = true;
                }
                i++;
            }
            if (!encontrado) {
                System.out.println("No se encontró empleado con el DNI " + dni);
            }
        } else {
            System.out.println("El hotel no posee empleados cargados");
        }
    }

    public boolean verificarReservasHabitacion(int numero) {
        boolean tieneReservas = false;
        if (!this.listaReservas.isEmpty()) {
            int i = 0;
            while (!tieneReservas && i < this.listaReservas.size()) {
                if (listaReservas.get(i).getNumeroHabitacion() == numero) {
                    tieneReservas = true;
                }
                i++;
            }

        }
        return tieneReservas;
    }

    //ELIMINAR HABITACION
    public void eliminarHabitacion(int numero) {
        boolean encontrada = false;
        if (!verificarReservasHabitacion(numero)) {  //verifico si la habitación tiene reservas, si tiene, no permite eliminar
            if (!this.listaHabitaciones.isEmpty()) {
                int i = 0;
                while (!encontrada && i < listaHabitaciones.size()) {
                    if (listaHabitaciones.get(i).getNumero() == numero) {
                        listaHabitaciones.remove(listaHabitaciones.get(i));
                        System.out.println("Habitación eliminada");
                        encontrada = true;
                    }
                    i++;
                }
                if (!encontrada) {
                    System.out.println("No se encontró la habitación indicada");
                }
            } else {
                System.out.println("El hotel no posee habitaciones cargadas");
            }
        } else {
            System.out.println("La habitación indicada tiene reservas asignadas, no se puede eliminar.");
            System.out.println("\nReasigne las reservas e intente nuevamente");
        }
    }


    public void nuevoEmpleado() {
        Scanner scanner = new Scanner(System.in);
        String nombre = "";
        String apellido = "";
        String telefono = "";
        String dni = "";

        int opcion;
        do {
            try {
                System.out.println("Ingrese el nombre:");
                nombre = scanner.nextLine();
                examinaDatosCompletos(nombre);

            } catch (ExcepcionDatoVacio e) {

                System.out.println("Debe completar el dato");

            } catch (Exception e) {

            }
        } while (nombre.compareTo("") == 0);
        do {
            try {
                System.out.println("Ingrese el apellido:");
                apellido = scanner.nextLine();
                examinaDatosCompletos(apellido);
            } catch (ExcepcionDatoVacio e) {
                System.out.println("Debe completar el dato");

            } catch (Exception e) {

            }
        } while (apellido.compareTo("") == 0);

        do {
            try {
                System.out.println("Ingrese el dni:");
                dni = scanner.nextLine();
                examinaDatosCompletos(dni);
            } catch (ExcepcionDatoVacio e) {
                System.out.println("Debe completar el dato");

            } catch (Exception e) {

            }
        } while (dni.compareTo("") == 0);

        do {
            try {
                System.out.println("Ingrese el teléfono:");
                telefono = scanner.nextLine();
                examinaDatosCompletos(telefono);
            } catch (ExcepcionDatoVacio e) {
                System.out.println("Debe completar el dato");

            } catch (Exception e) {

            }
        } while (telefono.compareTo("") == 0);

        do {
            System.out.println("Indique:\n1- Recepcionista\n2- Administrador");
            opcion = scanner.nextInt();
        } while (opcion != 1 && opcion != 2);

        System.out.println("Nuevo empleado: \n");
        if (opcion == 1) {
            Recepcionista recepcionista = new Recepcionista(nombre, apellido, telefono, dni);
            this.empleados.add(recepcionista);
            System.out.println(recepcionista);
        } else {
            Administrador administrador = new Administrador(nombre, apellido, telefono, dni);
            this.empleados.add(administrador);
            System.out.println(administrador);
        }
    }

    public void listaEmpleados(){
        if(!this.empleados.isEmpty()){
            for(Empleado e : this.empleados){
                System.out.println(e);
                System.out.println("\n");
            }
        }
    }

    public void llamadaModificarEmpleado(Empleado empleado) {
        Scanner scanner = new Scanner(System.in);
        String dni = "";
        boolean encontrado = false;
        do {
            try {
                System.out.println("Ingrese el DNI del empleado que desea modificar");
                dni = scanner.nextLine();
                examinaDatosCompletos(dni);
            } catch (ExcepcionDatoVacio e) {
                System.out.println("no indico ningun dato");
            } catch (Exception e) {
                System.out.println("Problema detectado");
            }
        } while (dni.compareTo("") == 0);

        if (!this.empleados.isEmpty()) {
            for (Empleado lista : this.empleados) {
                if (lista.getDni().compareTo(dni) == 0) {
                    modificarEmpleado(lista);
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println("No se encontró empleado con el DNI " + dni);
            }
        }

    }

    public Empleado verificarUsuarioyContrasenia(String usuario, String clave) {
        Empleado empleado = null;
        boolean aceptado = false;
        if (!this.empleados.isEmpty()) {
            for (Empleado lista : this.empleados) {
                if (lista.getUsuario().compareTo(usuario) == 0) {
                    if (lista.getClave().compareTo(clave) == 0) {
                        empleado = lista;
                        aceptado = true;
                    }
                }
            }
            if (!aceptado) {
                System.out.println("Usuario o contraseña incorrecta. Intente nuevamente");
            }
        }
        return empleado;
    }

    public void menuModificarEmpleado() {
        System.out.println("1- Nombre");
        System.out.println("2- Apellido");
        System.out.println("3- Dni");
        System.out.println("4- Telefono");
    }

    public void modificarEmpleado(Empleado empleado) {
        Scanner scanner = new Scanner(System.in);
        String continuar = "s";

        int opcion = 0;
        do {
            System.out.println(" ");
            System.out.println(empleado);
           do{
               try{
                   System.out.println("Indique el dato que desea modificar");
                   menuModificarEmpleado();
                   opcion = scanner.nextInt();
                   scanner.nextLine();
               }catch (InputMismatchException e){
                   System.out.println("Debe ingresar un numero");
                   scanner.nextLine();
               }catch(Exception e){
                   System.out.println("Problema detectado");
                   scanner.nextLine();
               }
           }while (opcion== 0);

            scanner.nextLine();
            switch (opcion) {
                case 1:
                    String nombre = "";
                    do {
                        try {
                            System.out.println("Ingrese el nombre:");
                            nombre = scanner.nextLine();
                            examinaDatosCompletos(nombre);
                            empleado.setNombre(nombre);

                        } catch (ExcepcionDatoVacio e) {
                            System.out.println("Debe completar el dato");

                        } catch (Exception e) {
                            System.out.println("Problema detectado");
                        }
                    } while (nombre.compareTo("") == 0);
                    break;

                case 2:
                    String apellido = "";
                    do {
                        try {
                            System.out.println("Ingrese el apellido:");
                            apellido = scanner.nextLine();
                            examinaDatosCompletos(apellido);
                            empleado.setApellido(apellido);

                        } catch (ExcepcionDatoVacio e) {

                            System.out.println("Debe completar el dato");

                        } catch (Exception e) {

                        }
                    } while (apellido.compareTo("") == 0);

                    break;
                case 3:
                    String dni = "";
                    do {
                        try {
                            System.out.println("Ingrese el dni:");
                            dni = scanner.nextLine();
                            examinaDatosCompletos(dni);
                            empleado.setDni(dni);

                        } catch (ExcepcionDatoVacio e) {

                            System.out.println("Debe completar el dato");

                        } catch (Exception e) {

                        }
                    } while (dni.compareTo("") == 0);

                    break;
                case 4:
                    String telefono = "";
                    do {
                        try {
                            System.out.println("Ingrese numero de telefono:");
                            telefono = scanner.nextLine();
                            examinaDatosCompletos(telefono);
                            empleado.setNumeroTel(telefono);

                        } catch (ExcepcionDatoVacio e) {

                            System.out.println("Debe completar el dato");

                        } catch (Exception e) {

                        }
                    } while (telefono.compareTo("") == 0);

                    break;
                default:
                    System.out.println("Opcion incorrecta, ingrese nuevamente");
                    break;
            }
            System.out.println(" ");
            System.out.println(empleado);
            scanner.nextLine();
            System.out.println("Desea modificar otro dato?");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));
    }

    public void cargarReserva(Reserva reserva, int numeroHabitacion, LocalDate ingreso, LocalDate salida) {
        Scanner scanner = new Scanner(System.in);
        String nombre = "";
        String apellido = "";
        String dni = "";
        String tel = "";
        int numero = 0;
        int pasajeros = 0;
        Double deposito = 0D;
        reserva.setNumeroHabitacion(numeroHabitacion);
        reserva.setFechaIngreso(ingreso);
        reserva.setFechaSalida(salida);

        do {
            try {
                System.out.println("Indique el nombre del pasajero:");
                nombre = scanner.nextLine();
                examinaDatosCompletos(nombre);
                reserva.setPasajeroNombre(nombre);
            } catch (ExcepcionDatoVacio e) {
                System.out.println("Este dato debe ser cargado");

            } catch (Exception e) {

                System.out.println("No se ha podido registrar");

            }
        } while (nombre.compareTo("") == 0);

        do {
            try {
                System.out.println("Indique el apellido del pasajero:");
                apellido = scanner.nextLine();
                examinaDatosCompletos(apellido);
                reserva.setPasajeroApellido(apellido);
            } catch (ExcepcionDatoVacio e) {
                System.out.println("Este dato debe ser cargado");

            } catch (Exception e) {

                System.out.println("No se ha podido registrar");

            }
        } while (apellido.compareTo("") == 0);


        do {
            try {
                System.out.println("Ingrese el dni del pasajero:");
                dni = scanner.nextLine();
                examinaDatosCompletos(dni);
                reserva.setPasajeroDni(dni);
            } catch (ExcepcionDatoVacio e) {
                System.out.println("Este dato debe ser cargado");

            } catch (Exception e) {

                System.out.println("No se ha podido registrar");

            }
        } while (dni.compareTo("") == 0);


        do {
            try {
                System.out.println("Ingrese el telefono del pasajero:");
                tel = scanner.nextLine();
                examinaDatosCompletos(tel);
                reserva.setTelefono(tel);
            } catch (ExcepcionDatoVacio e) {
                System.out.println("Este dato debe ser cargado");

            } catch (Exception e) {

                System.out.println("No se ha podido registrar");

            }
        } while (tel.compareTo("") == 0);


        do {
            try {
                System.out.println("Ingrese la cantidad de pasajeros:");
                pasajeros = scanner.nextInt();
                reserva.setNumeroPasajeros(pasajeros);
            } catch (InputMismatchException e) {
                System.out.println("dato incorrecto");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Problema detectado");
                scanner.nextLine();
            }
        } while (pasajeros == 0);

        do {
            try {
                System.out.println("Ingrese el monto de Depósito:");
                deposito = scanner.nextDouble();
                reserva.setDeposito(deposito);
            } catch (InputMismatchException e) {
                System.out.println("dato incorrecto");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Problema detectado");
                scanner.nextLine();
            }
        } while (deposito == 0);

    }


    public void llamadaModificarPasajero(String dni){
        if(!this.pasajeros.isEmpty()){
            for(Pasajero pax : this.pasajeros){
                if(pax.getDni().compareTo(dni)==0){
                    pax.modificarPasajero(pax);
                }
            }
        }

    }
    public void tarifas(){
        for (Tarifa t : Tarifa.values()){
            System.out.println("Tarifa: " + t.getNombre() + "\nDescripción: " + t.getDescripcion() + "\nPrecio: " + t.getPrecio() + "\n");
        }
    }

    public void pensiones(){
        for (TipoPension t : TipoPension.values()){
            System.out.println("Pensión: " + t.getNombre() + "\nPrecio: " + t.getPrecio() + "\n");
        }
    }

    public void buscarOcupacionPasajeroAlojadoPorDNI(String dni){
        boolean encontrado = false;
        if(!this.listaOcupaciones.isEmpty()){
            for(Ocupacion ocup : this.listaOcupaciones){
                for(Pasajero pax : ocup.getListaPaxs()){
                    if(pax.getDni().compareTo(dni)==0){
                        System.out.println(ocup);
                        encontrado=true;
                    }
                }
            }
            if(!encontrado){
                System.out.println("No se encontró pasajero con el DNI indicado");
            }
        }else{
            System.out.println("No hay habitaciones ocupadas en este momento");
        }
    }

    public void buscarOcupacionPasajeroAlojadoPorNombreYApellido(String nombre, String apellido){
        boolean encontrado = false;
        if(!this.listaOcupaciones.isEmpty()){
            for(Ocupacion ocup : this.listaOcupaciones){
                for(Pasajero pax : ocup.getListaPaxs()){
                    if((pax.getNombre().compareTo(nombre)==0) && (pax.getApellido().compareTo(apellido)==0)){
                        System.out.println(ocup);
                        encontrado=true;
                    }
                }
            }
            if(!encontrado){
                System.out.println("No se encontró pasajero con el nombre y apellido indicado");
            }
        }else{
            System.out.println("No hay habitaciones ocupadas en este momento");
        }
    }

    public void cantidadPorTipoDePension(){
        int contadorDesayuno=0;
        int contadorMediaPension=0;
        int contadorPensionCompleta=0;
        if(!this.listaOcupaciones.isEmpty()){
            for (Ocupacion ocup : this.listaOcupaciones){
                if(ocup.getTipoPension().compareTo(TipoPension.DESAYUNO)==0){
                    contadorDesayuno++;
                }else if(ocup.getTipoPension().compareTo(TipoPension.MEDIA_PENSION)==0){
                    contadorMediaPension++;
                }else {
                    contadorPensionCompleta++;
                }
            }
            System.out.println("Cantidad de pensiones actuales:");
            System.out.println("Desayuno: " + contadorDesayuno + "\nMedia pensión: "
                    + contadorMediaPension + "\nPensión completa: " + contadorPensionCompleta);
        }System.out.println("No hay habitaciones ocupadas en este momento");
    }

    public void verHistoricoPasajeroListaGeneral(String dni){
        boolean encontrado = false;
        if(!this.pasajeros.isEmpty()){
            for(Pasajero pax : this.pasajeros){
                if(pax.getDni().compareTo(dni)==0){
                    for(Reserva rva : pax.getOcupacionesAnteriores()){
                        System.out.println("\nHabitación: " + rva.getNumeroHabitacion() +
                                "\nFecha de ingreso: " + rva.getFechaIngreso() +
                                "\nFecha de salida: " + rva.getFechaSalida());
                    }
                    encontrado=true;
                }

            }
            if(!encontrado){
                System.out.println("No se encontró pasajero con el DNI indicado");
            }
        }else{
            System.out.println("No hay habitaciones ocupadas en este momento");
        }
    }

}