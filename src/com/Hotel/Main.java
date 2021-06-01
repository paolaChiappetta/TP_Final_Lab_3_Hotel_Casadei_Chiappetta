package com.Hotel;

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

        List<Reserva>reservas = new ArrayList<>();
        Habitacion habitacion = new Habitacion(2025, 2, EstadoHabitacion.DISPONIBLE,
                Tarifa.DOBLE_STANDAR, LocalDate.parse("2021-05-31"), reservas);

        Ocupacion ocup = new Ocupacion(3, LocalDate.parse("2021-05-01"),
                LocalDate.parse("2021-05-05"), extras, 1, habitacion, 1,
                TipoPension.MEDIA_PENSION, listaPax);


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

       /shop.verListaPorTipo();

        Factura factura = new Factura(TipoFactura.FACTURA_A, ocup);
        System.out.println(factura);
    }
}
