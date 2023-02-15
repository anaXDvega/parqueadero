package com.ceiba.reserva.testdatabuilder;

import com.ceiba.reserva.comando.ComandoSolicitudActivarReserva;

import java.time.LocalDateTime;
import java.time.Month;

public class ComandoActivarReservaTestDataBuilder {

    public String placa;

    public LocalDateTime fecha;

    public ComandoActivarReservaTestDataBuilder activarReserva(){
        this.placa = "prueba02";
        this.fecha = LocalDateTime.of(2022, Month.DECEMBER, 29, 13, 13);
        return  this;
    }
    public ComandoSolicitudActivarReserva build(){
        return new ComandoSolicitudActivarReserva(placa, fecha);
    }
}
