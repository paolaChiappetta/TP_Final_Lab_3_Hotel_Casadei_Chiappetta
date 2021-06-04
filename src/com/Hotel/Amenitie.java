package com.Hotel;

public class Amenitie extends Extra {

    private String descripcion;
    private String horario;

    public Amenitie() {
    }

    public Amenitie(String nombre, Double precio, String descripcion, String horario) {
        super(nombre, precio);
        this.descripcion = descripcion;
        this.horario = horario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String mostrarExtra() {
        return super.mostrarExtra() + "Descripción: " + this.descripcion +
                "\nHorario: " + this.horario + "\n";
    }
}
