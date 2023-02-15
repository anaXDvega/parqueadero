package com.ceiba.reserva.comando.manejador;

import com.ceiba.factura.servicio.ServicioFacturar;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.reserva.comando.ComandoSolicitudActivarReserva;
import com.ceiba.reserva.comando.fabrica.FabricaActivarReserva;
import com.ceiba.reserva.modelo.entidad.HistorialReserva;
import com.ceiba.reserva.servicio.ServicioConfirmarReserva;
import org.springframework.stereotype.Component;

@Component
public class ManejadorConfirmarReserva implements ManejadorComando<ComandoSolicitudActivarReserva> {

    private final FabricaActivarReserva fabricaActivarReserva;
    private final ServicioConfirmarReserva servicioConfirmarReserva;

    private final ServicioFacturar servicioFacturar;

    public ManejadorConfirmarReserva(FabricaActivarReserva fabricaActivarReserva, ServicioConfirmarReserva servicioConfirmarReserva, ServicioFacturar servicioFacturar) {
        this.fabricaActivarReserva = fabricaActivarReserva;
        this.servicioConfirmarReserva = servicioConfirmarReserva;
        this.servicioFacturar = servicioFacturar;
    }

    @Override
    public void ejecutar(ComandoSolicitudActivarReserva activarReserva) {
        HistorialReserva reserva = fabricaActivarReserva.crear(activarReserva);
        servicioFacturar.crearFactura(servicioConfirmarReserva.ejecutar(reserva));
    }
}
