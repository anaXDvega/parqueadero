package com.ceiba.factura.modelo.entidad;

import com.ceiba.reserva.modelo.entidad.HistorialReserva;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Facturar {
    Factura factura;

    HistorialReserva historialReserva;
}
