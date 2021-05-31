package com.Hotel;

import java.util.List;
import java.util.Scanner;

public class Shop {
    private List<Rotura> roturas;
    private List<Servicio> servicios;
    private List<Amenitie> amenities;
    private List<ProductoMinibar> minibar;

    public Shop(List<Rotura> roturas, List<Servicio> servicios, List<Amenitie> amenities, List<ProductoMinibar> minibar) {
        this.roturas = roturas;
        this.servicios = servicios;
        this.amenities = amenities;
        this.minibar = minibar;
    }

    public List<Rotura> getRoturas() {
        return roturas;
    }

    public void setRoturas(List<Rotura> roturas) {
        this.roturas = roturas;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public List<Amenitie> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<Amenitie> amenities) {
        this.amenities = amenities;
    }

    public List<ProductoMinibar> getMinibar() {
        return minibar;
    }

    public void setMinibar(List<ProductoMinibar> minibar) {
        this.minibar = minibar;
    }

    public void menuListas (){
        System.out.println("Qué listado desea ver?\n");
        System.out.println("1- Minibar");
        System.out.println("2- Amenities");
        System.out.println("3- Servicios");
        System.out.println("4- Roturas");
        System.out.println("Ingrese 0 para salir");

    }

    public void verListaPorTipo() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Qué tipo de listado desea ver?");
            System.out.println("1- Extras activos");
            System.out.println("2- Todos los extras");
            System.out.println("Ingrese 0 para salir");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    do {
                        menuListas();
                        opcion = scanner.nextInt();
                        switch (opcion) {
                            case 1:
                                for (ProductoMinibar lista : minibar) {
                                    if (lista.isAlta()) {
                                        System.out.println(lista);
                                    }
                                }
                                break;
                            case 2:
                                for (Amenitie lista : amenities) {
                                    if (lista.isAlta()) {
                                        System.out.println(lista);
                                    }
                                }
                                break;
                            case 3:
                                for (Servicio lista : servicios) {
                                    if (lista.isAlta()) {
                                        System.out.println(lista);
                                    }
                                }
                                break;
                            case 4:
                                for (Rotura lista : roturas) {
                                    if (lista.isAlta()) {
                                        System.out.println(lista);
                                    }
                                }
                                break;
                            default:
                                System.out.println("Opción incorrecta, intente nuevamente");
                                break;

                        }
                    } while (opcion != 0);
                    break;
                case 2:
                    do {
                        menuListas();
                        opcion = scanner.nextInt();
                        switch (opcion) {
                            case 1:
                                for (ProductoMinibar lista : minibar) {
                                    System.out.println(lista);
                                }
                                break;
                            case 2:
                                for (Amenitie lista : amenities) {
                                    System.out.println(lista);
                                }
                                break;
                            case 3:
                                for (Servicio lista : servicios) {
                                    System.out.println(lista);
                                }
                                break;
                            case 4:
                                for (Rotura lista : roturas) {
                                    System.out.println(lista);
                                }
                                break;
                            default:
                                System.out.println("Opción incorrecta, intente nuevamente");
                                break;

                        }
                    } while (opcion != 0);
                    break;
                default:
                    System.out.println("Opción incorrecta, intente nuevamente");
                    break;


            }
        }while (opcion != 0) ;
    }
}
