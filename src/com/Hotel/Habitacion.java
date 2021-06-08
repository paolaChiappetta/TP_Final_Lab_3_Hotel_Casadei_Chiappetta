package com.Hotel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONException;
import org.json.simple.JSONObject;



public class Habitacion implements Serializable {

    private Integer numero;
    private Integer piso;
    private EstadoHabitacion estado;
    private Tarifa tarifa;
    private LocalDate fechaProximaOcupacion;


    public Habitacion() {
    }

    public Habitacion(Integer numero, Integer piso,
                      EstadoHabitacion estado, Tarifa tarifa,
                      LocalDate fechaProximaOcupacion) {
        this.numero = numero;
        this.piso = piso;
        this.estado = estado;
        this.tarifa = tarifa;
        this.fechaProximaOcupacion = fechaProximaOcupacion;
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


    ///agrego funciones para asignar tipo y etsaod de habitaciones


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


    public void indicarTipoHabitacion() {
        Scanner scanner = new Scanner(System.in);
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

    public void menuEstadoHabitacion() {

        System.out.println("1: Disponible");
        System.out.println("2: Ocupada");
        System.out.println("3: Fuera de servicio");

    }




    public void indicarEstadoHabitacion() {
        Scanner scanner = new Scanner(System.in);

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
/*
    public JSONObject crearJson (){
        JSONObject habitacion = new JSONObject();
try {
    habitacion.put("Numero", this.getNumero());
    habitacion.put("Piso", this.getPiso());
    habitacion.put("Estado", this.getEstado());
    habitacion.put("Tarifa", this.getTarifa());
    habitacion.put("Fecha", this.fechaProximaOcupacion);
}catch(Exception e){
            e.printStackTrace();
        }

        return habitacion;
    }


    public void writerArchivoHab(String archivo, JSONObject jsonHabitacion) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter().nullSafe())
                .create();

        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(archivo));

            gson.toJson(jsonHabitacion);

        } catch (
                IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public Habitacion readerArchivoHab(String archivo) {

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter().nullSafe())
                .create();

        BufferedReader reader = null;
        Habitacion habitacion = null;


        try {
            reader = new BufferedReader(new FileReader(archivo));


            habitacion = gson.fromJson(reader, Habitacion.class);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return habitacion;
    }*/


    @Override
    public String toString() {
        return "Habitación " + this.numero + ":" +
                "\nPiso: " + this.piso +
                "\nDescripción: " + this.tarifa.getNombre() +
                "\nTarifa: $" + this.tarifa.getPrecio() +
                "\nEstado: " + this.estado +
                "\nPróxima ocupación: " + this.fechaProximaOcupacion;
    }
}
