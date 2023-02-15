package com.ceiba.factura.servicio;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.factura.modelo.entidad.Facturar;
import com.ceiba.factura.puerto.repositorio.RepositorioFactura;
import com.ceiba.reserva.modelo.entidad.HistorialReserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.utils.MensajesDeExcepcionReserva;

public class ServicioFacturar {

    private RepositorioFactura repositorioFactura;

    private RepositorioReserva repositorioReserva;

    public ServicioFacturar(RepositorioFactura repositorioFactura, RepositorioReserva repositorioReserva) {
        this.repositorioFactura = repositorioFactura;
        this.repositorioReserva = repositorioReserva;
    }

    public Factura facturar(Factura factura){
        Facturar generarCobro= generarCobro(buildFacturar(factura));
        repositorioFactura.actualizarFactura(generarCobro);
        repositorioReserva.finalizarReserva(HistorialReserva.finalizarReserva(generarCobro.getHistorialReserva().getId()));
        return new Factura(generarCobro.getFactura().getId(), factura.getIdReserva(), generarCobro.getFactura().getFechaFin(), generarCobro.getFactura().getValorTotal());
    }
    public Facturar buildFacturar(Factura factura){
        HistorialReserva historialReserva = repositorioReserva.obtenerPorId(factura.getIdReserva());
        return new Facturar(getFactura(factura),historialReserva);
    }
    public Factura getFactura(Factura factura){
        Factura facturaDTO = repositorioFactura.obtener(factura.getIdReserva());
        if (facturaDTO==null) {
            throw new ExcepcionValorInvalido(MensajesDeExcepcionReserva.NO_EXISTE_UNA_FACTURA.getMensaje());
        }
        facturaDTO.setFechaFin(factura.getFechaFin());
        return facturaDTO;
    }
    private Facturar generarCobro(Facturar facturar){
        GenerarCobroVehiculo elegirTipoVehiculo = elegirTipoVehiculo(facturar.getHistorialReserva().getTipoVehiculo());
        GenerarCobro generarCobro = new GenerarCobro(elegirTipoVehiculo);
        return (generarCobro.executeStrategy(facturar));
    }
    public void crearFactura(HistorialReserva historialReserva){
        repositorioFactura.crearFactura(new Factura(historialReserva.getId(), historialReserva.getEstado()));
    }
    public static GenerarCobroVehiculo elegirTipoVehiculo(int vehiculo) {
        GenerarCobroVehiculo strategy;
        if (vehiculo==1) {
            strategy = new GenerarCobroMoto();
        } else{
            strategy = new GenerarCobroCarro();
        }
        return strategy;
    }
}
