package com.Hotel;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.time.LocalDate;
import java.util.List;

public class Archivo {

    private com.google.gson.Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter().nullSafe())
            .create();

    public Archivo() {
    }

    public void writerGsonLista(String archivo, List<Reserva> lista) {
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(archivo));

            gson.toJson(lista, lista.getClass(), writer);


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

    public List<Reserva> readerGsonLista(String archivo, List<Reserva> lista) {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(archivo));


            lista = gson.fromJson(reader, (new TypeToken<List<Reserva>>() {}.getType()));

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
        return lista;
    }


}