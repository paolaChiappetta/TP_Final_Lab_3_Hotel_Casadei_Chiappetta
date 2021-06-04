package com.Hotel;

import java.util.Scanner;

public abstract class Empleado extends Persona{

    private String usuario;
    private String clave;



    //constructores al principio se crean con generar usuario, despues se puede modificar con set


    public Empleado() { }

    public Empleado(String nombre, String apellido, String numeroTel) {

        super(nombre, apellido, numeroTel);
        this.generarUsuarioyClave();
    }




    //genero usuario concatenando 3 primeras letras de nombre y apellido, se mantienen las mayusculas

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




    /// mo agregue nada porq no se deben mostrar uruario y contraseña

    @Override
    public String toString() {
        return super.toString();
    }


}
