package com.ceiba.reserva.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoSolicitudReservar {
    private int tipoVehiculo;

    private Long cilindraje;

    private String placa;

    private LocalDateTime fecha;

    private Long tiempoEstimado;
}
