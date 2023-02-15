package com.ceiba.reserva.servicio.reglasparqueadero;


import java.time.LocalDateTime;


public interface ReglaVehiculo {
     boolean disponibilidadEstacionamiento(LocalDateTime fecha, int numero);
}
