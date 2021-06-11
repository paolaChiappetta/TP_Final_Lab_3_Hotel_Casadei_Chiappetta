package com.Hotel;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Pasajero extends Persona implements Serializable {


    private static int identificador = 0;     /// variable static para id

    private LocalDate fechaNacimiento;
    private String profesion_ocupacion;
    private String nacionalidad;
    private String calle;
    private Integer numero;
    private Integer piso;
    private String departamento;
    private String ciudad;
    private String provincia;
    private String pais;
    private String mail;
    private Integer id;
    private Boolean titularReserva;
    private List<Reserva>ocupacionesAnteriores;


    //constructor vacío con asignación de ID

    public Pasajero() {
        this.id = identificador++;
        this.ocupacionesAnteriores=new ArrayList<>();
    }

    //constructor con datos y asignación de ID

    public Pasajero(String nombre, String apellido, String numeroTel, String dni,
                    LocalDate fechaNacimiento, String profesion_ocupacion,
                    String nacionalidad, String calle, Integer numero,
                    Integer piso, String departamento, String ciudad, String provincia,
                    String pais, String mail, Boolean titularreserva) {

        super(nombre, apellido, numeroTel, dni);
        this.id = identificador++;
        this.fechaNacimiento = fechaNacimiento;
        this.profesion_ocupacion = profesion_ocupacion;
        this.nacionalidad = nacionalidad;
        this.calle = calle;
        this.numero = numero;
        this.piso = piso;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.provincia = provincia;
        this.pais = pais;
        this.mail = mail;
        this.titularReserva = titularreserva;
        this.ocupacionesAnteriores=new ArrayList<>();
    }

    //constructor completo
    public Pasajero(String nombre, String apellido, String numeroTel, String dni,
                    LocalDate fechaNacimiento, String profesion_ocupacion,
                    String nacionalidad, String calle, Integer numero,
                    Integer piso, String departamento, String ciudad, String provincia,
                    String pais, String mail, Integer id, Boolean titularreserva,
                    List<Reserva>ocupacionesAnteriores) {

        super(nombre, apellido, numeroTel, dni);
        this.id = id;
        this.fechaNacimiento = fechaNacimiento;
        this.profesion_ocupacion = profesion_ocupacion;
        this.nacionalidad = nacionalidad;
        this.calle = calle;
        this.numero = numero;
        this.piso = piso;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.provincia = provincia;
        this.pais = pais;
        this.mail = mail;
        this.titularReserva = titularreserva;
        this.ocupacionesAnteriores=ocupacionesAnteriores;
    }

    //getters y setters

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getProfesion_ocupacion() {
        return profesion_ocupacion;
    }

    public void setProfesion_ocupacion(String profesion_ocupacion) {
        this.profesion_ocupacion = profesion_ocupacion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getPiso() {
        return piso;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Boolean getTitularreserva() {
        return titularReserva;
    }

    public void setTitularreserva(Boolean titularreserva) {
        this.titularReserva = titularreserva;
    }

    public Integer getId() {
        return id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

   public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getTitularReserva() {
        return titularReserva;
    }

    public void setTitularReserva(Boolean titularReserva) {
        this.titularReserva = titularReserva;
    }

    public List<Reserva> getOcupacionesAnteriores() {
        return ocupacionesAnteriores;
    }

    public void setOcupacionesAnteriores(List<Reserva> ocupacionesAnteriores) {
        this.ocupacionesAnteriores = ocupacionesAnteriores;
    }

    public void examinaDatosCompletos(String dato) throws ExcepcionDatoVacio {

        if (dato.compareTo("") == 0) {                                   //COMPARA EL DATO RECIBIDO POR PARAMETRO CON ""
            throw new ExcepcionDatoVacio("El dato no está completo");

        }
    }

    //FUNCION CARGA DE PASAJERO, pide datos devuelve pasajero

    public Pasajero cargarPasajeroTitular(Reserva reserva, List<Pasajero>pasajeros) {

        Scanner scanner = new Scanner(System.in);

        this.setNombre(reserva.getPasajeroNombre());
        this.setApellido(reserva.getPasajeroApellido());
        this.setDni(reserva.getPasajeroDni());
        this.setNumeroTel(reserva.getTelefono());

        LocalDate nacimiento;
        do{
            try{
                System.out.println("Fecha de nacimiento (AAAA-MM-DD):");
                nacimiento=LocalDate.parse(scanner.nextLine());
            }catch (DateTimeParseException e) {
                System.out.println("\nIngrese la fecha nuevamente en el formato indicado");
                nacimiento = null;
            } catch (Exception e) {
                System.out.println("\nIngrese la fecha nuevamente");
                nacimiento = null;
            }
        } while (nacimiento == null);
        this.setFechaNacimiento(nacimiento);

        System.out.println("Indique la profesion u ocupacion:");
        this.setProfesion_ocupacion(scanner.nextLine());

        String nacionalidad="";
        do {
            try {
                System.out.println("Nacionalidad:");
                nacionalidad=scanner.nextLine();
                examinaDatosCompletos(nacionalidad);
            } catch (ExcepcionDatoVacio e) {
                System.out.println("Este dato debe ser cargado");

            } catch (Exception e) {
                System.out.println("No se ha podido registrar");
            }
        } while (nacionalidad.compareTo("") == 0);
        this.setNacionalidad(nacionalidad);

        String calle="";
        do {
            try {
                System.out.println("Indique la Calle:");
                calle=scanner.nextLine();
                examinaDatosCompletos(calle);
            } catch (ExcepcionDatoVacio e) {
                System.out.println("Este dato debe ser cargado");

            } catch (Exception e) {
                System.out.println("No se ha podido registrar");
            }
        } while (calle.compareTo("") == 0);
        this.setCalle(calle);

        int numero=0;
        do{
            try{
                System.out.println("Numero:");
                numero=scanner.nextInt();
                scanner.nextLine();
            }catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Problema detectado");
                scanner.nextLine();
            }
        } while (numero == 0);
        this.setNumero(numero);

        int piso=-1;
        do{
            try{
                System.out.println("Piso (si no es en un piso ingrese 0):");
               piso=scanner.nextInt();
                scanner.nextLine();
            }catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Problema detectado");
                scanner.nextLine();
            }
        } while (piso == -1);
        this.setPiso(piso);

        System.out.println("Departamento:");
        this.setDepartamento(scanner.nextLine());

        String ciudad="";
        do{
            try{
                System.out.println("Ciudad:");
                ciudad=scanner.nextLine();
                examinaDatosCompletos(ciudad);
            } catch (ExcepcionDatoVacio e) {
                System.out.println("Este dato debe ser cargado");

            } catch (Exception e) {
                System.out.println("No se ha podido registrar");
            }
        }while (ciudad.compareTo("") == 0);
        this.setCiudad(ciudad);

        System.out.println("Provincia:");
        this.setProvincia(scanner.nextLine());

        System.out.println("Pais:");
        this.setPais(scanner.nextLine());

        this.setTitularreserva(true);
        pasajeros.add(this);

        return this;
    }

    public Pasajero cargarPasajeroAcompaniante(List<Pasajero>pasajeros) {

        Scanner scanner = new Scanner(System.in);

        String nombre="";
        do{
            try{
                System.out.println("Nombre:");
                nombre=scanner.nextLine();
                examinaDatosCompletos(nombre);
            }catch (ExcepcionDatoVacio e) {
                System.out.println("Este dato debe ser cargado");

            } catch (Exception e) {
                System.out.println("No se ha podido registrar");
            }
        }while (nombre.compareTo("") == 0);
        this.setNombre(nombre);

        String apellido="";
        do{
            try{
                System.out.println("Apellido:");
                apellido=scanner.nextLine();
                examinaDatosCompletos(apellido);
            }catch (ExcepcionDatoVacio e) {
                System.out.println("Este dato debe ser cargado");

            } catch (Exception e) {
                System.out.println("No se ha podido registrar");
            }
        }while (apellido.compareTo("") == 0);
        this.setApellido(apellido);

        String telefono="";
        do{
            try{
                System.out.println("Telefono:");
               telefono=scanner.nextLine();
                examinaDatosCompletos(telefono);
            }catch (ExcepcionDatoVacio e) {
                System.out.println("Este dato debe ser cargado");

            } catch (Exception e) {
                System.out.println("No se ha podido registrar");
            }
        }while (telefono.compareTo("") == 0);
        this.setNumeroTel(telefono);

        this.setTitularreserva(false);
        pasajeros.add(this);

        return this;
    }

    //FUNCION MODIFICAR DATOS PASAJERO

    public void menuModificarPasajero() {

        System.out.println("1- Nombre");
        System.out.println("2- Apellido");
        System.out.println("3- Dni");
        System.out.println("4- Fecha de nacimiento");
        System.out.println("5- Profesion-ocupacion");
        System.out.println("6- Nacionalidad");
        System.out.println("7- Numero de telefono");
        System.out.println("8- Calle");
        System.out.println("9- Numero");
        System.out.println("10- Piso");
        System.out.println("11- Departamento");
        System.out.println("12- Ciudad");
        System.out.println("13- Provincia");
        System.out.println("14- Pais");
        System.out.println("15- Titular reserva");

        System.out.println("\n0 para finalizar");

    }


    public void modificarPasajero(Pasajero pasajero) {
       Scanner scanner = new Scanner(System.in);
       String continuar = "n";
        do {
            int opcion = 0;
            do{
                try{
                    System.out.println("Indique que datos desea modificar: ");
                    menuModificarPasajero();
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                }catch (InputMismatchException e) {
                    System.out.println("Debe ingresar un número");
                    scanner.nextLine();
                } catch (Exception e) {
                    System.out.println("Problema detectado");
                    scanner.nextLine();
                }
            } while (opcion == 0);

            switch (opcion) {
                case 1:
                    String nombre="";
                    do{
                        try{
                            System.out.println("Indique el Nombre:");
                            nombre=scanner.nextLine();
                            examinaDatosCompletos(nombre);
                        } catch (ExcepcionDatoVacio e) {
                            System.out.println("Este dato debe ser cargado");

                        } catch (Exception e) {
                            System.out.println("No se ha podido registrar");
                        }
                    } while (nombre.compareTo("") == 0);
                     this.setNombre(nombre);
                    break;
                case 2:
                    String apellido="";
                    do{
                        try{
                            System.out.println("Indique el Apellido:");
                            apellido=scanner.nextLine();
                            examinaDatosCompletos(apellido);
                        } catch (ExcepcionDatoVacio e) {
                            System.out.println("Este dato debe ser cargado");

                        } catch (Exception e) {
                            System.out.println("No se ha podido registrar");
                        }
                    } while (apellido.compareTo("") == 0);
                    this.setApellido(apellido);
                    break;
                case 3:
                    String dni="";
                    do{
                        try{
                            System.out.println("Indique el Dni:");
                            dni=scanner.nextLine();
                            examinaDatosCompletos(dni);
                        } catch (ExcepcionDatoVacio e) {
                            System.out.println("Este dato debe ser cargado");

                        } catch (Exception e) {
                            System.out.println("No se ha podido registrar");
                        }
                    } while (dni.compareTo("") == 0);
                    this.setDni(dni);
                    break;
                case 4:
                    LocalDate fecha=null;
                    do{
                        try{
                            System.out.println("Indique la fecha de nacimiento (AAAA-MM-DD):");
                            fecha=LocalDate.parse(scanner.nextLine());
                        }catch (DateTimeParseException e) {
                            System.out.println("\nIngrese la fecha nuevamente en el formato indicado");
                            fecha = null;
                        } catch (Exception e) {
                            System.out.println("\nIngrese la fecha nuevamente");
                            fecha = null;
                        }
                    } while (fecha == null);
                    this.setFechaNacimiento(fecha);
                    break;
                case 5:
                    System.out.println("Indique la profesion u ocupacion:");
                    this.setProfesion_ocupacion(scanner.nextLine());
                    break;
                case 6:
                    System.out.println("Indique la Nacionalidad:");
                    this.setNacionalidad(scanner.nextLine());
                    break;
                case 7:
                    String tel="";
                    do{
                        try{
                            System.out.println("Indique el Numero de telefono:");
                            tel=scanner.nextLine();
                            examinaDatosCompletos(tel);
                        } catch (ExcepcionDatoVacio e) {
                            System.out.println("Este dato debe ser cargado");

                        } catch (Exception e) {
                            System.out.println("No se ha podido registrar");
                        }
                    } while (tel.compareTo("") == 0);
                    this.setNumeroTel(tel);
                    break;
                case 8:
                    System.out.println("Indique la Calle:");
                    this.setCalle(scanner.nextLine());
                    break;
                case 9:
                    int num=0;
                    do{
                        try {
                            System.out.println("Indique el Numero:");
                            num=scanner.nextInt();
                            scanner.nextLine();
                        }catch (InputMismatchException e) {
                            System.out.println("Debe ingresar un número");
                            scanner.nextLine();
                        } catch (Exception e) {
                            System.out.println("Problema detectado");
                            scanner.nextLine();
                        }
                    }while (num==0);
                    this.setNumero(num);
                    break;
                case 10:
                    int piso=-1;
                    do{
                        try {
                            System.out.println("Indique el piso:");
                            piso=scanner.nextInt();
                            scanner.nextLine();
                        }catch (InputMismatchException e) {
                            System.out.println("Debe ingresar un número");
                            scanner.nextLine();
                        } catch (Exception e) {
                            System.out.println("Problema detectado");
                            scanner.nextLine();
                        }
                    }while (piso==-1);
                    this.setPiso(piso);
                    break;
                case 11:
                    System.out.println("Indique el departamento:");
                    this.setDepartamento(scanner.nextLine());
                    break;
                case 12:
                    System.out.println("Indique la Ciudad:");
                    this.setCiudad(scanner.nextLine());
                    break;
                case 13:
                    System.out.println("Indique la Provincia:");
                    this.setProvincia(scanner.nextLine());
                    break;
                case 14:
                    System.out.println("Indique el Pais:");
                    this.setPais(scanner.nextLine());
                    break;
                case 15:
                    int titular=0;
                    do{
                        try{
                            System.out.println("Es titular de reserva? \n1- Si\n2- No");
                            titular=scanner.nextInt();
                            scanner.nextLine();
                        }catch (InputMismatchException e) {
                            System.out.println("Debe ingresar un número");
                            scanner.nextLine();
                        } catch (Exception e) {
                            System.out.println("Problema detectado");
                            scanner.nextLine();
                        }
                    } while (titular!=1 && titular!=2);
                    if(titular==1){
                        this.setTitularreserva(true);
                    }else {
                        this.setTitularreserva(false);
                    }
                    break;
                default:
                    System.out.println("Opción incorrecta. Ingrese nuevamente");
                    break;
            }
            System.out.println("Desea modificar otro dato? s/n");
            continuar=scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));
    }


    @Override
    public String toString() {
        return "Pasajero ID " + this.id + "\n" + super.toString() +
                "\nFecha de nacimiento: "  + this.fechaNacimiento +
                "\nProfesión-ocupación: " + this.profesion_ocupacion +
                "\nDomicilio: " + this.calle + " " + this.numero + " " + this.piso + " " + this.departamento +
                "\nCiudad: " + this.ciudad +
                "\nProvincia: " + this.provincia +
                "\nNacionalidad: " + this.nacionalidad +
                "\nE-mail: " + this.mail;
    }

}