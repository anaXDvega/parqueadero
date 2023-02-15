package com.ceiba.factura.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.factura.comando.ComandoSolicitudFacturar;
import com.ceiba.factura.comando.manejador.ManejadorFacturar;
import com.ceiba.factura.modelo.entidad.Factura;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/factura")
@Tag(name = "Controlador comando Facturar")
public class ComandoControladorFactura {
    private ManejadorFacturar manejadorFacturar;

    public ComandoControladorFactura(ManejadorFacturar manejadorFacturar) {
        this.manejadorFacturar = manejadorFacturar;
    }

    @PostMapping("/facturar")
    @Operation(summary = "facturar", description = "Metodo utilizado para facturar")
    public ComandoRespuesta<Factura> facturar(@RequestBody ComandoSolicitudFacturar comandoSolicitudFacturar) {
        return  manejadorFacturar.ejecutar(comandoSolicitudFacturar);
    }
}
