package com.ceiba.factura.puerto.repositorio;

import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.factura.modelo.entidad.Facturar;

public interface RepositorioFactura {

    Long crearFactura(Factura factura);

    Factura obtener(int id);
    void actualizarFactura(Facturar facturar);
}
