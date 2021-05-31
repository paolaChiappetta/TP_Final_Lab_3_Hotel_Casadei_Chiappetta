package com.Hotel;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Factura {

    private static int idFactura = 0;

    private int numeroFactura;
    private LocalDate fechaEmision;
    private TipoFactura tipoFactura;
    private Ocupacion ocupacion;


    public Factura() {
        this.numeroFactura = idFactura+1;
    }

    public Factura(TipoFactura tipoFactura, Ocupacion ocupacion) {
        this.fechaEmision = LocalDate.now();
        this.tipoFactura = tipoFactura;
        this.ocupacion = ocupacion;
        this.numeroFactura = idFactura+1;

    }

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

    public Long calculoCantidadNoches() {
        return ChronoUnit.DAYS.between(this.ocupacion.getFechaIngreso(), this.ocupacion.getFechaSalida());

    }

    public Double calculoAlojamiento() {
        return this.calculoCantidadNoches() * this.getOcupacion().getHabitacion().getTarifa().getPrecio();
    }

    public double calculoPension() {
        return this.ocupacion.getTipoPension().getPrecio() *
                this.ocupacion.getCantidadPax() * this.calculoCantidadNoches();
    }

    public List<Extra> listaExtrasOcupacion() {
        List<Extra> extrasOcupacion = new ArrayList<>();
        boolean encontrado = false;
        if (this.ocupacion.getExtras() != null) {
            for (Extra lista : this.ocupacion.getExtras()) {
                for (Extra listaOcupacion : extrasOcupacion) {
                    if (lista.getNombre().compareTo(listaOcupacion.getNombre()) == 0) {
                        encontrado = true;
                    }
                }
                if (encontrado == false) {
                    lista.setCantidad(1);
                    extrasOcupacion.add(lista);

                } else {
                    lista.setCantidad(lista.getCantidad() + 1);
                }
            }

        }
        return extrasOcupacion;
    }

    public double calculoExtras () {
        double total = 0;
        List<Extra> extras = listaExtrasOcupacion();
        if (extras != null) {
            for (Extra extra : extras) {
                total += extra.calculoExtraPorCantidad();
            }
        }
        return total;
    }

    public double calculoFinalOcupacionSinIva () {
        return calculoAlojamiento() + calculoPension() + calculoExtras() + calculoCochera();

    }

    public double calculoIva () {
        return calculoFinalOcupacionSinIva() * 0.21;  ///debería poner iva según factura
    }

    public double calculoFinalOcupacionConIva () {
        return calculoFinalOcupacionSinIva() + calculoIva();

    }

    public double calculoCochera () {
        return this.ocupacion.getCochera() * Cochera.COCHERA_CUB.getPrecio();
    }

    public String mostrarListaExtrasOcupacion () {
        List<Extra> extras = listaExtrasOcupacion();
        String extra = null;
        if (extras != null) {
            for (Extra lista : extras) {

            }
        }
        return extra;

    }


    @Override
    public String toString () {


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
                "\n" + this.listaExtrasOcupacion().toString() +
                "\n\n         Cocheras             " +
                Cochera.COCHERA_CUB.getPrecio() + "               " +
                this.ocupacion.getCochera() + "              " + this.calculoCochera() +
                "\n-------------------------------------------------------------------------" +
                "\n                                                       Importe: " + calculoFinalOcupacionSinIva() +
                "\n                                                           Iva: " + calculoIva() +
                "\n\n                                                         Total: " + calculoFinalOcupacionConIva() +
                "\n-------------------------------------------------------------------------";


    }
}
