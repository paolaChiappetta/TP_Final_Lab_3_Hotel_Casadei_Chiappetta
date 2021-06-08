package com.Hotel;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class EnumTarifaAdapter implements JsonDeserializer<Tarifa> {

    @Override
    public Tarifa deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException
    {
        Tarifa[] tarifa = Tarifa.values();
        for (Tarifa lista : tarifa)
        {
            if (lista.getNombre().equals(json.getAsString()))
                return lista;
        }
        return null;
    }
}
