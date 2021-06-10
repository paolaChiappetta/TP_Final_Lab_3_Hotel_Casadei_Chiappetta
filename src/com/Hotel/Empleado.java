package com.Hotel;

import java.io.Serializable;
import java.util.Scanner;

public class Empleado extends Persona implements Serializable {
    //esta clase debería ser abstracta, pero se sacó para poder leer el archivo

    //Atributos
    private String usuario;
    private String clave;

    //Constructor vacío
    public Empleado() {
    }

    //Constructor con datos y generación de usuario y contraseña
    public Empleado(String nombre, String apellido, String numeroTel, String dni) {

        super(nombre, apellido, numeroTel, dni);
        this.generarUsuarioyClave();
    }

    //Constructor completo
    public Empleado(String nombre, String apellido, String numerotel, String dni, String usuario, String clave) {
        super(nombre, apellido, numerotel, dni);
        this.usuario = usuario;
        this.clave = clave;
    }

   //Getters y Setters

    public String getClave() {     return clave;  }

    public void setClave(String clave) {    this.clave = clave; }

    public void setUsuario(String usuario) { this.usuario = usuario;   }

    public String getUsuario() {   return usuario; }

    //Métodos

    //Se genera usuario concatenando la primera letra del nombre + el apellido, se mantienen las mayúsculas
    public void generarUsuarioyClave() {
        GeneradorClaveUsuario claveUsuario= new GeneradorClaveUsuario();
        this.usuario = claveUsuario.crearStringUsuario(this);
        this.clave= claveUsuario.crarContrasenia();
    }

    /// para modificar clave comparo si coincide el dato anterior con el actual,
    // en ese caso se modifica

    public void modificarClave(Empleado empleado, String claveAnterior, String nuevaClave) {
        Scanner scanner = new Scanner(System.in);
        if (empleado.getClave().compareTo(claveAnterior) == 0) {
            System.out.println("Ingrese nuevamente su nueva clave para confirmar");
            if(scanner.nextLine().compareTo(nuevaClave)==0){
                empleado.setClave(nuevaClave);
                System.out.println("Su contraseña se modificó correctamente");
            }else{
                System.out.println("La confirmación de la nueva contraseña es incorrecta");
            }

        } else {
            System.out.println("Su contraseña actual es incorrecta");
        }
    }



}
