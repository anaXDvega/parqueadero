package com.ceiba.factura.servicio;

import com.ceiba.factura.modelo.entidad.Facturar;

public class GenerarCobro {

    private GenerarCobroVehiculo generarCobroVehiculo;

    public GenerarCobro(GenerarCobroVehiculo generarCobroVehiculo){
        this.generarCobroVehiculo = generarCobroVehiculo;
    }

    public Facturar executeStrategy(Facturar facturar){
        return generarCobroVehiculo.facturar(facturar);
    }
}
