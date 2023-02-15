package com.ceiba.reserva.servicio.reglasparqueadero;

import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.reserva.modelo.entidad.HistorialReserva;
import java.time.LocalDateTime;

public class ReglasParqueadero {

    private ReglaVehiculo reglaVehiculo;

    public ReglasParqueadero(ReglaVehiculo reglaVehiculo) {
        this.reglaVehiculo = reglaVehiculo;
    }


    public boolean disponibilidadEstacionamiento(LocalDateTime fecha, int numero){
        return reglaVehiculo.disponibilidadEstacionamiento(fecha, numero);
    }

    public static Double descuentosPorDiasEstacionados(LocalDateTime fechaInicio,LocalDateTime fechaFin, Double total){
        if (Factura.mayorA15Dias(fechaInicio, fechaFin)){
            return total*0.10;
        }else {
            return (double) 0;
        }
    }

    public static Double reservaDiaCompleto(Long tiempoEstimado, Double precioHora){
        if (HistorialReserva.esDiaCompleto(tiempoEstimado)){
           return precioHora*2;
        }
        return (double) 0;
    }
    public static Double recargosPorRetardoEnConfirmarReserva(Long horasRecargo, double precioHora){
        double porcentaje = horasRecargo*( precioHora * 0.05);
        return horasRecargo>=1 ? porcentaje : 0;
    }

}
