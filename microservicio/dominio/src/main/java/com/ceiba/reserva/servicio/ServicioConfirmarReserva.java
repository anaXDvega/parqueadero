package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.reserva.modelo.entidad.HistorialReserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.utils.MensajesDeExcepcionReserva;

public class ServicioConfirmarReserva {

    private final RepositorioReserva repositorioReserva;


    public ServicioConfirmarReserva(RepositorioReserva repositorioReserva) {
        this.repositorioReserva = repositorioReserva;
    }

    public HistorialReserva ejecutar(HistorialReserva historialReserva) {
        validarExistenciaPrevia(historialReserva);
        this.repositorioReserva.actualizar(historialReserva);
        return repositorioReserva.getReserva(historialReserva.getPlaca(), historialReserva.getFecha());
    }
    private void validarExistenciaPrevia(HistorialReserva cliente) {
        boolean existe = this.repositorioReserva.existe(cliente.getPlaca(), cliente.getFecha());
        if (!existe) {
            throw new ExcepcionSinDatos(MensajesDeExcepcionReserva.NO_EXISTE_UNA_RESERVA.getMensaje());
        }
    }
}
