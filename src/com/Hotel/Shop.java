package com.Hotel;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Shop {
    private List<Rotura> roturas;
    private List<Servicio> servicios;
    private List<Amenitie> amenities;
    private List<ProductoMinibar> minibar;


    public Shop() {
        this.roturas = new ArrayList<>();
        this.servicios = new ArrayList<>();
        this.amenities = new ArrayList<>();
        this.minibar = new ArrayList<>();
    }

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

    //LISTA DE SERVICIOS
    public void verListaServicios(Empleado empleado) {
        if (!this.servicios.isEmpty()) {
            System.out.println(">>Servicios<<\n");
            for (Servicio lista : servicios) {  //Recorro la lista de servicios
                if (empleado instanceof Recepcionista) { //si el empleado es recepcionista
                    if (lista.isAlta()) {  //muestro solo los servicios de alta
                        System.out.println(lista.mostrarExtra());
                    }

                } else {  //si es administrador muestro todos los servicios y su estado
                    if (lista.isAlta()) {
                        System.out.println(lista.mostrarExtra() + "Estado: alta\n");
                    } else {
                        System.out.println(lista.mostrarExtra() + "Estado: baja\n");
                    }
                }
            }
        } else {
            System.out.println("No hay servicios cargados");
        }
    }

    //LISTA DE AMENITIES
    public void verListaAmenities(Empleado empleado) {
        if (!this.amenities.isEmpty()) {
            System.out.println(">>Amenities<<\n");
            for (Amenitie lista : amenities) { //Recorro la lista de amenities
                if (empleado instanceof Recepcionista) { //si el empleado es recepcionista
                    if (lista.isAlta()) { //muestro solo las amenities de alta
                        System.out.println(lista.mostrarExtra());
                    }

                } else { //si es administrador muestro todos las amenities y su estado
                    if (lista.isAlta()) {
                        System.out.println(lista.mostrarExtra() + "Estado: alta\n");
                    } else {
                        System.out.println(lista.mostrarExtra() + "Estado: baja\n");
                    }
                }
            }
        } else {
            System.out.println("No hay amenities cargadas");
        }
    }

    //LISTA DEL MINIBAR
    public void verListaMinibar(Empleado empleado) {
        if (!this.minibar.isEmpty()) {
            System.out.println(">>Minibar<<\n");
            for (ProductoMinibar lista : minibar) { //Recorro la lista del minibar
                if (empleado instanceof Recepcionista) {//si el empleado es recepcionista
                    if (lista.isAlta()) { //muestro solo los productos de alta
                        System.out.println(lista.mostrarExtra());
                    }

                } else {
                    if (lista.isAlta()) { //si es administrador muestro todos los productos y su estado
                        System.out.println(lista.mostrarExtra() + "Estado: alta\n");
                    } else {
                        System.out.println(lista.mostrarExtra() + "Estado: baja\n");
                    }
                }
            }
        } else {
            System.out.println("No hay productos cargados");
        }
    }

    //LISTA DE ROTURAS
    public void verListaRotura(Empleado empleado) {
        if (!this.roturas.isEmpty()) {
            System.out.println(">>Roturas<<\n");
            for (Rotura lista : roturas) { //Recorro la lista de roturas
                if (empleado instanceof Recepcionista) { //si el empleado es recepcionista
                    if (lista.isAlta()) { //muestro solo las roturas de alta
                        System.out.println(lista.mostrarExtra());
                    }

                } else { //si es administrador muestro todos las roturas y su estado
                    if (lista.isAlta()) {
                        System.out.println(lista.mostrarExtra() + "Estado: alta\n");
                    } else {
                        System.out.println(lista.mostrarExtra() + "Estado: baja\n");
                    }
                }
            }
        } else {
            System.out.println("No hay roturas cargadas");
        }
    }

    //MENU TIPO DE EXTRAS
    public void opcionesExtras() {
        System.out.println("1- Servicio");
        System.out.println("2- Amenitie");
        System.out.println("3- Minibar");
        System.out.println("4- Rotura");
    }


    //CARGAR UN EXTRA AL LISTADO DE LA HABITACION OCUPADA
    public void cargarExtraHabitacion(Hotel hotel, Empleado empleado) {
        Scanner scanner = new Scanner(System.in);
        Extra extra = null;
        String continuar = "s";
        String nombre;
        int nroHabitacion = 0;

        boolean habEncontrada = false;
        boolean ocupacionEncontrada = false;
        do {
            try {
                System.out.println("Ingrese el n??mero de la habitaci??n"); //Se pide el numero de habitaci??n a la que se le cargar?? el extra
                nroHabitacion = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un n??mero");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Problema detectado");
                scanner.nextLine();
            }
        } while (nroHabitacion == 0);

    habEncontrada=hotel.verificarHabitacionExistente(nroHabitacion);

        if(habEncontrada)

    { //si existe la hab verifico que haya ocupaci??n
        ocupacionEncontrada = hotel.verificarOcupacionExistente(nroHabitacion);
    }

        if(habEncontrada && ocupacionEncontrada)

    { //verifico que exista la ocupacion y el nro de hab a la que se le cargar?? el extra
        do {
            int opcion=0;
            do{
                try{
                    System.out.println("Qu?? tipo de extra desea cargar?"); //Consulto el tipo de extra p/revisar buscarlo solo en esa lista
                    opcionesExtras();
                    opcion = scanner.nextInt();
                  scanner.nextLine();
                }catch (InputMismatchException e) {
                    System.out.println("Debe ingresar un n??mero");
                    scanner.nextLine();
                } catch (Exception e) {
                    System.out.println("Problema detectado");
                    scanner.nextLine();
                }
            } while (opcion == 0);

            if (opcion == 1) {
                verListaServicios(empleado);
            } else if (opcion == 2) {
                verListaAmenities(empleado);
            } else if (opcion == 3) {
                verListaMinibar(empleado);
            } else {
                verListaRotura(empleado);
            }
            System.out.println("\nIngrese el nombre del extra"); //Se busca por nombre
            nombre = scanner.nextLine();
            int cantidad=0;
            do{
                try{
                    System.out.println("Ingrese la cantidad"); //Se pide cantidad p/no repetir la b??squeda si se necesitan cargar m??s de una unidad del mismo producto
                    cantidad = scanner.nextInt();
                    scanner.nextLine();
                }catch (InputMismatchException e) {
                    System.out.println("Debe ingresar un n??mero");
                    scanner.nextLine();
                } catch (Exception e) {
                    System.out.println("Problema detectado");
                    scanner.nextLine();
                }
            } while (cantidad== 0);

            switch (opcion) {
                case 1:
                    if (!this.servicios.isEmpty()) {
                        for (Servicio lista : servicios) {
                            if (lista.getNombre().compareTo(nombre) == 0) { //busco por nombre en la lista
                                if (lista.isAlta()) {
                                    extra = lista;  //si est?? de alta guarda el producto en extra
                                }

                            }
                        }
                    } else {
                        System.out.println("No hay servicios cargados");
                    }
                    break;
                case 2:
                    if (!this.amenities.isEmpty()) {
                        for (Amenitie lista : this.amenities) {
                            if (lista.getNombre().compareTo(nombre) == 0) { //busco por nombre en la lista
                                if (lista.isAlta()) {
                                    extra = lista; //si est?? de alta guarda el producto en extra
                                }
                            }
                        }
                    } else {
                        System.out.println("No hay amenities cargadas");
                    }
                    break;
                case 3:
                    if (!this.minibar.isEmpty()) {
                        for (ProductoMinibar lista : minibar) {
                            if (lista.getNombre().compareTo(nombre) == 0) { //busco por nombre en la lista
                                if (lista.isAlta()) {
                                    extra = lista; //si est?? de alta guarda el producto en extra
                                }
                            }
                        }
                    } else {
                        System.out.println("No hay productos cargados");
                    }
                    break;
                case 4:
                    if (!this.roturas.isEmpty()) {
                        for (Rotura lista : roturas) {
                            if (lista.getNombre().compareTo(nombre) == 0) { //busco por nombre en la lista
                                if (lista.isAlta()) {
                                    extra = lista; //si est?? de alta guarda el producto en extra
                                }
                            }
                        }
                    } else {
                        System.out.println("No hay roturas cargadas");
                    }
                    break;
                default:
                    System.out.println("Opci??n incorrecta, intente nuevamente");
                    break;
            }
            if (extra != null) { //si encontr?? el extra buscado
                int i = 0;
                while (i < cantidad) { //lo carga tantas veces como cantidad se haya indicado
                    hotel.buscarOcupacionPorHabitacion(nroHabitacion).getExtras().add(extra); //dentro de la lista de extras de la ocupaci??n, seg??n el nro de habitaci??n
                    i++;
                }
            }else{
                System.out.println("No se encontr?? el extra indicado. Ingrese nuevamente");
            }

            System.out.println("Desea seguir cargando? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

    } else if(!habEncontrada &&!ocupacionEncontrada)

    {
        System.out.println("Ocupaci??n y habitaci??n inexistentes");
    } else if(ocupacionEncontrada)

    {
        System.out.println("Habitaci??n inexistente");
    } else

    {
        System.out.println("Ocupaci??n inexistente");
    }


}

    //ELIMINAR UN EXTRA CARGADO EN UNA HABITACION (EJ: SE CARG?? EN UNA HAB POR ERROR - SE CARG?? MAL EL EXTRA)
    public void eliminarExtraHabitacion(Hotel hotel) {
        Scanner scanner = new Scanner(System.in);
        String nombre;
        boolean habEncontrada = false;
        boolean ocupacionEncontrada = false;
        int nroHab=0;
        do{

            try{
                System.out.println("Ingrese el n??mero de habitaci??n");
                nroHab = scanner.nextInt();
                scanner.nextLine();
            }catch (InputMismatchException e) {
                System.out.println("Debe ingresar un n??mero");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Problema detectado");
                scanner.nextLine();
            }
        } while (nroHab == 0);

        habEncontrada = hotel.verificarHabitacionExistente(nroHab);

        if (habEncontrada) { //si existe la hab verifico que haya ocupaci??n
            ocupacionEncontrada = hotel.verificarOcupacionExistente(nroHab);
        }

        if (habEncontrada && ocupacionEncontrada) {

            hotel.buscarOcupacionPorHabitacion(nroHab).getExtras().toString();
            System.out.println("\nIngrese el nombre del extra");
            nombre = scanner.nextLine();

            if (hotel.buscarOcupacionPorHabitacion(nroHab).getExtras() != null) {
                boolean encontrado = false;
                for (Extra lista : hotel.buscarOcupacionPorHabitacion(nroHab).getExtras()) { //busca el extra en la lista de la ocupaci??n
                    if (!encontrado && lista.getNombre().equalsIgnoreCase(nombre)) { //busca por nombre
                        hotel.buscarOcupacionPorHabitacion(nroHab).getExtras().remove(lista); //lo elimina de la lista
                        encontrado = true; //se pone un booleano para no eliminar + de un extra id??ntico
                    }
                }
            } else {
                System.out.println("No hay extras cargados en esta habitaci??n");
            }
        } else if (!habEncontrada && !ocupacionEncontrada) {
            System.out.println("Ocupaci??n y habitaci??n inexistentes");
        } else if (ocupacionEncontrada) {
            System.out.println("Habitaci??n inexistente");
        } else {
            System.out.println("Ocupaci??n inexistente");
        }

    }

    // CARGAR UN NUEVO EXTRA
    public void nuevoExtra() {
        Scanner scanner = new Scanner(System.in);
        String nombre;


        String continuar = "s";

        do {
            int opcion=0;
            do{
                try{
                    System.out.println("Qu?? tipo de extra desea cargar?");
                    opcionesExtras(); //ve la lista de tipos de extra
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                }catch (InputMismatchException e) {
                    System.out.println("Debe ingresar un n??mero");
                    scanner.nextLine();
                } catch (Exception e) {
                    System.out.println("Problema detectado");
                    scanner.nextLine();
                }
            } while (opcion == 0);
            
            System.out.println("Ingrese el nombre del extra"); //se pide aqu?? el nombre y precio ya que todos los extras
            nombre = scanner.nextLine();//lo comparten

            double precio=0.0;
            do{
                try{
                    System.out.println("Ingrese el precio");
                    precio = scanner.nextDouble();
                    scanner.nextLine();
                }catch (InputMismatchException e) {
                    System.out.println("Debe ingresar un n??mero");
                    scanner.nextLine();
                } catch (Exception e) {
                    System.out.println("Problema detectado");
                    scanner.nextLine();
                }
            }while (precio==0.0);

            switch (opcion) {  //seg??n el tipo son distintos los dem??s datos
                case 1:
                    String empleado;
                    System.out.println("Qu?? empleado lo realiza?");
                    empleado = scanner.nextLine();
                    Servicio servicio = new Servicio(nombre, precio, empleado); //se genera el nuevo extra
                    this.servicios.add(servicio);  //se carga a la lista correspondiente
                    System.out.println("\nSe carg?? exitosamente el siguiente servicio: ");
                    System.out.println(servicio.mostrarExtra());//lo muestro
                    break;
                case 2:
                    String descripcion, horario;
                    System.out.println("Escriba una breve descripci??n del servicio");
                    descripcion = scanner.nextLine();
                    System.out.println("Escriba en qu?? horario se encuentra disponible");
                    horario = scanner.nextLine();
                    Amenitie amenitie = new Amenitie(nombre, precio, descripcion, horario); //se genera el nuevo extra
                    this.amenities.add(amenitie); //se carga a la lista correspondiente
                    System.out.println("\nSe carg?? exitosamente la siguiente amenitie: ");
                    System.out.println(amenitie.mostrarExtra()); //lo muestro
                    break;
                case 3:
                    String marca;
                    System.out.println("Escriba la marca del producto");
                    marca = scanner.nextLine();
                    ProductoMinibar producto = new ProductoMinibar(nombre, precio, marca); //se genera el nuevo extra
                    this.minibar.add(producto); //se carga a la lista correspondiente
                    System.out.println("\nSe carg?? exitosamente el siguiente producto: ");
                    System.out.println(producto.mostrarExtra()); //lo muestro
                    break;
                case 4:
                    String causa;
                    System.out.println("Escriba la causa de la rotura");
                    causa = scanner.nextLine();
                    Rotura rotura = new Rotura(nombre, precio, causa); //se genera el nuevo extra
                    this.roturas.add(rotura); //se carga a la lista correspondiente
                    System.out.println("\nSe carg?? exitosamente la siguiente rotura: ");
                    System.out.println(rotura.mostrarExtra()); //lo muestro
                    break;
                default:
                    System.out.println("La opci??n ingresada es incorrecta. Ingrese nuevamente");
                    break;
            }

            System.out.println("Desea cargar otro extra? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

    }

    //DAR DE BAJA UN EXTRA MOMENTANEAMENTE (EJ: FALTA DE STOCK - FALTA DE ALG??N EMPLEADO, ETC)
    public void bajaExtra() {
        Scanner scanner = new Scanner(System.in);
        String nombre;

        String continuar = "s";
        boolean encontrado = false;

        do {
            int opcion=0;
            do{
                try{
                    System.out.println("Qu?? tipo de extra desea dar de baja?");
                    opcionesExtras(); //solicito el tipo de extra para buscar solo en la lista correspondiente
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                }catch (InputMismatchException e) {
                    System.out.println("Debe ingresar un n??mero");
                    scanner.nextLine();
                } catch (Exception e) {
                    System.out.println("Problema detectado");
                    scanner.nextLine();
                }
            } while (opcion == 0);

            System.out.println("Ingrese el nombre del extra"); //busco por nombre
            nombre = scanner.nextLine();
            int i = 0;

            switch (opcion) {
                case 1:
                    if (!this.servicios.isEmpty()) {
                        while (!encontrado && i < servicios.size()) {
                            if (servicios.get(i).getNombre().equalsIgnoreCase(nombre)) {
                                servicios.get(i).setAlta(false); //cuando lo encuentra, lo da de baja
                                encontrado = true;

                            }
                            i++;
                        }
                    }
                    break;
                case 2:
                    if (!this.amenities.isEmpty()) {
                        while (!encontrado && i < amenities.size()) {
                            if (amenities.get(i).getNombre().equalsIgnoreCase(nombre)) {
                                amenities.get(i).setAlta(false); //cuando lo encuentra, lo da de baja
                                encontrado = true;

                            }
                            i++;
                        }
                    }
                    break;
                case 3:
                    if (!this.minibar.isEmpty()) {
                        while (!encontrado && i < minibar.size()) {
                            if (minibar.get(i).getNombre().equalsIgnoreCase(nombre)) {
                                minibar.get(i).setAlta(false); //cuando lo encuentra, lo da de baja
                                encontrado = true;

                            }
                            i++;
                        }
                    }
                    break;

                case 4:
                    if (!this.roturas.isEmpty()) {
                        while (!encontrado && i < roturas.size()) {
                            if (roturas.get(i).getNombre().equalsIgnoreCase(nombre)) {
                                roturas.get(i).setAlta(false); //cuando lo encuentra, lo da de baja
                                encontrado = true;

                            }
                            i++;
                        }
                    }
                    break;
                default:
                    System.out.println("La opci??n ingresada es incorrecta. Ingrese nuevamente");
                    break;
            }
            if (encontrado) {
                System.out.println("El extra fue dado de baja correctamente");
            } else {
                System.out.println("No se encontraron coincidencias con el nombre indicado");
            }
            scanner.nextLine();
            System.out.println("Desea dar de baja otro extra? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));
    }

    //ELIMINAR EXTRA YA CARGADO
    public void eliminarExtra() {
        Scanner scanner = new Scanner(System.in);
        String nombre;
        String continuar = "s";
        boolean encontrado = false;

        do {
            int opcion=0;
            do{
                try{
                    System.out.println("Qu?? tipo de extra desea eliminar?");
                    opcionesExtras(); //solicito el tipo para buscar en la lista correspondiente
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                }catch (InputMismatchException e) {
                    System.out.println("Debe ingresar un n??mero");
                    scanner.nextLine();
                } catch (Exception e) {
                    System.out.println("Problema detectado");
                    scanner.nextLine();
                }
            } while (opcion == 0);
            System.out.println("Ingrese el nombre del extra"); //busco por nombre
            nombre = scanner.nextLine();
            int i = 0;

            switch (opcion) {
                case 1:
                    if (!this.servicios.isEmpty()) {
                        while (!encontrado && i < servicios.size()) {
                            if (servicios.get(i).getNombre().equalsIgnoreCase(nombre)) {
                                servicios.remove(servicios.get(i)); //cuando lo encuentro se elimina de la lista
                                encontrado = true;

                            }
                            i++;
                        }
                    }
                    break;
                case 2:
                    if (!this.amenities.isEmpty()) {
                        while (!encontrado && i < amenities.size()) {
                            if (amenities.get(i).getNombre().equalsIgnoreCase(nombre)) {
                                amenities.remove(amenities.get(i)); //cuando lo encuentro se elimina de la lista
                                encontrado = true;

                            }
                            i++;
                        }
                    }
                    break;
                case 3:
                    if (!this.minibar.isEmpty()) {
                        while (!encontrado && i < minibar.size()) {
                            if (minibar.get(i).getNombre().equalsIgnoreCase(nombre)) {
                                minibar.remove(minibar.get(i)); //cuando lo encuentro se elimina de la lista
                                encontrado = true;

                            }
                            i++;
                        }
                    }
                    break;

                case 4:
                    if (!this.roturas.isEmpty()) {
                        while (!encontrado && i < roturas.size()) {
                            if (roturas.get(i).getNombre().equalsIgnoreCase(nombre)) {
                                roturas.remove(roturas.get(i)); //cuando lo encuentro se elimina de la lista
                                encontrado = true;

                            }
                            i++;
                        }
                    }
                    break;
                default:
                    System.out.println("La opci??n ingresada es incorrecta. Ingrese nuevamente");
                    break;
            }
            if (encontrado) {
                System.out.println("El extra fue eliminado correctamente");
            } else {
                System.out.println("No se encontraron coincidencias con el nombre indicado");
            }
            scanner.nextLine();
            System.out.println("Desea eliminar otro extra? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));


    }

    public void opcionesModificarExtra() {
        System.out.println("Qu?? desea modificar: ");
        System.out.println("1- Nombre");
        System.out.println("2- Precio");
    }

    //MODIFICAR DATOS DE EXTRAS YA CREADOS
    public void modificarExtra() {
        Scanner scanner = new Scanner(System.in);
        String nombre;
        String continuar = "n";
        boolean encontrado = false;

        do {
            int opcion=0;
            do{
                try{
                    System.out.println("Qu?? tipo de extra desea modificar?");
                    opcionesExtras(); //solicito tipo para buscar en la lista correspondiente
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                }catch (InputMismatchException e) {
                    System.out.println("Debe ingresar un n??mero");
                    scanner.nextLine();
                } catch (Exception e) {
                    System.out.println("Problema detectado");
                    scanner.nextLine();
                }
            } while (opcion == 0);

            System.out.println("Ingrese el nombre del extra"); //busco por nombre
            nombre = scanner.nextLine();
            int i = 0;
            switch (opcion) {
                case 1:
                    if (!this.servicios.isEmpty()) {
                        while (!encontrado && i < servicios.size()) {
                            if (servicios.get(i).getNombre().compareTo(nombre) == 0) {
                                do { //seg??n el tipo, se puden modificar distintos atributos
                                    int opcion1=0;
                                    do{
                                       try{
                                           System.out.println(servicios.get(i).mostrarExtra());
                                           opcionesModificarExtra();
                                           System.out.println("3- Empleado a cargo");
                                           opcion1 = scanner.nextInt();
                                           scanner.nextLine();
                                           servicios.get(i).modificarExtra(servicios.get(i), opcion1);
                                           encontrado = true;
                                           System.out.println("El extra fue modificado correctamente");
                                       }catch (InputMismatchException e) {
                                           System.out.println("Debe ingresar un n??mero");
                                           scanner.nextLine();
                                       } catch (Exception e) {
                                           System.out.println("Problema detectado");
                                           scanner.nextLine();
                                       }
                                   } while (opcion1 == 0);

                                    System.out.println("Desea hacer otra modificaci??n sobre este producto? s/n");
                                    continuar = scanner.nextLine();
                                } while (continuar.equalsIgnoreCase("s"));
                            }
                            i++;
                        }
                        if (!encontrado) {
                            System.out.println("No se encontraron coincidencias con el nombre indicado");
                        }

                    }
                    break;
                case 2:
                    if (!this.amenities.isEmpty()) {
                        while (!encontrado && i < amenities.size()) {
                            if (amenities.get(i).getNombre().compareTo(nombre) == 0) {
                                do { //seg??n el tipo, se puden modificar distintos atributos
                                    int opcion2=0;
                                    do{
                                        try{
                                            System.out.println(amenities.get(i).mostrarExtra());
                                            opcionesModificarExtra();
                                            System.out.println("3- Descripci??n");
                                            System.out.println("4- Horario");
                                            opcion2 = scanner.nextInt();
                                            scanner.nextLine();
                                            amenities.get(i).modificarExtra(amenities.get(i), opcion2);
                                            encontrado = true;
                                            System.out.println("El extra fue modificado correctamente");
                                        }catch (InputMismatchException e) {
                                            System.out.println("Debe ingresar un n??mero");
                                            scanner.nextLine();
                                        } catch (Exception e) {
                                            System.out.println("Problema detectado");
                                            scanner.nextLine();
                                        }
                                    } while (opcion2 == 0);

                                    System.out.println("Desea hacer otra modificaci??n sobre este producto? s/n");
                                    continuar = scanner.nextLine();
                                } while (continuar.equalsIgnoreCase("s"));

                            }
                            i++;
                        }
                        if (!encontrado) {
                            System.out.println("No se encontraron coincidencias con el nombre indicado");
                        }
                    }
                    break;
                case 3:
                    if (!this.minibar.isEmpty()) {
                        while (!encontrado && i < minibar.size()) {
                            if (minibar.get(i).getNombre().compareTo(nombre) == 0) {
                                do { //seg??n el tipo, se puden modificar distintos atributos
                                    int opcion3=0;
                                    do{
                                        try{
                                            System.out.println(minibar.get(i).mostrarExtra());
                                            opcionesModificarExtra();
                                            System.out.println("3- Marca");
                                            opcion3 = scanner.nextInt();
                                            scanner.nextLine();
                                            minibar.get(i).modificarExtra(minibar.get(i), opcion3);
                                            encontrado = true;
                                            System.out.println("El extra fue modificado correctamente");
                                        }catch (InputMismatchException e) {
                                            System.out.println("Debe ingresar un n??mero");
                                            scanner.nextLine();
                                        } catch (Exception e) {
                                            System.out.println("Problema detectado");
                                            scanner.nextLine();
                                        }
                                    } while (opcion3 == 0);

                                    System.out.println("Desea hacer otra modificaci??n sobre este producto? s/n");
                                    continuar = scanner.nextLine();

                                } while (continuar.equalsIgnoreCase("s"));
                            }
                            i++;
                        }
                        if (!encontrado) {
                            System.out.println("No se encontraron coincidencias con el nombre indicado");
                        }
                    }
                    break;
                case 4:
                    if (!this.roturas.isEmpty()) {
                        while (!encontrado && i < roturas.size()) {
                            if (roturas.get(i).getNombre().compareTo(nombre) == 0) {
                                do { //seg??n el tipo, se puden modificar distintos atributos
                                    int opcion4=0;
                                    do{
                                        try{
                                            System.out.println(roturas.get(i).mostrarExtra());
                                            opcionesModificarExtra();
                                            System.out.println("3- Causa");
                                            opcion4 = scanner.nextInt();
                                            roturas.get(i).modificarExtra(roturas.get(i), opcion4);
                                            scanner.nextLine();
                                            encontrado = true;
                                            System.out.println("El extra fue modificado correctamente");
                                        }catch (InputMismatchException e) {
                                            System.out.println("Debe ingresar un n??mero");
                                            scanner.nextLine();
                                        } catch (Exception e) {
                                            System.out.println("Problema detectado");
                                            scanner.nextLine();
                                        }
                                    } while (opcion4 == 0);

                                    System.out.println("Desea hacer otra modificaci??n sobre este producto? s/n");
                                    continuar = scanner.nextLine();
                                } while (continuar.equalsIgnoreCase("s"));
                            }
                            i++;
                        }
                        if (!encontrado) {
                            System.out.println("No se encontraron coincidencias con el nombre indicado");
                        }
                    }
                    break;
                default:
                    System.out.println("La opci??n ingresada es incorrecta. Ingrese nuevamente");
                    break;
            }
            System.out.println("Desea modificar otro extra? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));
    }

    //DAR DE ALTA EXTRA QUE SE DIO DE BAJA EN ALGUN MOMENTO (EJ: POR FALTA DE STOCK)
    public void altaExtra() {
        Scanner scanner = new Scanner(System.in);
        String nombre;

        String continuar = "s";
        boolean encontrado = false;

        do {
            int opcion=0;
            do{
                try{
                    System.out.println("Qu?? tipo de extra desea dar de alta?");
                    opcionesExtras(); //solicito tipo para buscar solo en esa lista
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                }catch (InputMismatchException e) {
                    System.out.println("Debe ingresar un n??mero");
                    scanner.nextLine();
                } catch (Exception e) {
                    System.out.println("Problema detectado");
                    scanner.nextLine();
                }
            } while (opcion == 0);

            System.out.println("Ingrese el nombre del extra"); //busco por nombre
            nombre = scanner.nextLine();
            int i = 0;

            switch (opcion) {
                case 1:
                    if (!this.servicios.isEmpty()) {
                        while (!encontrado && i < servicios.size()) {
                            if (servicios.get(i).getNombre().equalsIgnoreCase(nombre)) {
                                servicios.get(i).setAlta(true); //cuando lo encuentro lo doy de alta
                                encontrado = true;

                            }
                            i++;
                        }
                    }
                    break;
                case 2:
                    if (!this.amenities.isEmpty()) {
                        while (!encontrado && i < amenities.size()) {
                            if (amenities.get(i).getNombre().equalsIgnoreCase(nombre)) {
                                amenities.get(i).setAlta(true); //cuando lo encuentro lo doy de alta
                                encontrado = true;

                            }
                            i++;
                        }
                    }
                    break;
                case 3:
                    if (!this.minibar.isEmpty()) {
                        while (!encontrado && i < minibar.size()) {
                            if (minibar.get(i).getNombre().equalsIgnoreCase(nombre)) {
                                minibar.get(i).setAlta(true); //cuando lo encuentro lo doy de alta
                                encontrado = true;

                            }
                            i++;
                        }
                    }
                    break;

                case 4:
                    if (!this.roturas.isEmpty()) {
                        while (!encontrado && i < roturas.size()) {
                            if (roturas.get(i).getNombre().equalsIgnoreCase(nombre)) {
                                roturas.get(i).setAlta(true); //cuando lo encuentro lo doy de alta
                                encontrado = true;

                            }
                            i++;
                        }
                    }
                    break;
                default:
                    System.out.println("La opci??n ingresada es incorrecta. Ingrese nuevamente");
                    break;
            }
            if (encontrado) {
                System.out.println("El extra fue dado de alta correctamente");
            } else {
                System.out.println("No se encontraron coincidencias con el nombre indicado");
            }
            scanner.nextLine();
            System.out.println("Desea dar de alta otro extra? s/n");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));
    }
}