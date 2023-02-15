package com.ceiba.factura.controlador;
import com.ceiba.factura.consulta.ManejadorConsultarFactura;
import com.ceiba.factura.modelo.dto.FacturaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/factura")
@Tag(name = "Consulta comando factura")
public class ConsultaControladorFactura {

    private final ManejadorConsultarFactura manejadorConsultarFactura;

    public ConsultaControladorFactura(ManejadorConsultarFactura manejadorConsultarFactura) {
        this.manejadorConsultarFactura = manejadorConsultarFactura;
    }
    @GetMapping
    @Operation(summary = "Factura", description = "Metodo utilizado para consultar facturas")
    public List<FacturaDTO> facturar() {
        return manejadorConsultarFactura.obtenerFacturas();
    }
    @GetMapping("/{id}")
    @Operation(summary = "Factura", description = "Metodo utilizado para consultar facturas por id")
    public FacturaDTO facturar(@PathVariable int id) {
        return manejadorConsultarFactura.obtenerPorId(id);
    }
}
