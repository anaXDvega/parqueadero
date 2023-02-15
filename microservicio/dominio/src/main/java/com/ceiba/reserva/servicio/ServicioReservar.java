package com.ceiba.reserva.servicio;
import com.ceiba.reserva.ValidadorReserva;
import com.ceiba.reserva.modelo.entidad.HistorialReserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

import java.util.Date;

import static com.ceiba.utils.UtilCalcularTiempo.sumarMinutos;

public class ServicioReservar {

    private RepositorioReserva repositorioReserva;
    private ValidadorReserva validadorReserva;

    public ServicioReservar(RepositorioReserva repositorioReserva, ValidadorReserva validadorReserva) {
        this.repositorioReserva = repositorioReserva;
        this.validadorReserva = validadorReserva;
    }

    public Long ejecutar(HistorialReserva historialReserva) {
      HistorialReserva.reservar(historialReserva);
      validadorReserva.validarReserva(historialReserva);
      this.actualizarDisponibilidad();
      validadorReserva.validarDisponibilidad(historialReserva);
      return repositorioReserva.crearReserva(historialReserva);
    }
    public void actualizarDisponibilidad() {
        repositorioReserva.actualizarEstacionamientosDisponibles(sumarMinutos(new Date(), 10));
    }
}
