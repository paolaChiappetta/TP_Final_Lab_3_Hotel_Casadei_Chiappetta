package com.Hotel;

import org.w3c.dom.ls.LSOutput;

import java.io.Serializable;

public class Servicio extends Extra  implements Serializable {

    private String empleadoEncargado;

    public Servicio() {
    }

    public Servicio(String nombre, Double precio, String empleadoEncargado) {
        super(nombre, precio);
        this.empleadoEncargado = empleadoEncargado;
    }

    public Servicio(String nombre, Double precio, boolean alta, Integer cantidad, String empleadoEncargado) {
        super(nombre, precio, alta, cantidad);
        this.empleadoEncargado = empleadoEncargado;
    }

    public String getEmpleadoEncargado() {
        return empleadoEncargado;
    }

    public void setEmpleadoEncargado(String empleadoEncargado) {
        this.empleadoEncargado = empleadoEncargado;
    }


    @Override
    public String mostrarExtra() {
        return super.mostrarExtra() + "Solicitar a el/la " + this.empleadoEncargado + "\n";
    }
}
