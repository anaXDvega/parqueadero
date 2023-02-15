package com.ceiba.reserva.servicio.data;

import com.ceiba.reserva.modelo.entidad.HistorialReserva;

import java.time.LocalDateTime;
import java.time.Month;

public class HistorialReservaData {

    public static HistorialReserva reserva(){
        return new HistorialReservaDataBuilder()
                .id(1)
                .tipo_vehiculo(1)
                .placa("AV5999")
                .fecha(LocalDateTime.of(2021, Month.JULY, 15, 18, 00))
                .cilindraje(300L)
                .estado("ACTIVA")
                .tiempoEstimado(0L).reconstruir();
    }
    public static HistorialReserva registrarReserva(){
        return new HistorialReservaDataBuilder()
                .tipo_vehiculo(1)
                .placa("AV5999")
                .fecha(LocalDateTime.of(2021, Month.JULY, 15, 18, 00))
                .cilindraje(300L)
                .tiempoEstimado(0L).build();
    }
    public static HistorialReserva registrarReservaSinPlaca(){
        return new HistorialReservaDataBuilder().tipo_vehiculo(1)
                .fecha(LocalDateTime.of(2021, Month.JULY, 15, 18, 00))
                .cilindraje(300L)
                .build();
    }
    public static HistorialReserva registrarReservaSinCilindrajeTipoMoto(){
        return  new HistorialReservaDataBuilder().tipo_vehiculo(1)
                .fecha(LocalDateTime.of(2021, Month.JULY, 15, 18, 00))
                .placa("AV5999")
                .build();
    }
    public static HistorialReserva registrarReservaSinCilindrajeTipoCarro(){
        return  new HistorialReservaDataBuilder().tipo_vehiculo(2)
                .fecha(LocalDateTime.of(2021, Month.JULY, 15, 18, 00))
                .placa("AV5999")
                .build();
    }
    public static HistorialReserva historialReservaActualizarBuild(){
        return new  HistorialReservaDataBuilder()
                .placa("AV5999")
                .fecha(LocalDateTime.now())
                .actualizarBuild();
    }

    public static HistorialReserva historialReservaActualizarBuildRetornaExisteReserva(){
        return new HistorialReservaDataBuilder()
                .placa("AV5999")
                .fecha(LocalDateTime.of(2021, Month.JULY, 15, 18, 00))
                .actualizarBuild();
    }
    public static HistorialReserva historialReservaCarroFDS(){
        return new HistorialReservaDataBuilder().tipo_vehiculo(2)
                .fecha(LocalDateTime.of(2021, Month.JULY, 17, 18, 00))
                .placa("AV5999")
                .build();
    }
    public static HistorialReserva historialReservaCarroEntreSemana(){
        return  new HistorialReservaDataBuilder().tipo_vehiculo(2)
                .fecha(LocalDateTime.of(2021, Month.JULY, 16, 18, 00))
                .placa("AV5999")
                .build();
    }
    public static HistorialReserva historialReservaMotoFDS(){
        return   new HistorialReservaDataBuilder().tipo_vehiculo(1)
                .fecha(LocalDateTime.of(2021, Month.JULY, 17, 18, 00))
                .placa("AV5999")
                .build();
    }
    public static HistorialReserva historialReservaMotoEntreSemana(){
        return   new HistorialReservaDataBuilder().tipo_vehiculo(1)
                .fecha(LocalDateTime.of(2021, Month.JULY, 14, 18, 00))
                .placa("AV5999")
                .build();
    }
    public static HistorialReserva finalizada(){
        return new HistorialReservaDataBuilder()
                .id(1)
                .tipo_vehiculo(1)
                .placa("AV5999")
                .fecha(LocalDateTime.now())
                .cilindraje(300L)
                .estado("FINALIZADA")
                .tiempoEstimado(0L).reconstruir();
    }

    public static HistorialReserva facturarMoto(){
        return new HistorialReservaDataBuilder()
                .id(1)
                .tipo_vehiculo(1)
                .placa("AV5999")
                .fecha(LocalDateTime.of(2022, Month.JULY, 15, 17, 00))
                .cilindraje(300L)
                .estado("ACTIVA")
                .tiempoEstimado(0L).reconstruir();
    }

    public static HistorialReserva facturarMotoAltoCilindraje(){
        return new HistorialReservaDataBuilder()
                .id(1)
                .tipo_vehiculo(1)
                .placa("AV5999")
                .fecha(LocalDateTime.of(2022, Month.JULY, 15, 17, 00))
                .cilindraje(600L)
                .estado("ACTIVA")
                .tiempoEstimado(0L).reconstruir();
    }

    public static HistorialReserva facturarCarro(){
        return new HistorialReservaDataBuilder()
                .id(2)
                .tipo_vehiculo(2)
                .placa("AV59889")
                .fecha(LocalDateTime.of(2022, Month.JULY, 15, 17, 00))
                .cilindraje(300L)
                .estado("ACTIVA")
                .tiempoEstimado(0L).reconstruir();
    }

    public static HistorialReserva facturarCarroSinRecargo(){
        return new HistorialReservaDataBuilder()
                .id(2)
                .tipo_vehiculo(2)
                .placa("AV59889")
                .fecha(LocalDateTime.of(2022, Month.JULY, 15, 18, 00))
                .cilindraje(300L)
                .estado("ACTIVA")
                .tiempoEstimado(0L).reconstruir();
    }

    public static HistorialReserva facturarMotoSinRecargo(){
        return new HistorialReservaDataBuilder()
                .id(3)
                .tipo_vehiculo(1)
                .placa("AV59889")
                .fecha(LocalDateTime.of(2022, Month.JULY, 15, 18, 00))
                .cilindraje(300L)
                .estado("ACTIVA")
                .tiempoEstimado(0L).reconstruir();
    }

    public static HistorialReserva facturarMotoSinRecargoAltoCilindraje(){
        return new HistorialReservaDataBuilder()
                .id(3)
                .tipo_vehiculo(1)
                .placa("AV59889")
                .fecha(LocalDateTime.of(2022, Month.JULY, 15, 18, 00))
                .cilindraje(600L)
                .estado("ACTIVA")
                .tiempoEstimado(24L).reconstruir();
    }
    public static HistorialReserva buildEliminar() {
       return new HistorialReservaDataBuilder().id(1).tipo_vehiculo(1)
                .placa("AV5999")
                .fecha(LocalDateTime.of(2021, Month.JULY, 15, 18, 00))
                .cilindraje(300L)
                .estado("PENDIENTE").reconstruir();
    }
}
