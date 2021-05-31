package com.Hotel;

import java.time.LocalDate;

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
    // private List<Reservas> listaDeReservas;
    // private List<Hospedaje> listaHospedajeAnterior;



    //constructores

    public Pasajero (){ this.id= identificador++;  }  /// asignar un id??


    public Pasajero(String nombre, String apellido, String dni,
                    LocalDate fechaNacimiento, String profesion_ocupacion,
                    String nacionalidad, String calle, Integer numero,
                    Integer piso, String departamento, String ciudad, String provincia,
                    String pais, String mail, Boolean titularreserva) {

        super (nombre, apellido);
        this.id= identificador++;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.profesion_ocupacion = profesion_ocupacion;
        this.nacionalidad = nacionalidad;
        this.calle = calle;
        this.numero = numero;
        this.piso = piso;
        this.ciudad= ciudad;
        this.departamento = departamento;
        this.provincia = provincia;
        this.pais = pais;
        this.mail = mail;
        this.titularReserva = titularreserva;
    }

    //getters y setters

    public String getDni() {  return dni;    }

    public void setDni(String dni) {    this.dni = dni;    }

    public LocalDate getFechaNacimiento() {    return fechaNacimiento;  }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {        this.fechaNacimiento = fechaNacimiento;   }

    public String getProfesion_ocupacion() {    return profesion_ocupacion;   }

    public void setProfesion_ocupacion(String profesion_ocupacion) {   this.profesion_ocupacion = profesion_ocupacion;    }

    public String getNacionalidad() {   return nacionalidad;   }

    public void setNacionalidad(String nacionalidad) {        this.nacionalidad = nacionalidad;   }

    public String getCalle() {   return calle;   }

    public void setCalle(String calle) {  this.calle = calle;   }

    public Integer getNumero() {   return numero;   }

    public void setNumero(Integer numero) {  this.numero = numero;  }

    public Integer getPiso() { return piso; }

    public void setPiso(Integer piso) {   this.piso = piso;  }

    public String getDepartamento() {   return departamento;  }

    public void setDepartamento(String departamento) {  this.departamento = departamento;   }

    public String getProvincia() {   return provincia;  }

    public void setProvincia(String provincia) {   this.provincia = provincia;   }

    public String getPais() {    return pais;   }

    public void setPais(String pais) {   this.pais = pais;  }

    public String getMail() {    return mail; }

    public void setMail(String mail) {  this.mail = mail;  }

    public Boolean getTitularreserva() {   return titularReserva;  }

    public void setTitularreserva(Boolean titularreserva) {   this.titularReserva = titularreserva;   }

    public Integer getId() {   return id; }

    public String getCiudad() {      return ciudad;    }

    public void setCiudad(String ciudad) {        this.ciudad = ciudad;    }

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
                '}';



    }

}
