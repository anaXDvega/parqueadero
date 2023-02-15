package com.ceiba.reserva.puerto.repositorio;

import com.ceiba.reserva.modelo.entidad.HistorialReserva;

import java.time.LocalDateTime;


public interface RepositorioReserva {


    Long crearReserva(HistorialReserva historialReserva);

    void actualizar(HistorialReserva historialReserva);

    void finalizarReserva(HistorialReserva historialReserva);
    boolean existe(String placa, LocalDateTime fecha);

    HistorialReserva getReserva(String placa, LocalDateTime fecha);

    HistorialReserva obtenerPorId(int placa);

    int cantidadDeEstacionamientosDisponibles(int tipoDeVehiculo);
    void actualizarEstacionamientosDisponibles(LocalDateTime horaActual);
    void eliminar(Long id);
}
