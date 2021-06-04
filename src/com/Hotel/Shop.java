package com.Hotel;

import java.util.List;
import java.util.Scanner;

public class Shop {
    private List<Rotura> roturas;
    private List<Servicio> servicios;
    private List<Amenitie> amenities;
    private List<ProductoMinibar> minibar;
    private Scanner scanner = new Scanner(System.in);

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

    public void verListaServicios(Empleado empleado) {
        if (this.servicios != null) {
            System.out.println(">>Servicios<<\n");
            for (Servicio lista : servicios) {
                if (empleado instanceof Recepcionista) {
                    System.out.println(lista.mostrarExtra());
                } else {
                    if (lista.isAlta()) {
                        System.out.println(lista.mostrarExtra() + "\nEstado: alta");
                    } else {
                        System.out.println(lista.mostrarExtra() + "\nEstado: baja");
                    }
                }
            }
        } else {
            System.out.println("No hay servicios cargados");
        }
    }

    public void verListaAmenities(Empleado empleado) {
        if (this.amenities != null) {
            System.out.println(">>Amenities<<\n");
            for (Amenitie lista : amenities) {
                if (empleado instanceof Recepcionista) {
                    System.out.println(lista.mostrarExtra());
                } else {
                    if (lista.isAlta()) {
                        System.out.println(lista.mostrarExtra() + "\nEstado: alta");
                    } else {
                        System.out.println(lista.mostrarExtra() + "\nEstado: baja");
                    }
                }
            }
        } else {
            System.out.println("No hay amenities cargadas");
        }
    }

    public void verListaMinibar(Empleado empleado) {
        if (this.minibar != null) {
            System.out.println(">>Minibar<<\n");
            for (ProductoMinibar lista : minibar) {
                if (empleado instanceof Recepcionista) {
                    System.out.println(lista.mostrarExtra());
                } else {
                    if (lista.isAlta()) {
                        System.out.println(lista.mostrarExtra() + "\nEstado: alta");
                    } else {
                        System.out.println(lista.mostrarExtra() + "\nEstado: baja");
                    }
                }
            }
        } else {
            System.out.println("No hay productos cargados");
        }
    }

    public void verListaRotura(Empleado empleado) {
        if (this.roturas != null) {
            System.out.println(">>Roturas<<\n");
            for (Rotura lista : roturas) {
                if (empleado instanceof Recepcionista) {
                    System.out.println(lista.mostrarExtra());
                } else {
                    if (lista.isAlta()) {
                        System.out.println(lista.mostrarExtra() + "\nEstado: alta");
                    } else {
                        System.out.println(lista.mostrarExtra() + "\nEstado: baja");
                    }
                }
            }
        } else {
            System.out.println("No hay roturas cargadas");
        }
    }

    public void opcionesExtras() {
        System.out.println("1- Servicio");
        System.out.println("2- Amenitie");
        System.out.println("3- Minibar");
        System.out.println("4- Rotura");
    }


    public void cargarExtraHabitacion(Hotel hotel) {
        int opcion;
        Extra extra = null;
        String continuar = "s";
        String nombre;
        int nroHabitacion;
        int cantidad;

        do {
            System.out.println("Ingrese el número de la habitación");
            nroHabitacion = scanner.nextInt();
            System.out.println("Qué tipo de extra desea cargar?");
            opcionesExtras();
            opcion = scanner.nextInt();
            nombre = scanner.nextLine();
            System.out.println("Ingrese el nombre del extra");
            nombre = scanner.nextLine();
            System.out.println("Ingrese la cantidad");
            cantidad = scanner.nextInt();

            switch (opcion) {
                case 1:
                    if (this.servicios != null) {
                        for (Servicio lista : servicios) {
                            if (lista.getNombre().compareTo(nombre) == 0) {
                                extra = lista;
                            }
                        }
                    } else {
                        System.out.println("No hay servicios cargados");
                    }
                    break;
                case 2:
                    if (this.amenities != null) {
                        for (Amenitie lista : this.amenities) {
                            if (lista.getNombre().compareTo(nombre) == 0) {
                                extra = lista;
                            }
                        }
                    } else {
                        System.out.println("No hay amenities cargadas");
                    }
                    break;
                case 3:
                    if (this.minibar != null) {
                        for (ProductoMinibar lista : minibar) {
                            if (lista.getNombre().compareTo(nombre) == 0) {
                                extra = lista;
                            }
                        }
                    } else {
                        System.out.println("No hay productos cargados");
                    }
                    break;
                case 4:
                    if (this.roturas != null) {
                        for (Rotura lista : roturas) {
                            if (lista.getNombre().compareTo(nombre) == 0) {
                                extra = lista;
                            }
                        }
                    } else {
                        System.out.println("No hay roturas cargadas");
                    }
                    break;
                default:
                    System.out.println("Opción incorrecta, intente nuevamente");
                    break;
            }
            if (extra != null) {
                int i = 0;
                while (i < cantidad) {
                    hotel.buscarOcupacionPorHabitacion(nroHabitacion).getExtras().add(extra);
                    i++;
                }
            }

            scanner.nextLine();
            System.out.println("Desea seguir cargando? s/n");
            scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

    }

    public void eliminarExtraHabitacion(Hotel hotel) {
        int nroHab;
        String nombre;
        System.out.println("Ingrese el número de habitación");
        nroHab = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el nombre del extra");
        nombre = scanner.nextLine();

        if (hotel.buscarOcupacionPorHabitacion(nroHab).getExtras() != null) {
            for (Extra lista : hotel.buscarOcupacionPorHabitacion(nroHab).getExtras()) {
                if (lista.getNombre().equalsIgnoreCase(nombre)) {
                    hotel.buscarOcupacionPorHabitacion(nroHab).getExtras().remove(lista);
                }
            }
        } else {
            System.out.println("No hay extras cargados en esta habitación");
        }


    }

    public void nuevoExtra() {
        String nombre;
        Double precio;
        int opcion;
        String continuar = "s";

        do {
            System.out.println("Qué tipo de extra desea cargar?");
            opcionesExtras();
            opcion = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese el nombre del extra");
            nombre = scanner.nextLine();
            System.out.println("Ingrese el precio");
            precio = scanner.nextDouble();

            switch (opcion) {
                case 1:
                    String empleado;
                    System.out.println("Qué empleado lo realiza?");
                    empleado = scanner.nextLine();
                    Servicio servicio = new Servicio(nombre, precio, empleado);
                    this.servicios.add(servicio);
                    System.out.println("\nSe cargó exitosamente el siguiente servicio: ");
                    servicio.mostrarExtra();
                    break;
                case 2:
                    String descripcion, horario;
                    System.out.println("Escriba una breve descripción del servicio");
                    descripcion = scanner.nextLine();
                    System.out.println("Escriba en qué horario se encuentra disponible");
                    horario = scanner.nextLine();
                    Amenitie amenitie = new Amenitie(nombre, precio, descripcion, horario);
                    this.amenities.add(amenitie);
                    System.out.println("\nSe cargó exitosamente la siguiente amenitie: ");
                    amenitie.mostrarExtra();
                    break;
                case 3:
                    String marca;
                    System.out.println("Escriba la marca del producto");
                    marca = scanner.nextLine();
                    ProductoMinibar producto = new ProductoMinibar(nombre, precio, marca);
                    this.minibar.add(producto);
                    System.out.println("\nSe cargó exitosamente el siguiente producto: ");
                    producto.mostrarExtra();
                    break;
                case 4:
                    String causa;
                    System.out.println("Escriba la causa de la rotura");
                    causa = scanner.nextLine();
                    Rotura rotura = new Rotura(nombre, precio, causa);
                    this.roturas.add(rotura);
                    System.out.println("\nSe cargó exitosamente la siguiente rotura: ");
                    rotura.mostrarExtra();
                    break;
                default:
                    System.out.println("La opción ingresada es incorrecta. Ingrese nuevamente");
                    break;
            }

            scanner.nextLine();
            System.out.println("Desea cargar otro extra? s/n");
            scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

    }

    public void bajaExtra() {
        String nombre;
        int opcion;
        String continuar = "s";
        boolean encontrado = false;

        do {
            System.out.println("Qué tipo de extra desea dar de baja?");
            opcionesExtras();
            opcion = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese el nombre del extra");
            nombre = scanner.nextLine();
            int i=0;

            switch (opcion) {
                case 1:
                    if (this.servicios != null) {
                        while (encontrado==false && i<servicios.size()){
                            if(servicios.get(i).getNombre().equalsIgnoreCase(nombre)){
                                servicios.get(i).setAlta(false);
                                encontrado=true;

                            }
                            i++;
                        }
                    }
                    break;
                case 2:
                    if (this.amenities != null) {
                        while (encontrado==false && i<amenities.size()){
                            if(amenities.get(i).getNombre().equalsIgnoreCase(nombre)){
                                amenities.get(i).setAlta(false);
                                encontrado=true;

                            }
                            i++;
                        }
                    }
                    break;
                case 3:
                    if (this.minibar != null) {
                        while (encontrado==false && i<minibar.size()){
                            if(minibar.get(i).getNombre().equalsIgnoreCase(nombre)){
                                minibar.get(i).setAlta(false);
                                encontrado=true;

                            }
                            i++;
                        }
                    }
                    break;

                case 4:
                    if (this.roturas != null) {
                        while (encontrado==false && i<roturas.size()){
                            if(roturas.get(i).getNombre().equalsIgnoreCase(nombre)){
                                roturas.get(i).setAlta(false);
                                encontrado=true;

                            }
                            i++;
                        }
                    }
                    break;
                default:
                    System.out.println("La opción ingresada es incorrecta. Ingrese nuevamente");
                    break;
            }
            if(encontrado==true){
                System.out.println("El extra fue dado de baja correctamente");
            }else{
                System.out.println("No se encontraron coincidencias con el nombre indicado");
            }
            scanner.nextLine();
            System.out.println("Desea dar de baja otro extra? s/n");
            scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));
    }

    public void eliminarExtra() {
        String nombre;
        int opcion;
        String continuar = "s";
        boolean encontrado = false;

        do {
            System.out.println("Qué tipo de extra desea eliminar?");
            opcionesExtras();
            opcion = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese el nombre del extra");
            nombre = scanner.nextLine();
            int i=0;

            switch (opcion) {
                case 1:
                    if (this.servicios != null) {
                        while (encontrado==false && i<servicios.size()){
                            if(servicios.get(i).getNombre().equalsIgnoreCase(nombre)){
                                servicios.remove(servicios.get(i));
                                encontrado=true;

                            }
                            i++;
                        }
                    }
                    break;
                case 2:
                    if (this.amenities!= null) {
                        while (encontrado==false && i<amenities.size()){
                            if(amenities.get(i).getNombre().equalsIgnoreCase(nombre)){
                                amenities.remove(amenities.get(i));
                                encontrado=true;

                            }
                            i++;
                        }
                    }
                    break;
                case 3:
                    if (this.minibar!= null) {
                        while (encontrado==false && i<minibar.size()){
                            if(minibar.get(i).getNombre().equalsIgnoreCase(nombre)){
                                minibar.remove(minibar.get(i));
                                encontrado=true;

                            }
                            i++;
                        }
                    }
                    break;

                case 4:
                    if (this.roturas!= null) {
                        while (encontrado==false && i<roturas.size()){
                            if(roturas.get(i).getNombre().equalsIgnoreCase(nombre)){
                                roturas.remove(roturas.get(i));
                                encontrado=true;

                            }
                            i++;
                        }
                    }
                    break;
                default:
                    System.out.println("La opción ingresada es incorrecta. Ingrese nuevamente");
                    break;
            }
            if(encontrado==true){
                System.out.println("El extra fue eliminado correctamente");
            }else{
                System.out.println("No se encontraron coincidencias con el nombre indicado");
            }
            scanner.nextLine();
            System.out.println("Desea eliminar otro extra? s/n");
            scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));


    }

    public void modificarExtra() {
        String nombre;
        int opcion;
        String continuar = "s";
        boolean encontrado = false;

        do {
            System.out.println("Qué tipo de extra desea modificar?");
            opcionesExtras();
            opcion = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese el nombre del extra");
            nombre = scanner.nextLine();
            int i=0;


            switch (opcion) {
                case 1:
                    if (this.servicios != null) {
                        while (encontrado==false && i<servicios.size()){
                            if(servicios.get(i).getNombre().equalsIgnoreCase(nombre)){
                                do{
                                    System.out.println("Qué desea modificar: ");
                                    System.out.println("1- Nombre");
                                    System.out.println("2- Precio");
                                    System.out.println("3- Empleado a cargo");
                                    opcion=scanner.nextInt();
                                    scanner.nextLine();
                                    switch (opcion){
                                        case 1:
                                            System.out.println("Ingrese el nuevo nombre");
                                            servicios.get(i).setNombre(scanner.nextLine());
                                            break;
                                        case 2:
                                            System.out.println("Ingrese el nuevo precio");
                                            servicios.get(i).setPrecio(scanner.nextDouble());
                                            break;
                                        case 3:
                                            System.out.println("Ingrese el nuevo empleado a cargo");
                                            servicios.get(i).setEmpleadoEncargado(scanner.nextLine());
                                            break;
                                        default:
                                            System.out.println("Opción incorrecta. Ingrese nuevamente");
                                            break;
                                    }
                                    if(encontrado==true){
                                        System.out.println("El extra fue modificado correctamente");
                                    }else{
                                        System.out.println("No se encontraron coincidencias con el nombre indicado");
                                    }

                                    scanner.nextLine();
                                    System.out.println("Desea hacer otra modificación sobre este producto? s/n");
                                    continuar=scanner.nextLine();

                                }while (continuar.equalsIgnoreCase("s"));

                                encontrado=true;

                            }
                            i++;
                        }
                    }
                    break;
                case 2:
                    if (this.amenities != null) {
                        while (encontrado==false && i<amenities.size()){
                            if(amenities.get(i).getNombre().equalsIgnoreCase(nombre)){
                                do{
                                    System.out.println("Qué desea modificar: ");
                                    System.out.println("1- Nombre");
                                    System.out.println("2- Precio");
                                    System.out.println("3- Descripción");
                                    System.out.println("4- Horario");
                                    opcion=scanner.nextInt();
                                    scanner.nextLine();
                                    switch (opcion){
                                        case 1:
                                            System.out.println("Ingrese el nuevo nombre");
                                            amenities.get(i).setNombre(scanner.nextLine());
                                            break;
                                        case 2:
                                            System.out.println("Ingrese el nuevo precio");
                                            amenities.get(i).setPrecio(scanner.nextDouble());
                                            break;
                                        case 3:
                                            System.out.println("Ingrese la nueva descripción");
                                            amenities.get(i).setDescripcion(scanner.nextLine());
                                            break;
                                        case 4:
                                            System.out.println("Ingrese el nuevo horario");
                                            amenities.get(i).setHorario(scanner.nextLine());
                                        default:
                                            System.out.println("Opción incorrecta. Ingrese nuevamente");
                                            break;
                                    }
                                    if(encontrado==true){
                                        System.out.println("El extra fue modificado correctamente");
                                    }else{
                                        System.out.println("No se encontraron coincidencias con el nombre indicado");
                                    }

                                    scanner.nextLine();
                                    System.out.println("Desea hacer otra modificación sobre este producto? s/n");
                                    continuar=scanner.nextLine();

                                }while (continuar.equalsIgnoreCase("s"));

                                encontrado=true;

                            }
                            i++;
                        }
                    }
                    break;
                case 3:
                    if (this.minibar != null) {
                        while (encontrado==false && i<minibar.size()){
                            if(minibar.get(i).getNombre().equalsIgnoreCase(nombre)){
                                do{
                                    System.out.println("Qué desea modificar: ");
                                    System.out.println("1- Nombre");
                                    System.out.println("2- Precio");
                                    System.out.println("3- Marca");
                                    opcion=scanner.nextInt();
                                    scanner.nextLine();
                                    switch (opcion){
                                        case 1:
                                            System.out.println("Ingrese el nuevo nombre");
                                            minibar.get(i).setNombre(scanner.nextLine());
                                            break;
                                        case 2:
                                            System.out.println("Ingrese el nuevo precio");
                                            minibar.get(i).setPrecio(scanner.nextDouble());
                                            break;
                                        case 3:
                                            System.out.println("Ingrese la nueva marca");
                                            minibar.get(i).setMarca(scanner.nextLine());
                                            break;
                                        default:
                                            System.out.println("Opción incorrecta. Ingrese nuevamente");
                                            break;
                                    }
                                    if(encontrado==true){
                                        System.out.println("El extra fue modificado correctamente");
                                    }else{
                                        System.out.println("No se encontraron coincidencias con el nombre indicado");
                                    }

                                    scanner.nextLine();
                                    System.out.println("Desea hacer otra modificación sobre este producto? s/n");
                                    continuar=scanner.nextLine();

                                }while (continuar.equalsIgnoreCase("s"));

                                encontrado=true;

                            }
                            i++;
                        }
                    }
                    break;

                case 4:
                    if (this.roturas != null) {
                        while (encontrado==false && i<roturas.size()){
                            if(roturas.get(i).getNombre().equalsIgnoreCase(nombre)){
                                do{
                                    System.out.println("Qué desea modificar: ");
                                    System.out.println("1- Nombre");
                                    System.out.println("2- Precio");
                                    System.out.println("3- Causa");
                                    opcion=scanner.nextInt();
                                    scanner.nextLine();
                                    switch (opcion){
                                        case 1:
                                            System.out.println("Ingrese el nuevo nombre");
                                            roturas.get(i).setNombre(scanner.nextLine());
                                            break;
                                        case 2:
                                            System.out.println("Ingrese el nuevo precio");
                                            roturas.get(i).setPrecio(scanner.nextDouble());
                                            break;
                                        case 3:
                                            System.out.println("Ingrese la nueva causa");
                                           roturas.get(i).setCausa(scanner.nextLine());
                                            break;
                                        default:
                                            System.out.println("Opción incorrecta. Ingrese nuevamente");
                                            break;
                                    }
                                    if(encontrado==true){
                                        System.out.println("El extra fue modificado correctamente");
                                    }else{
                                        System.out.println("No se encontraron coincidencias con el nombre indicado");
                                    }

                                    scanner.nextLine();
                                    System.out.println("Desea hacer otra modificación sobre este producto? s/n");
                                    continuar=scanner.nextLine();

                                }while (continuar.equalsIgnoreCase("s"));

                                encontrado=true;

                            }
                            i++;
                        }
                    }
                    break;
                default:
                    System.out.println("La opción ingresada es incorrecta. Ingrese nuevamente");
                    break;
            }
            scanner.nextLine();
            System.out.println("Desea modificar otro extra? s/n");
            scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));


    }

    public void altaExtra() {
        String nombre;
        int opcion;
        String continuar = "s";
        boolean encontrado = false;

        do {
            System.out.println("Qué tipo de extra desea dar de alta?");
            opcionesExtras();
            opcion = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese el nombre del extra");
            nombre = scanner.nextLine();
            int i=0;

            switch (opcion) {
                case 1:
                    if (this.servicios != null) {
                        while (encontrado==false && i<servicios.size()){
                            if(servicios.get(i).getNombre().equalsIgnoreCase(nombre)){
                                servicios.get(i).setAlta(true);
                                encontrado=true;

                            }
                            i++;
                        }
                    }
                    break;
                case 2:
                    if (this.amenities != null) {
                        while (encontrado==false && i<amenities.size()){
                            if(amenities.get(i).getNombre().equalsIgnoreCase(nombre)){
                                amenities.get(i).setAlta(true);
                                encontrado=true;

                            }
                            i++;
                        }
                    }
                    break;
                case 3:
                    if (this.minibar != null) {
                        while (encontrado==false && i<minibar.size()){
                            if(minibar.get(i).getNombre().equalsIgnoreCase(nombre)){
                                minibar.get(i).setAlta(true);
                                encontrado=true;

                            }
                            i++;
                        }
                    }
                    break;

                case 4:
                    if (this.roturas != null) {
                        while (encontrado==false && i<roturas.size()){
                            if(roturas.get(i).getNombre().equalsIgnoreCase(nombre)){
                                roturas.get(i).setAlta(true);
                                encontrado=true;

                            }
                            i++;
                        }
                    }
                    break;
                default:
                    System.out.println("La opción ingresada es incorrecta. Ingrese nuevamente");
                    break;
            }
            if(encontrado==true){
                System.out.println("El extra fue dado de alta correctamente");
            }else{
                System.out.println("No se encontraron coincidencias con el nombre indicado");
            }
            scanner.nextLine();
            System.out.println("Desea dar de alta otro extra? s/n");
            scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));
    }
}