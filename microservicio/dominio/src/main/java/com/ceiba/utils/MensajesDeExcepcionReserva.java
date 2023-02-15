package com.ceiba.utils;

import lombok.Getter;

@Getter
public enum MensajesDeExcepcionReserva {
    EXISTE_UNA_RESERVA("Ya existe una reserva para este vehiculo"),

    NO_EXISTE_UNA_RESERVA("No existe una reserva para este vehiculo"),
    NO_EXISTE_UNA_FACTURA("No conseguimos una factura activa para este vehiculo"),
    CUPO_LLENO("No contamos con el espacio suficiente para tu vehiculo");
    private  String mensaje;

    MensajesDeExcepcionReserva(String mensaje){
        this.mensaje=mensaje;
    }
}
