package com.ceiba.reserva.servicio.reglasparqueadero;

import com.ceiba.utils.UtilCalcularTiempo;

import java.time.LocalDateTime;

import static com.ceiba.utils.ConstantesParqueadero.*;

public class ReglaVehiculoMoto implements ReglaVehiculo {


    @Override
    public boolean disponibilidadEstacionamiento(LocalDateTime fecha, int numero) {
        boolean disponibilidadfds = numero < MAX_MOTO_PARQUEADERO_FDS;
        boolean disponibilidadEntreSemana = numero < MAX_MOTO_PARQUEADERO_SEMANA;
        return UtilCalcularTiempo.validarFinesDeSemana(fecha) ?
                disponibilidadfds : disponibilidadEntreSemana;
    }
}
