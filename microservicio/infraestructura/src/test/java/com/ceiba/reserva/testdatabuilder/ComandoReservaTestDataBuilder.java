package com.ceiba.reserva.testdatabuilder;
import com.ceiba.reserva.comando.ComandoSolicitudReservar;

import java.time.LocalDateTime;
import java.time.Month;

public class ComandoReservaTestDataBuilder {

    public int tipoVehiculo;

    public Long cilindraje;

    public String placa;

    public LocalDateTime fecha;

    public Long tiempoEstimado;

    public ComandoReservaTestDataBuilder reservarMoto(){
        this.tipoVehiculo= 1;
        this.placa = "test0002";
        this.cilindraje = 300L;
        this.fecha = LocalDateTime.of(2021, Month.JULY, 15, 18, 00);
        this.tiempoEstimado = 0L;
        return  this;
    }
    public ComandoReservaTestDataBuilder consultarReserva(){
        this.placa = "prueba02";
        this.fecha = LocalDateTime.of(2022, Month.DECEMBER, 29, 13, 13);
        return  this;
    }
    public ComandoSolicitudReservar build(){
        return new ComandoSolicitudReservar(tipoVehiculo, cilindraje,placa,
                fecha, tiempoEstimado
        );
    }
}
