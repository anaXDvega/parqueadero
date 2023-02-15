package com.ceiba.reserva.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.reserva.comando.ComandoSolicitudReservar;
import com.ceiba.reserva.comando.fabrica.FabricaSolicitudReservar;
import com.ceiba.reserva.modelo.entidad.HistorialReserva;
import com.ceiba.reserva.servicio.ServicioReservar;
import org.springframework.stereotype.Component;

@Component
public class ManejadorReservar implements ManejadorComandoRespuesta<ComandoSolicitudReservar, ComandoRespuesta<Long>> {

    private final FabricaSolicitudReservar fabricaSolicitudReservar;

    private final ServicioReservar servicioReservar;

    public ManejadorReservar(FabricaSolicitudReservar fabricaSolicitudReservar, ServicioReservar servicioReservar) {
        this.fabricaSolicitudReservar = fabricaSolicitudReservar;
        this.servicioReservar = servicioReservar;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoSolicitudReservar comando) {
      return new ComandoRespuesta<>(servicioReservar.ejecutar(fabricaSolicitudReservar.crear(comando)));
    }


}
