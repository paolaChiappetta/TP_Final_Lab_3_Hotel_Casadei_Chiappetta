package com.Hotel;

import java.io.Serializable;
import java.util.Scanner;

public class Empleado extends Persona implements Serializable {

    //esta clase debería ser abstracta, pero se sacó para poder leer el archivo

    private String usuario;
    private String clave;

    //constructor vacío


    public Empleado() {
    }

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

   //getters y setters

    public String getClave() {     return clave;  }

    public void setClave(String clave) {    this.clave = clave; }

    public void setUsuario(String usuario) { this.usuario = usuario;   }

    public String getUsuario() {   return usuario; }

    //genero usuario concatenando primeras letra del nombre + el apellido, se mantienen las mayusculas
    public void generarUsuarioyClave() {
        GeneradorClaveUsuario claveUsuario= new GeneradorClaveUsuario();
        String usuarioNuevo= claveUsuario.crearStringUsuario(this);
        this.usuario = usuarioNuevo;
        String claveNueva = claveUsuario.crarContrasenia();
        this.clave=claveNueva;
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

    public void menuModificarEmpleado() {
        System.out.println("1- Nombre");
        System.out.println("2- Apellido");
        System.out.println("3- Dni");
        System.out.println("4- Telefono");
    }

    public void modificarEmpleado(Empleado empleado){
        Scanner scanner = new Scanner(System.in);
        String continuar = "s";

        int opcion = 0;
        do {
            System.out.println(" ");
            System.out.println(empleado);
            System.out.println("Indique el dato que desea modificar");
            menuModificarEmpleado();
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Nombre:");
                    empleado.setNombre(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("Apellido:");
                    empleado.setApellido(scanner.nextLine());
                    break;
                case 3:
                    System.out.println("Dni:");
                    empleado.setDni(scanner.nextLine());
                    break;
                case 4:
                    System.out.println("Telefono:");
                    empleado.setNumeroTel(scanner.nextLine());
                    break;
                default:
                    System.out.println("Opcion incorrecta, ingrese nuevamente");
                    break;
            }
            System.out.println(" ");
            System.out.println(empleado);
            scanner.nextLine();
            System.out.println("Desea modificar otro dato?");
            continuar=scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));
    }

}
