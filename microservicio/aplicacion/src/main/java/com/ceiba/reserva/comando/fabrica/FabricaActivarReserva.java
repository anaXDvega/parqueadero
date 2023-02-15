package com.ceiba.reserva.comando.fabrica;

import com.ceiba.reserva.comando.ComandoSolicitudActivarReserva;
import com.ceiba.reserva.modelo.entidad.HistorialReserva;
import org.springframework.stereotype.Component;

@Component
public class FabricaActivarReserva {
    public HistorialReserva crear(ComandoSolicitudActivarReserva comandoSolicitudActivarReserva) {
        return  HistorialReserva.actualizar(comandoSolicitudActivarReserva.getFecha(),
                comandoSolicitudActivarReserva.getPlaca());
    }
}
