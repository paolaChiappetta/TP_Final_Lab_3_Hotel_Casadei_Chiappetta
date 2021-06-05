package com.Hotel;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Factura {
    //ATRIBUTOS

    private static int idFactura = 0;

    private int numeroFactura;
    private LocalDate fechaEmision;
    private TipoFactura tipoFactura;
    private Ocupacion ocupacion;

    //CONSTRUCTORES
    public Factura() {
        this.numeroFactura = idFactura + 1;
    }

    public Factura(TipoFactura tipoFactura, Ocupacion ocupacion) {
        this.fechaEmision = LocalDate.now();
        this.tipoFactura = tipoFactura;
        this.ocupacion = ocupacion;
        this.numeroFactura = idFactura + 1;

    }

    //GETTERS Y SETTERS
    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public TipoFactura getTipoFactura() {
        return tipoFactura;
    }

    public void setTipoFactura(TipoFactura tipoFactura) {
        this.tipoFactura = tipoFactura;
    }

    public Ocupacion getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(Ocupacion ocupacion) {
        this.ocupacion = ocupacion;
    }

    //MÉTODOS DE CALCULOS PARA IMPRIMIR EN LA FACTURA

    //CANTIDAD DE NOCHES DE ALOJAMIENTO
    public Long calculoCantidadNoches() {
        return ChronoUnit.DAYS.between(this.ocupacion.getFechaIngreso(), this.ocupacion.getFechaSalida());

    }

    //CALCULA LA CANTIDAD DE NOCHES x LA TARIFA DE LA HABITACION
    public Double calculoAlojamiento() {
        return this.calculoCantidadNoches() * this.getOcupacion().getHabitacion().getTarifa().getPrecio();
    }

    //CALCULA EL PRECIO DEL TIPO DE PENSION x LA CANT DE PASAJEROS x LA CANT DE NOCHES
    public double calculoPension() {
        return this.ocupacion.getTipoPension().getPrecio() *
                this.ocupacion.getCantidadPax() * this.calculoCantidadNoches();
    }

    //DE LA LISTA DE EXTRAS CONSUMIDOS POR LA HABITACION, GENERA UNA NUEVA LISTA PARA NO REPETIR
    //MÁS DE UNA VEZ EL MISMO ARTÍCULO EN LA FACTURA, VA SUMANDO LA CANTIDAD DE CADA UNO
    public List<Extra> listaExtrasOcupacion() {
        List<Extra> extrasOcupacion = new ArrayList<>();    //se crea nueva lista
        boolean encontrado = false;
        if (this.ocupacion.getExtras() != null) {  //recorre la lista de extras de la habitación
            for (Extra lista : this.ocupacion.getExtras()) {  //recorre la nueva lista
                encontrado = false;
                for (Extra listaOcupacion : extrasOcupacion) {

                    if (lista.getNombre().compareTo(listaOcupacion.getNombre()) == 0) { //si encuentra el producto en
                        encontrado = true;                                              //en la nueva lista
                        listaOcupacion.setCantidad(listaOcupacion.getCantidad() + 1);     //añade 1 a la cantidad de ese objeto
                    }
                }
                if (encontrado == false) {
                    extrasOcupacion.add(lista); // si no lo encontro,lo agrega a la lista

                }
            }

        }
        return extrasOcupacion; //devuelve la nueva lista
    }

    //RECORRE LISTA DE EXTRAS Y SUMA LOS PRECIOS
    public double calculoExtras() {
        double total = 0;
        if (this.ocupacion.getExtras() != null) {
            for (Extra extra : this.ocupacion.getExtras()) {
                total += extra.getPrecio();
            }
        }
        return total;
    }

    public double calculoCochera() {
        return this.ocupacion.getCochera() * Cochera.COCHERA_CUB.getPrecio();
    }

    //SUMA EL TOTAL DE ALOJAMIENTO + TOTAL DE PENSION + EXTRAS + COCHERA
    public double calculoFinalOcupacionSinIva() {
        return calculoAlojamiento() + calculoPension() + calculoExtras() + calculoCochera();

    }

    //CALCULA EL IVA SOBRE EL TOTAL DE LA OCUPACION
    public double calculoIva() {
        return calculoFinalOcupacionSinIva() * 0.21;  ///debería poner iva según factura
    }

    //CALCULA EL TOTAL DE LA OCUPACION + IVA
    public double calculoFinalOcupacionConIva() {
        return calculoFinalOcupacionSinIva() + calculoIva() - this.ocupacion.getDeposito();

    }

    @Override
    public String toString() {
        return "-------------------------------------------------------------------------" +
                "\n                         Factura Tipo " + this.tipoFactura.getDescripcion() +
                "\n\nRazón Social: Hotel Mar del Plata S.A." + "     |  Fecha: " + this.fechaEmision +
                "\nDomicilio: Av. Libertad 2899" + "               |  Comprobante Nro: 0000" + this.numeroFactura +
                "\nCondición de IVA: Responsable Inscripto" + "    |  Cuit: 30-54112569-8" +
                "\n-------------------------------------------------------------------------" +
                "\nSeñor(es): " + this.ocupacion.titularHabitacion().getNombre() + " " +
                this.ocupacion.titularHabitacion().getApellido() +
                "\nDomicilio: " + this.ocupacion.titularHabitacion().getCalle() + " " +
                this.ocupacion.titularHabitacion().getNumero() + " " +
                this.ocupacion.titularHabitacion().getPiso() + " " +
                this.ocupacion.titularHabitacion().getDepartamento() + " - " +
                this.ocupacion.titularHabitacion().getCiudad() + " - " +
                this.ocupacion.titularHabitacion().getProvincia() + " - " +
                this.ocupacion.titularHabitacion().getPais() +
                "\n-------------------------------------------------------------------------" +
                "\nFecha de ingreso: " + this.ocupacion.getFechaIngreso() +
                "                 Fecha de salida: " + this.ocupacion.getFechaSalida() +
                "\n-------------------------------------------------------------------------" +
                "\n     Alojamiento     |      Tarifa     |     Noches      |       Total     " +
                "\n    " + this.ocupacion.getHabitacion().getTarifa().getNombre() + "           " +
                this.ocupacion.getHabitacion().getTarifa().getPrecio() + "             "
                + this.calculoCantidadNoches() + "                " + this.calculoAlojamiento() +

                "\n\n\n     Pensión     |   Precio Unit.  |   Paxs   |  Noches   |      Total     " +
                "\n  " + this.ocupacion.getTipoPension().getNombre() + "        " +
                this.ocupacion.getTipoPension().getPrecio() + "           " +
                this.ocupacion.getCantidadPax() + "          " +
                this.calculoCantidadNoches() + "            " +
                this.calculoPension() +

                "\n\n\n          Extras        |   Precio Unit.   |   Cantidad   |      Total     " +
                "\n" + this.listaExtrasOcupacion().toString().replace("[", "").replace("]","").replace(",", "") +
                "\n\n         Cochera             " +
                Cochera.COCHERA_CUB.getPrecio() + "               " +
                this.ocupacion.getCochera() + "              " + this.calculoCochera() +
                "\n-------------------------------------------------------------------------" +
                "\n                                                       Importe: " + calculoFinalOcupacionSinIva() +
                String.format("\n                                                           Iva: %.2f", calculoIva()) +
                "\n                                                           Depósito: " + this.ocupacion.getDeposito() +
                "\n\n                                                         Total: " + calculoFinalOcupacionConIva() +
                "\n-------------------------------------------------------------------------";


    }
}
