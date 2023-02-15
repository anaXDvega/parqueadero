package com.ceiba.reserva;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.reserva.modelo.entidad.HistorialReserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.reglasparqueadero.ReglaVehiculo;
import com.ceiba.reserva.servicio.reglasparqueadero.ReglaVehiculoCarro;
import com.ceiba.reserva.servicio.reglasparqueadero.ReglaVehiculoMoto;
import com.ceiba.reserva.servicio.reglasparqueadero.ReglasParqueadero;
import com.ceiba.utils.MensajesDeExcepcionReserva;

public class ValidadorReserva {

    private RepositorioReserva repositorioReserva;

    public ValidadorReserva(RepositorioReserva repositorioReserva) {
        this.repositorioReserva = repositorioReserva;
    }

    public void validarReserva(HistorialReserva historialReserva) {
        if (repositorioReserva.existe(historialReserva.getPlaca(), historialReserva.getFecha())){
            throw new ExcepcionDuplicidad(MensajesDeExcepcionReserva.EXISTE_UNA_RESERVA.getMensaje());
        }
    }
    public void validarDisponibilidad(HistorialReserva historialReserva) {
        int cantidadDeEstacionamientosDisponibles = repositorioReserva.cantidadDeEstacionamientosDisponibles(historialReserva.getTipoVehiculo());
        ReglaVehiculo reglaVehiculo = tipoVehiculo(historialReserva.getTipoVehiculo());
        ReglasParqueadero reglaParqueadero= new ReglasParqueadero(reglaVehiculo);
        if (!reglaParqueadero.disponibilidadEstacionamiento(historialReserva.getFecha(), cantidadDeEstacionamientosDisponibles)){
            throw new ExcepcionDuplicidad(MensajesDeExcepcionReserva.CUPO_LLENO.getMensaje());
        }
    }
    public ReglaVehiculo tipoVehiculo(int tipoVehiculo) {
        return tipoVehiculo==1 ? new ReglaVehiculoMoto():new ReglaVehiculoCarro();
    }
}
