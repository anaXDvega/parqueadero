package com.ceiba.reserva.comando.fabrica;

import com.ceiba.reserva.comando.ComandoSolicitudReservar;
import com.ceiba.reserva.modelo.entidad.HistorialReserva;
import org.springframework.stereotype.Component;

@Component
public class FabricaSolicitudReservar {
    public HistorialReserva crear(ComandoSolicitudReservar comandoSolicitudReservar) {
      return new HistorialReserva(comandoSolicitudReservar.getTipoVehiculo(),
              comandoSolicitudReservar.getPlaca(), comandoSolicitudReservar.getFecha(), comandoSolicitudReservar.getCilindraje(), comandoSolicitudReservar.getTiempoEstimado());
    }

}
