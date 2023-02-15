package com.ceiba.factura.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;
@AllArgsConstructor
@Getter
public class FacturaDTO {

    private int id;

    private int idReserva;

    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;

    private Double valorTotal;
    private String estado;
}
