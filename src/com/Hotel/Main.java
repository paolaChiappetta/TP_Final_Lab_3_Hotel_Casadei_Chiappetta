package com.Hotel;

import com.google.gson.Gson;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Pasajero pax = new Pasajero("Paola", "Chiappetta", "15536583","35418021",
                LocalDate.parse("1990-08-10"), "Estudiante",
                "Argentina", "Gascon", 2330, 3,
                "C", "Mar del Plata", "Bs As", "Argentina",
                "paola@gmail.com", true);

        List<Pasajero> listaPax=new ArrayList<>();
        listaPax.add(pax);

        List<Extra>extras = new ArrayList<>();

        List<Habitacion>habitaciones = new ArrayList<>();

        List<Reserva>reservas = new ArrayList<>();



        Reserva reserva = new Reserva("Paola", "Chiappetta", "35425589", 101, 2, 250.00, LocalDate.parse("2021-06-01"), LocalDate.parse("2021-06-03"), "55");
        reservas.add(reserva);
        Reserva reserva2 = new Reserva("Paola", "Chiappetta", "35425589", 102, 2, 250.00, LocalDate.parse("2021-06-25"), LocalDate.parse("2021-06-28"), "");
        reservas.add(reserva2);
        Reserva reserva3 = new Reserva("Paola", "Chiappetta", "35425589", 102, 2, 250.00, LocalDate.parse("2021-07-01"), LocalDate.parse("2021-07-04"), "");
        reservas.add(reserva3);


        Habitacion habitacion1 = new Habitacion(101, 1, EstadoHabitacion.FUERA_DE_SERVICIO,
                Tarifa.DOBLE_STANDAR, LocalDate.parse("2021-05-31"));
        Habitacion habitacion2 = new Habitacion(102, 1, EstadoHabitacion.DISPONIBLE,
                Tarifa.DOBLE_STANDAR, LocalDate.parse("2021-05-31"));


        habitaciones.add(habitacion1);
        habitaciones.add(habitacion2);


        Ocupacion ocup = new Ocupacion(3, LocalDate.parse("2021-05-01"),
                LocalDate.parse("2021-05-05"), extras, 1, 102, Tarifa.DOBLE_STANDAR, 1,
                TipoPension.MEDIA_PENSION, listaPax, 200.00);

        List<Ocupacion>ocupaciones = new ArrayList<>();
        ocupaciones.add(ocup);


        Servicio servicio = new Servicio("Plancha", 400.00, "Mucama");
        Servicio servicio2 = new Servicio("Bata", 200.00, "Mucama");
        Servicio servicio3 = new Servicio("Toalla", 150.00, "Mucama");

        Rotura rotura = new Rotura("Vidrio", 300.00, " ");
        Rotura rotura2 = new Rotura("Espejo", 300.00, " ");
        Rotura rotura3 = new Rotura("Toalla", 300.00, " ");

        Amenitie amenitie = new Amenitie("Masaje", 1500.00, "con piedras calientes", "de 10 a 18");
        Amenitie amenitie2 = new Amenitie("Sauna 1", 800.00, "seco", "de 10 a 18");
        Amenitie amenitie3 = new Amenitie("Sauna 2", 800.00, "húmedo", "de 10 a 18");

        ProductoMinibar prod = new ProductoMinibar("Gaseosa", 110.00, "Coca Cola");
        ProductoMinibar prod2 = new ProductoMinibar("Gaseosa", 120.00, "Fanta");
        ProductoMinibar prod3 = new ProductoMinibar("Gaseosa", 115.00, "Sprite");

        List<Servicio>servicios = new ArrayList<>();
        List<Rotura>roturas = new ArrayList<>();
        List<Amenitie>amenities = new ArrayList<>();
        List<ProductoMinibar>productos = new ArrayList<>();

        servicios.add(servicio);
        servicios.add(servicio2);
        servicios.add(servicio3);

        roturas.add(rotura);
        roturas.add(rotura2);
        roturas.add(rotura3);

        amenities.add(amenitie);
        amenities.add(amenitie2);
        amenities.add(amenitie3);

        productos.add(prod);
        productos.add(prod2);
        productos.add(prod3);

        extras.add(servicio);
        extras.add(amenitie);
        extras.add(servicio);
        extras.add(prod);

       Shop shop = new Shop(roturas,servicios,amenities,productos);



        Archivo archivo = new Archivo();
        List<Reserva>reservas22;

        archivo.writerArchivoReserva("reservas.json", reservas);
        reservas22= archivo.readerArchivoReserva("reservas.json");

        for(Reserva r : reservas22){
            System.out.println(r);
        }

        Recepcionista recepcionista1 = new Recepcionista("Carla", "Perez", "555444", "444");
        Recepcionista recepcionista2 = new Recepcionista("Maria", "Garcia", "552822244", " ");
        Recepcionista recepcionista3 = new Recepcionista("Facundo", "Gonzalez", "552552111", " ");
        List<Recepcionista>recepcionistas = new ArrayList<>();
        recepcionistas.add(recepcionista1);
        recepcionistas.add(recepcionista2);
        recepcionistas.add(recepcionista3);
        List<Recepcionista>recepcionistas2 = new ArrayList<>();

        List<Empleado>empleados = new ArrayList<>();
        empleados.add(recepcionista1);
        empleados.add(recepcionista2);
        empleados.add(recepcionista3);

        Archivo archivo2 = new Archivo();

        archivo2.writerArchivoRecepcionista("recepcionista.json", recepcionistas);
        recepcionistas2= archivo2.readerArchivoRecepcionista("recepcionista.json");

        for(Recepcionista r : recepcionistas){
            System.out.println(r);
        }

        List<String>facturas=new ArrayList<>();
        String factura1= "pp";
        facturas.add(factura1);


        Administrador adm1 = new Administrador("Carla", "Perez", "555444", "444");
        Administrador adm2 = new Administrador("Maria", "Garcia", "552822244", " ");
        Administrador adm3 = new Administrador("Facundo", "Gonzalez", "552552111", " ");


        empleados.add(adm1);
        empleados.add(adm2);
        empleados.add(adm3);
        List<Empleado>empleados2 = new ArrayList<>();

        Archivo archivo3 = new Archivo();
        archivo3.writerArchivoEmpleado("empleado.json", empleados);
        empleados2=archivo3.readerArchivoEmpleado("empleado.json");
        System.out.println("\nEmpleados");

        for(Empleado r : empleados2){
                System.out.println(r);
        }


        List<Habitacion>habitaciones2 = new ArrayList<>();

        Archivo archivo4 = new Archivo();
        archivo3.writerArchivoHabitaciones("habitacion.json", habitaciones);
        habitaciones2=archivo3.readerArchivoHabitaciones("habitacion.json");
        System.out.println("\nHabs");

        for(Habitacion r : habitaciones2){
            System.out.println(r);
        }
/*
        List<Ocupacion>ocupaciones2 = new ArrayList<>();

        Archivo archivo4 = new Archivo();
        archivo3.writerArchivoOcupaciones("ocupacion.json", ocupaciones);
        ocupaciones2=archivo3.readerArchivoOcupaciones("ocupacion.json");
        System.out.println("\nHabs");

        for(Ocupacion r : ocupaciones2){
            System.out.println(r);
        }

        */

    }







}
