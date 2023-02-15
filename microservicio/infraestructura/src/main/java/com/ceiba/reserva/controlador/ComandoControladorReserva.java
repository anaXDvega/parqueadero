package com.ceiba.reserva.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.reserva.comando.ComandoSolicitudActivarReserva;
import com.ceiba.reserva.comando.ComandoSolicitudReservar;
import com.ceiba.reserva.comando.manejador.ManejadorConfirmarReserva;
import com.ceiba.reserva.comando.manejador.ManejadorReservar;
import com.ceiba.reserva.consulta.ManejadorEliminarReserva;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reserva")
@Tag(name = "Controlador comando Reserva")
public class ComandoControladorReserva {
    private final ManejadorReservar manejadorReservar;

    private final ManejadorConfirmarReserva  manejadorConfirmarReserva;
    private final ManejadorEliminarReserva manejadorEliminarReserva;

    public ComandoControladorReserva(ManejadorReservar manejadorReservar, ManejadorConfirmarReserva manejadorConfirmarReserva, ManejadorEliminarReserva manejadorEliminarReserva) {
        this.manejadorReservar = manejadorReservar;
        this.manejadorConfirmarReserva = manejadorConfirmarReserva;
        this.manejadorEliminarReserva = manejadorEliminarReserva;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/reservar")
    @Operation(summary = "reservar", description = "Metodo utilizado para crear un nueva reserva")
    public ComandoRespuesta<Long> reservar(@RequestBody ComandoSolicitudReservar comandoSolicitudFacturar) {
        return  manejadorReservar.ejecutar(comandoSolicitudFacturar);
    }

    @PostMapping("/activarReserva")
    @Operation(summary = "activarReserva", description = "Metodo utilizado para activar una nueva reserva")
    public void activarReserva(@RequestBody ComandoSolicitudActivarReserva activarReserva) {
         manejadorConfirmarReserva.ejecutar(activarReserva);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "eliminarReserva", description ="Eliminar reservas")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarReserva.ejecutar(id);
    }
}
