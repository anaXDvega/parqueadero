package com.ceiba.reserva.puerto.dao;

import com.ceiba.reserva.modelo.dto.HistorialReservaDTO;

import java.time.LocalDateTime;

public interface DaoReserva {
    HistorialReservaDTO obtenerPorPlacaYFecha(LocalDateTime fecha, String placa);

}
