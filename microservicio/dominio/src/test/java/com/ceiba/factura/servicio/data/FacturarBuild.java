package com.ceiba.factura.servicio.data;

import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.factura.modelo.entidad.Facturar;
import com.ceiba.reserva.modelo.entidad.HistorialReserva;

public class FacturarBuild {

    Factura factura;

    HistorialReserva historialReserva;

    public FacturarBuild factura( Factura factura) {
        this.factura = factura;
        return this;
    }

    public FacturarBuild historialReserva( HistorialReserva historialReserva) {
        this.historialReserva = historialReserva;
        return this;
    }
    public Facturar build() {
        return new Facturar(factura, historialReserva);
    }


}
