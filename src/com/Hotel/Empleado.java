package com.Hotel;

import java.io.Serializable;
import java.util.Scanner;

public abstract class Empleado extends Persona implements Serializable {

    private String usuario;
    private String clave;

    //constructor vacío
    public Empleado() { }

    //constructor con datos y generación de usuario y contraseña
    public Empleado(String nombre, String apellido, String numeroTel, String dni) {

        super(nombre, apellido, numeroTel, dni);
        this.generarUsuarioyClave();
    }

    //constructor completo
    public Empleado(String nombre, String apellido, String numerotel, String dni, String usuario, String clave) {
        super(nombre, apellido, numerotel, dni);
        this.usuario = usuario;
        this.clave = clave;
    }

    //genero usuario concatenando primeras letra del nombre + el apellido, se mantienen las mayusculas

    public void generarUsuarioyClave() {
        GeneradorClaveUsuario claveUsuario= new GeneradorClaveUsuario();
        String usuarioNuevo= claveUsuario.crearStringUsuario(this);
        this.usuario = usuarioNuevo;
        String claveNueva = claveUsuario.crarContrasenia();
        this.clave=claveNueva;
    }

    //getters y setters

    public String getClave() {     return clave;  }

    public void setClave(String clave) {    this.clave = clave; }

    public void setUsuario(String usuario) { this.usuario = usuario;   }

    public String getUsuario() {   return usuario; }


    /// para modificar usuario y clave comparo si coincide el dato anterior con el actual,
    // en ese caso se modifica

    public void modificarClave(Empleado empleado, String claveAnterior, String nuevaClave) {
        if (empleado.getClave().compareTo(claveAnterior) == 0) {

            empleado.setClave(nuevaClave);
        } else {
            System.out.println("Clave incorrecta");

        }
    }

    public void modificarUsuario(Empleado empleado, String usuarioAnterior, String nuevoUsuario) {

        if (empleado.getUsuario().compareTo(usuarioAnterior) == 0) {
            empleado.setUsuario(nuevoUsuario);
        } else {
            System.out.println("Usuario incorrecto");
        }
    }

}
