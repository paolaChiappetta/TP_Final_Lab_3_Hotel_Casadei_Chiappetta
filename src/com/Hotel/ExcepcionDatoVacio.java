package com.Hotel;

/// NUEVA EXCEPTION POR SI EL DATO POSEE UN ESPACIO EN BLANCO

public class ExcepcionDatoVacio extends Exception{



    public ExcepcionDatoVacio() {
    }

    public ExcepcionDatoVacio(String message) {
        super(message);
    }
}
