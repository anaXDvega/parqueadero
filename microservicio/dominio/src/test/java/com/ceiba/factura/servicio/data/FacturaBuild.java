package com.ceiba.factura.servicio.data;


import com.ceiba.factura.modelo.entidad.Factura;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FacturaBuild {

    private int id;

    private int id_reserva;

    private LocalDateTime fecha_inicio;
    private LocalDateTime fecha_fin;

    private Double valor_total;
    private String estado;

    public FacturaBuild id(int id) {
        this.id = id;
        return this;
    }

    public FacturaBuild id_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
        return this;
    }

    public FacturaBuild fecha_inicio(LocalDateTime fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
        return this;
    }
    public FacturaBuild fecha_fin(LocalDateTime fecha_fin) {
        this.fecha_fin = fecha_fin;
        return this;
    }

    public FacturaBuild valor_total(Double valor_total) {
        this.valor_total = valor_total;
        return this;
    }
    public FacturaBuild estado(String estado) {
        this.estado = estado;
        return this;
    }

    public Factura reconstruir() {
        return Factura.reconstruir(id, id_reserva, fecha_inicio, valor_total, estado);
    }

    public Factura build() {
        return new Factura(id, id_reserva, fecha_inicio, valor_total, estado);
    }
}
