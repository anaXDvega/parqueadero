package com.ceiba.factura.servicio;

import com.ceiba.factura.modelo.entidad.Facturar;
import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.reserva.servicio.reglasparqueadero.ReglasParqueadero;

import java.math.BigDecimal;

import static com.ceiba.utils.ConstantesParqueadero.*;

public class GenerarCobroMoto implements GenerarCobroVehiculo {
    @Override
    public Facturar aplicarDescuentos(Facturar facturar) {
        Double hora = Factura.esCilindrajeGrande(1, facturar.getHistorialReserva().getCilindraje() )? PRECIO_MOTO_CILINDRAJEGRANDE_HORA : PRECIO_MOTO_HORA;
        Double total =facturar.getFactura().getValorTotal();
        Double totalDeDescuentos =ReglasParqueadero.descuentosPorDiasEstacionados(facturar.getFactura().getFechaInicio(), facturar.getFactura().getFechaFin(), total)+ReglasParqueadero.reservaDiaCompleto(facturar.getHistorialReserva().getTiempoEstimado(), hora);
        facturar.getFactura().setValorTotal(total-totalDeDescuentos);
        return facturar;
    }

    @Override
    public Facturar facturar(Facturar facturar) {

       return aplicarDescuentos(calcularPago(facturar));
    }

    @Override
    public Facturar calcularPago(Facturar facturar){
        Double total;
        long horasRecargo = Factura.horasRecargo(facturar.getFactura().getFechaInicio(), facturar.getHistorialReserva().getFecha());
        long horasTotal = Factura.calcularHoras(facturar.getFactura().getFechaInicio(), facturar.getFactura().getFechaFin());
        boolean esCilindrajeGrande =Factura.esCilindrajeGrande(facturar.getHistorialReserva().getTipoVehiculo(), facturar.getHistorialReserva().getCilindraje());
        if (esCilindrajeGrande){
            total = Factura.calcularPagoSinRecargo(PRECIO_MOTO_CILINDRAJEGRANDE_HORA, PRECIO_MOTO_CILINDRAJEGRANDE_MEDIO_DIA, PRECIO_MOTO_CILINDRAJEGRANDE_DIA, horasTotal)+ReglasParqueadero.recargosPorRetardoEnConfirmarReserva(horasRecargo, PRECIO_MOTO_CILINDRAJEGRANDE_HORA);
                }else {
            total = ReglasParqueadero.recargosPorRetardoEnConfirmarReserva(horasRecargo, PRECIO_MOTO_HORA)+Factura.calcularPagoSinRecargo(PRECIO_MOTO_HORA, PRECIO_MOTO_MEDIO_DIA, PRECIO_MOTO_DIA, horasTotal);
        }
        facturar.getFactura().setValorTotal(total);
        return facturar;
         }
}
