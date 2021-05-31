package com.Hotel;

public class Servicio extends Extra {

    private String empleadoEncargado;

    public Servicio() {
    }

    public Servicio(String nombre, Double precio, String empleadoEncargado) {
        super(nombre, precio);
        this.empleadoEncargado = empleadoEncargado;
    }

    public String getEmpleadoEncargado() {
        return empleadoEncargado;
    }

    public void setEmpleadoEncargado(String empleadoEncargado) {
        this.empleadoEncargado = empleadoEncargado;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nSolicitar a:" + this.empleadoEncargado;
    }
}
