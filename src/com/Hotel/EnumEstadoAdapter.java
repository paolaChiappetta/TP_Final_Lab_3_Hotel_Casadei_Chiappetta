package com.Hotel;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class EnumEstadoAdapter implements JsonDeserializer<EstadoHabitacion> {
    @Override
    public EstadoHabitacion deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException
    {
        EstadoHabitacion[] estado = EstadoHabitacion.values();
        for (EstadoHabitacion lista : estado)
        {
            if (lista.equals(json.getAsString()))
                return lista;
        }
        return null;
    }
}
