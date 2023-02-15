package com.ceiba.factura.servicio.data;

import com.ceiba.factura.modelo.entidad.Factura;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

public class FacturaBuildData {

    public static Factura reconstruir(){
    return new FacturaBuild()
            .id(1)
            .id_reserva(1)
            .fecha_inicio(LocalDateTime.of(2022, Month.JULY, 15, 18, 00))
            .valor_total(null)
            .estado("ACTIVA").reconstruir();
}
    public static Factura reconstruirCarro(){
        return new FacturaBuild()
                .id(2)
                .id_reserva(2)
                .fecha_inicio(LocalDateTime.of(2022, Month.JULY, 15, 18, 00))
                .valor_total(null)
                .estado("ACTIVA").reconstruir();
    }

    public static Factura reconstruirMoto(){
        return new FacturaBuild()
                .id(3)
                .id_reserva(3)
                .fecha_inicio(LocalDateTime.of(2022, Month.JULY, 15, 18, 00))
                .valor_total(null)
                .estado("ACTIVA").reconstruir();
    }

    public static Factura reconstruirAltoCilindraje(){
        return new FacturaBuild()
                .id(3)
                .id_reserva(3)
                .fecha_inicio(LocalDateTime.of(2022, Month.JULY, 15, 18, 00))
                .valor_total(null)
                .estado("ACTIVA").reconstruir();
    }
}
