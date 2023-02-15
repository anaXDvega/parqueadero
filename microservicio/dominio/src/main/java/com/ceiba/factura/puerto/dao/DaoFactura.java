package com.ceiba.factura.puerto.dao;

import com.ceiba.factura.modelo.dto.FacturaDTO;

import java.util.List;

public interface DaoFactura {


    FacturaDTO obtenerPorIdFactura(int id);

    List<FacturaDTO> obtenerFacturas();
}
