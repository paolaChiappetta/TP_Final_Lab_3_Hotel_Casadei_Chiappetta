package com.Hotel;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Persona implements Serializable {

    //Atributos
    private String nombre;
    private String apellido;
    private String numeroTel;
    private String dni;

//Cosntructor vacío
    public Persona() {}

    //Constructor completo
    public Persona(String nombre, String apellido, String numeroTel, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroTel = numeroTel;
        this.dni = dni;
    }

    //Getters y setters

    public String getNombre() {  return nombre;    }

    public void setNombre(String nombre) {   this.nombre = nombre;  }

    public String getApellido() {    return apellido;  }

    public void setApellido(String apellido) {    this.apellido = apellido;  }

    public String getNumeroTel() {   return numeroTel;  }

    public void setNumeroTel(String numeroTel) {   this.numeroTel = numeroTel;  }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + " " + this.apellido +
                "\nDni: " + this.dni +
                "\nTeléfono: " + this.numeroTel;
    }
}
