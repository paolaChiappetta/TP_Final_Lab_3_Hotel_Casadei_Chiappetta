package com.Hotel;

import java.io.*;
import java.util.Scanner;

public class Recepcionista extends Empleado implements Serializable, InterfazAccion {

    //constructor vacío
    public Recepcionista() {
    }

    //constructor con datos p/ generación de usuario y contraseña
    public Recepcionista(String nombre, String apellido, String numeroTel, String dni) {
        super(nombre, apellido, numeroTel, dni);
    }

    //constructor completo
    public Recepcionista(String nombre, String apellido, String numerotel, String dni, String usuario, String clave) {
        super(nombre, apellido, numerotel, dni, usuario, clave);
    }


    @Override
    public void modificarHabitacion(Habitacion habitacion) {
        System.out.println(habitacion);
        habitacion.indicarEstadoHabitacion();

    }

}
