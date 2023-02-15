package com.ceiba.factura.servicio;

import com.ceiba.factura.modelo.entidad.Facturar;
import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.reserva.servicio.reglasparqueadero.ReglasParqueadero;

import java.math.BigDecimal;

import static com.ceiba.utils.ConstantesParqueadero.*;

public class GenerarCobroCarro implements GenerarCobroVehiculo {

    @Override
    public Facturar aplicarDescuentos(Facturar facturar) {
        Double total = facturar.getFactura().getValorTotal();
        Double totalDeDescuentos = ReglasParqueadero.descuentosPorDiasEstacionados(facturar.getFactura().getFechaInicio(), facturar.getFactura().getFechaFin(), total)+ReglasParqueadero.reservaDiaCompleto(facturar.getHistorialReserva().getTiempoEstimado(), PRECIO_CARRO_HORA);
        facturar.getFactura().setValorTotal(total-totalDeDescuentos);
        return facturar;
    }

    @Override
    public Facturar facturar(Facturar facturar) {
        return aplicarDescuentos(calcularPago(facturar));
    }

    @Override
    public Facturar calcularPago(Facturar facturar) {
        long horasRecargo = Factura.horasRecargo(facturar.getFactura().getFechaInicio(), facturar.getHistorialReserva().getFecha());
        long horasTotal = Factura.calcularHoras(facturar.getFactura().getFechaInicio(), facturar.getFactura().getFechaFin());
        Double total = ReglasParqueadero.recargosPorRetardoEnConfirmarReserva(horasRecargo, PRECIO_CARRO_HORA) + Factura.calcularPagoSinRecargo(PRECIO_CARRO_HORA, PRECIO_CARRO_MEDIO_DIA, PRECIO_CARRO_DIA, horasTotal);
        facturar.getFactura().setValorTotal(total);
        return facturar;
    }

}
