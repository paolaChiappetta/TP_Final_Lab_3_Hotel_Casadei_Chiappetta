package com.Hotel;

public class GeneradorClaveUsuario {

    public String crearStringUsuario(Persona persona) {
        char[] car = new char[persona.getApellido().length() + 1];
        persona.getNombre().getChars(0, 1, car, 0);
        persona.getApellido().getChars(0, persona.getApellido().length(), car, 1);
        String usuario = String.valueOf(car);
        return usuario;
    }

    public char randomContrasenia() {
        int random = (int) (Math.random() * 62);
        int ascii;
        if (random <= 9) {
            ascii = random + 48;
        } else if (random <= 35) {
            ascii = random + 55;
        } else {
            ascii = random + 61;
        }
        return (char) ascii;
    }

    public String crarContrasenia() {
        String contrasenia = "";
        for (int i = 0; i < 6; i++) {
            contrasenia += randomContrasenia();
        }
        return contrasenia;
    }


}