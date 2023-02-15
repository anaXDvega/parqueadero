package com.ceiba.reserva.consulta;
import com.ceiba.reserva.modelo.dto.HistorialReservaDTO;
import com.ceiba.reserva.puerto.dao.DaoReserva;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ManejadorConsultarReservas {
private DaoReserva daoReserva;

    public ManejadorConsultarReservas(DaoReserva daoReserva) {
        this.daoReserva = daoReserva;
    }
    public HistorialReservaDTO obtener(LocalDateTime fecha, String placa){
        return daoReserva.obtenerPorPlacaYFecha(fecha,placa);
    }
}
