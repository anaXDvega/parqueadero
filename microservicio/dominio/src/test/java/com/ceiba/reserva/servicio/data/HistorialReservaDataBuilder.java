package com.ceiba.reserva.servicio.data;
import com.ceiba.reserva.modelo.entidad.HistorialReserva;

import java.time.LocalDateTime;

public class HistorialReservaDataBuilder {

    private int tipoVehiculo;

    private Long cilindraje;

    private String placa;

    private LocalDateTime fecha;

    private Long tiempoEstimado;
    private String estado;

    private int id;

    public HistorialReservaDataBuilder id(int id) {
        this.id = id;
        return this;
    }
    public HistorialReservaDataBuilder estado(String estado) {
        this.estado = estado;
        return this;
    }
    public HistorialReservaDataBuilder tipo_vehiculo(int tipo_vehiculo) {
        this.tipoVehiculo = tipo_vehiculo;
        return this;
    }

    public HistorialReservaDataBuilder placa(String placa) {
        this.placa = placa;
        return this;
    }
    public HistorialReservaDataBuilder fecha(LocalDateTime fecha) {
        this.fecha = fecha;
        return this;
    }
    public HistorialReservaDataBuilder cilindraje(Long cilindraje) {
        this.cilindraje = cilindraje;
        return this;
    }

    public HistorialReservaDataBuilder tiempoEstimado(Long tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
        return this;
    }
    public HistorialReserva build() {
        return new HistorialReserva(tipoVehiculo, placa, fecha, cilindraje, tiempoEstimado);
    }
    public HistorialReserva actualizarBuild() {
        return new HistorialReserva(fecha,placa);
    }


    public HistorialReserva reconstruir() {
        return HistorialReserva.reconstruir(id, tipoVehiculo, placa, fecha, cilindraje, tiempoEstimado, estado);
    }
}
