package com.ceiba.factura.consulta;

import com.ceiba.factura.modelo.dto.FacturaDTO;
import com.ceiba.factura.puerto.dao.DaoFactura;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorConsultarFactura {

    private DaoFactura daoFactura;

    public ManejadorConsultarFactura(DaoFactura daoFactura) {
        this.daoFactura = daoFactura;
    }

    public FacturaDTO obtenerPorId(int placa){
        return daoFactura.obtenerPorIdFactura(placa);
    }

    public List<FacturaDTO> obtenerFacturas (){
        return daoFactura.obtenerFacturas();
    }
}
