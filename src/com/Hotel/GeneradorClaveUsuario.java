package com.Hotel;

public class GeneradorClaveUsuario {

    /*
// private static String [] numeros= {"0","1","2","3","4","a","b", "c", "d"};
 private static String caracteres= "1234567890abcdefghijklmnopqrstuvwxyz";


    ///constructor

  public GeneradorClave() { }



    // funciones generar clave


    public String generarClave(){
        return generarClave(8);
    }

    public String generarClave(int tamanio){

        return generarClave( caracteres, tamanio);
    }

    public String generarClave(String caracteres, int tamanio) {

        String clave = "";
        for (int i = 0; i < tamanio; i++) {
              clave+= (caracteres.charAt((int)Math.random()));
        }
        return clave;
    }
*/


    public String crearStringUsuario(Persona persona){
        char[]car= new char[6];
        persona.getNombre().getChars(0,3,car,0);
        persona.getApellido().getChars(0,3,car, 3);


        String usuario= String.valueOf(car);
        return usuario;
    }




}