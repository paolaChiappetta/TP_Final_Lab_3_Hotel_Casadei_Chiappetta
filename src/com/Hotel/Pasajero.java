package com.Hotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Pasajero extends Persona {


    private static int identificador = 1;     /// variable static para id

    private String dni;
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
    private Integer id;                                     // o Long??   se asigna al generar un pasajero
    private Boolean titularReserva;
    private List<Reserva> listaDeReservas;
    private List<Ocupacion> listaOcupacionAnterior;


    //constructores

    public Pasajero() {
        this.id = identificador++;
    }  /// asignar un id??


    public Pasajero(String nombre, String apellido, String numeroTel, String dni,
                    LocalDate fechaNacimiento, String profesion_ocupacion,
                    String nacionalidad, String calle, Integer numero,
                    Integer piso, String departamento, String ciudad, String provincia,
                    String pais, String mail, Boolean titularreserva) {

        super(nombre, apellido, numeroTel);
        this.id = identificador++;
        this.dni = dni;
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

    }

    //getters y setters

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

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

    public List<Reserva> getListaDeReservas() {
        return listaDeReservas;
    }

    public void setListaDeReservas(List<Reserva> listaDeReservas) {
        this.listaDeReservas = listaDeReservas;
    }

    public List<Ocupacion> getListaOcupacionAnterior() {
        return listaOcupacionAnterior;
    }

    public void setListaOcupacionAnterior(List<Ocupacion> listaOcupacionAnterior) {
        this.listaOcupacionAnterior = listaOcupacionAnterior;
    }

    Scanner scanner = new Scanner(System.in);


    //FUNCION CARGA DE PASAJERO, pide datos devuelve pasajero

    public Pasajero cargarPasajero() {
        Pasajero pasajero = new Pasajero();


        System.out.println("Nombre:");
        pasajero.setNombre(scanner.next());
        System.out.println("Apellido:");
        pasajero.setApellido(scanner.next());
        System.out.println("Dni:");
        pasajero.setDni(scanner.next());
        System.out.println("Telefono:");
        pasajero.setNumeroTel(scanner.next());
        System.out.println("Fecha de nacimiento:");
        pasajero.setFechaNacimiento(LocalDate.parse(scanner.next(), DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println("Indique la profesion u ocupacion:");
        pasajero.setProfesion_ocupacion(scanner.next());
        System.out.println("Nacionalidad:");
        pasajero.setNacionalidad(scanner.next());
        System.out.println("Indique la Calle:");
        pasajero.setCalle(scanner.next());
        System.out.println("Numero:");
        pasajero.setNumero(scanner.nextInt());
        System.out.println("Piso:");
        pasajero.setPiso(scanner.nextInt());
        System.out.println("Departamento:");
        pasajero.setDepartamento(scanner.next());
        System.out.println("Ciudad:");
        pasajero.setCiudad(scanner.next());
        System.out.println("Provincia:");
        pasajero.setProvincia(scanner.next());
        System.out.println("Pais:");
        pasajero.setPais(scanner.next());
        System.out.println("Es titular de reserva? si: 1  / no: 0  ");
        pasajero.setTitularreserva(scanner.nextBoolean());

        return pasajero;
    }


    //FUNCION MODIFICAR DATOS PASAJERO

    public void menuModificarPasajero() {

        System.out.println("1: Nombre");
        System.out.println("2: Apellido");
        System.out.println("3: Dni");
        System.out.println("4: Fecha de nacimiento");
        System.out.println("5: Profesion-ocupacion");
        System.out.println("6: Nacionalidad");
        System.out.println("7: Numero de telefono");
        System.out.println("8: Calle");
        System.out.println("9: Numero");
        System.out.println("10: Piso");
        System.out.println("11: Departamento");
        System.out.println("12: Ciudad");
        System.out.println("13: Provincia");
        System.out.println("14: Pais");
        System.out.println("15: Titular reserva");

        System.out.println("\n0 para finalizar");

    }


    public void modificarPasajero(Pasajero pasajero) {

        System.out.println("Indique que datos desea modificar: ");
        int opcion = 0;


        do {
            menuModificarPasajero();
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Indique el Nombre:");
                    this.setNombre(scanner.next());
                    break;
                case 2:
                    System.out.println("Indique el Apellido:");
                    this.setApellido(scanner.next());
                    break;
                case 3:
                    System.out.println("Indique el Dni:");
                    this.setDni(scanner.next());
                    break;
                case 4:
                    System.out.println("Indique la fecha de nacimiento:");
                    this.setFechaNacimiento(LocalDate.parse(scanner.next(), DateTimeFormatter.BASIC_ISO_DATE));
                    break;
                case 5:
                    System.out.println("Indique la profesion u ocupacion:");
                    this.setProfesion_ocupacion(scanner.next());
                    break;
                case 6:
                    System.out.println("Indique la Nacionalidad:");
                    this.setNacionalidad(scanner.next());
                    break;
                case 7:
                    System.out.println("Indique el Numero de telefono:");
                    this.setNumeroTel(scanner.next());
                    break;
                case 8:
                    System.out.println("Indique la Calle:");
                    this.setCalle(scanner.next());
                    break;
                case 9:
                    System.out.println("Indique el Numero:");
                    this.setNumero(scanner.nextInt());
                    break;
                case 10:
                    System.out.println("Indique el piso:");
                    this.setPiso(scanner.nextInt());
                    break;
                case 11:
                    System.out.println("Indique el departamento:");
                    this.setDepartamento(scanner.next());
                    break;
                case 12:
                    System.out.println("Indique la Ciudad:");
                    this.setCiudad(scanner.next());
                    break;
                case 13:
                    System.out.println("Indique la Provincia:");
                    this.setProvincia(scanner.next());
                    break;
                case 14:
                    System.out.println("Indique el Pais:");
                    this.setPais(scanner.next());
                    break;
                case 15:
                    System.out.println("Es titular de reserva? si: 1  / no: 0  ");
                    this.setTitularreserva(scanner.nextBoolean());
                    break;
                default:
                    System.out.println("Opcion incorrecta, ingrese nuevamente");
                    break;
            }
        } while (opcion != 0);
    }

    public void buscarPasajeroDni(List<Pasajero> listaPasajeros) {
        //Pasajero pasajero= new Pasajero();
        int encontrado = 0;
        System.out.println("Indique Dni:");
        String dni = scanner.next();

        for (Pasajero pasajero : listaPasajeros) {

            if (pasajero.dni.compareTo(dni) == 0) {
                System.out.println("Datos pasajero: ");
                System.out.println(pasajero);
                System.out.println("Desea modificar datos 1=si  /  0= no " );
                int mod= scanner.nextInt();
                if (mod == 1) {
                    modificarPasajero(pasajero);
                }else{
                    System.out.println("Es el pasajero titular de reserva?  si=1 / no= 0 ");
                    pasajero.titularReserva= scanner.nextBoolean();

                }
            }else{
                listaPasajeros.add(cargarPasajero());
            }
        }

    }


    @Override
    public String toString() {
        return "Pasajero{" + super.toString() +
                "dni='" + dni + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", profesion_ocupacion='" + profesion_ocupacion + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", calle='" + calle + '\'' +
                ", numero=" + numero +
                ", piso=" + piso +
                ", departamento='" + departamento + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", provincia='" + provincia + '\'' +
                ", pais='" + pais + '\'' +
                ", mail='" + mail + '\'' +
                ", id=" + id +
                ", titularReserva=" + titularReserva +
                ", scanner=" + scanner +
                '}';


    }

}