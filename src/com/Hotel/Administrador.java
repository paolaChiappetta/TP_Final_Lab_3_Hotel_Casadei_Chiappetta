package com.Hotel;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Administrador extends Empleado implements Serializable, InterfazAccion {

    //Constructor vacío
    public Administrador() {
    }

    //Constructor con datos p/ generación de usuario y contraseña
    public Administrador(String nombre, String apellido, String numeroTel, String dni) {
        super(nombre, apellido, numeroTel, dni);
    }

    //Constructor completo
    public Administrador(String nombre, String apellido, String numerotel, String dni, String usuario, String clave) {
        super(nombre, apellido, numerotel, dni, usuario, clave);
    }

    //Métodos

    public void menuModificarHabitacion() {
        System.out.println("1- Número habitación");
        System.out.println("2- Piso");
        System.out.println("3- Tipo de Habitación - Tarifa");
        System.out.println("4- Estado de habitación");
    }

    @Override
    public void modificarHabitacion(Habitacion habitacion) {
        String continuar = "s";
        Scanner scanner = new Scanner(System.in);
        do {
            int opcion = 0;
            System.out.println(" ");
            System.out.println(habitacion);
            do{
                try {
                    System.out.println("\nIndique la opción que desea modificar: ");
                    menuModificarHabitacion();
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                }catch (InputMismatchException e){
                    System.out.println("Debe ingresar un número");
                    scanner.nextLine();
                }catch (Exception e){
                    System.out.println("Problema detectado");
                    scanner.nextLine();
                }
            }while (opcion==0);
            switch (opcion) {
                case 1:
                     int numero= 0;
                    do{
                        try{
                            System.out.println("Ingrese el nuevo número de la habitación:");
                            numero= scanner.nextInt();
                            scanner.nextLine();
                            habitacion.setNumero(numero);
                        }catch (InputMismatchException e){
                            System.out.println("Dato incorrecto");
                            scanner.nextLine();
                        }catch (Exception e){
                            System.out.println("Problema detecatdo");
                            scanner.nextLine();
                        }
                    }while (numero== 0);
                    break;
                case 2:
                    int piso= 0;
                    do{
                        try{
                            System.out.println("Ingrese el piso:");
                            piso= scanner.nextInt();
                            scanner.nextLine();
                            habitacion.setPiso(piso);
                        }catch (InputMismatchException e){
                            System.out.println("Dato incorrecto");
                            scanner.nextLine();
                        }catch (Exception e){
                            System.out.println("Problema detectado");
                            scanner.nextLine();
                        }
                    }while (piso== 0);
                    break;
                case 3:
                    habitacion.indicarTipoHabitacion();
                    break;
                case 4:
                    System.out.println("Ingrese el estado:");
                    habitacion.indicarEstadoHabitacion();
                    break;
                default:
                    System.out.println("Opción incorrecta. Ingrese nuevamente");
                    break;
            }
            System.out.println(" ");
            System.out.println(habitacion);
            System.out.println("\nDesea modificar otro dato? s/n");
            continuar=scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));
    }

}

