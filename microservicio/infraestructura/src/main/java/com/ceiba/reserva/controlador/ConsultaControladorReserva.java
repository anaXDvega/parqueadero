package com.ceiba.reserva.controlador;

import com.ceiba.reserva.comando.ComandoSolicitudReservar;
import com.ceiba.reserva.consulta.ManejadorConsultarReservas;
import com.ceiba.reserva.consulta.ManejadorEliminarReserva;
import com.ceiba.reserva.modelo.dto.HistorialReservaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reserva")
@Tag(name = "Consulta comando reserva")
public class ConsultaControladorReserva {
    private final ManejadorConsultarReservas manejadorReservar;

    public ConsultaControladorReserva(ManejadorConsultarReservas manejadorReservar) {
        this.manejadorReservar = manejadorReservar;
      }

    @PostMapping("/consultarReservas")
    @Operation(summary = "consultarReservas", description = "Metodo utilizado para consultar las reservas")
    public HistorialReservaDTO consultarReservas(@RequestBody ComandoSolicitudReservar comandoSolicitudFacturar) {
       return manejadorReservar.obtener(comandoSolicitudFacturar.getFecha(), comandoSolicitudFacturar.getPlaca());
    }
}
