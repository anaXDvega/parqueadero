package com.ceiba.factura.testdatabuilder;

import com.ceiba.factura.comando.ComandoSolicitudFacturar;

public class ComandoFacturaTestDataBuilder {
    public int idReserva;
    public ComandoFacturaTestDataBuilder getReserva() {
        this.idReserva = 2;
        return this;
    }
    public ComandoFacturaTestDataBuilder consultarFacturas() {
        this.idReserva = 3;
        return this;
    }
    public ComandoSolicitudFacturar build(){
        return new ComandoSolicitudFacturar(idReserva);
    }
}
