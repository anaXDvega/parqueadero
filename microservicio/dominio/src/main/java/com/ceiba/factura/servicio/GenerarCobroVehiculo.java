package com.ceiba.factura.servicio;

import com.ceiba.factura.modelo.entidad.Facturar;

public interface  GenerarCobroVehiculo {

    Facturar aplicarDescuentos(Facturar facturar);

    Facturar facturar(Facturar facturar);

    Facturar calcularPago(Facturar facturar);
}
