package com.ceiba.factura.modelo;

import com.ceiba.factura.modelo.dto.FacturaDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static com.ceiba.utils.ConstantesParqueadero.ESTADO_ACTIVA;


public class FacturaDTOTest {
    @Test
    void validarCreacionExitos() {
        int id = 1;
        int idReserva = 1;
        LocalDateTime fechaInicio = LocalDateTime.of(2022, Month.DECEMBER, 29, 13, 12);
        LocalDateTime fechaFin = LocalDateTime.of(2022, Month.DECEMBER, 29, 13, 12);
        Double valorTotal = 24.0;
        String estado = ESTADO_ACTIVA;
        FacturaDTO historialReserva = new FacturaDTO(id, idReserva, fechaInicio, fechaFin,valorTotal,
                estado);
        Assertions.assertEquals(1, historialReserva.getId());
        Assertions.assertEquals(1, historialReserva.getIdReserva());
        Assertions.assertEquals(24.0, historialReserva.getValorTotal());
        Assertions.assertEquals(LocalDateTime.of(2022, Month.DECEMBER, 29, 13, 12), historialReserva.getFechaFin());
        Assertions.assertEquals(ESTADO_ACTIVA, historialReserva.getEstado());
        Assertions.assertEquals(LocalDateTime.of(2022, Month.DECEMBER, 29, 13, 12), historialReserva.getFechaInicio());
    }
}
