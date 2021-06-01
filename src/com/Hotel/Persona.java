package com.Hotel;

import java.time.LocalDate;

public abstract class Persona {

    private String nombre;
    private String apellido;
    private String numeroTel;


    public Persona() {}

    public Persona(String nombre, String apellido, String numerotel) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroTel= numerotel;
    }

    public String getNombre() {  return nombre;    }

    public void setNombre(String nombre) {   this.nombre = nombre;  }

    public String getApellido() {    return apellido;  }

    public void setApellido(String apellido) {    this.apellido = apellido;  }

    public String getNumeroTel() {   return numeroTel;  }

    public void setNumeroTel(String numeroTel) {   this.numeroTel = numeroTel;  }


    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", numeroTel='" + numeroTel + '\'' +
                '}';
    }
}
