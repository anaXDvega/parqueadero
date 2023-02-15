package com.ceiba.reserva.modelo;

import com.ceiba.reserva.modelo.dto.HistorialReservaDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.time.Month;

import static com.ceiba.utils.ConstantesParqueadero.ESTADO_ACTIVA;

public class HistorialReservaDTOtest {

    @Test
    void validarCreacionExitos() {
        int id = 1;
        int tipoVehiculo = 1;
        String placa = "AV6566";
        LocalDateTime fechaRegistro = LocalDateTime.of(2022, Month.DECEMBER, 29, 13, 12);
        Long tiempoEstimado = 24L;
        Long cilindraje = 240L;
        String estado = ESTADO_ACTIVA;
        HistorialReservaDTO historialReserva = new HistorialReservaDTO(id, tipoVehiculo, placa, fechaRegistro, estado,cilindraje, tiempoEstimado);
        Assertions.assertEquals(1, historialReserva.getId());
        Assertions.assertEquals("AV6566", historialReserva.getPlaca());
        Assertions.assertEquals(LocalDateTime.of(2022, Month.DECEMBER, 29, 13, 12), historialReserva.getFecha());
        Assertions.assertEquals(ESTADO_ACTIVA, historialReserva.getEstado());
        Assertions.assertEquals(24L, historialReserva.getTiempoEstimado());
        Assertions.assertEquals(1, historialReserva.getTipoVehiculo());
        Assertions.assertEquals(240L, historialReserva.getCilindraje());
    }
}
