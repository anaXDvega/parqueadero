package com.ceiba.reserva.servicio.reglasparqueadero;

import java.time.LocalDateTime;

import static com.ceiba.utils.ConstantesParqueadero.MAX_CARROS_PARQUEADERO_FDS;
import static com.ceiba.utils.ConstantesParqueadero.MAX_CARROS_PARQUEADERO_SEMANA;
import static com.ceiba.utils.UtilCalcularTiempo.validarFinesDeSemana;

public class ReglaVehiculoCarro implements ReglaVehiculo {


    @Override
    public boolean disponibilidadEstacionamiento(LocalDateTime fecha, int numero) {
        boolean disponibilidadfds = numero < MAX_CARROS_PARQUEADERO_FDS;
        boolean disponibilidadEntreSemana = numero < MAX_CARROS_PARQUEADERO_SEMANA;
        return validarFinesDeSemana(fecha) ?
                disponibilidadfds : disponibilidadEntreSemana;
    }
}
