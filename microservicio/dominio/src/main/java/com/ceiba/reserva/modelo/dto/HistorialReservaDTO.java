package com.ceiba.reserva.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class HistorialReservaDTO {
    private int id;

    private int tipoVehiculo;

    private String placa;

    private LocalDateTime fecha;

    private String estado;

    private Long cilindraje;

    private Long tiempoEstimado;

}
