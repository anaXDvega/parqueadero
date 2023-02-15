package com.ceiba.factura.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.factura.comando.ComandoSolicitudFacturar;
import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.factura.servicio.ServicioFacturar;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorFacturar implements ManejadorComandoRespuesta<ComandoSolicitudFacturar, ComandoRespuesta<Factura>> {
    private final ServicioFacturar servicioFacturar;


    public ManejadorFacturar(ServicioFacturar servicioFacturar) {
        this.servicioFacturar = servicioFacturar;
    }

    @Override
    public ComandoRespuesta<Factura> ejecutar(ComandoSolicitudFacturar comando) {
    return new ComandoRespuesta<>(servicioFacturar.facturar(new Factura(comando.getIdReserva())));
    }
}
