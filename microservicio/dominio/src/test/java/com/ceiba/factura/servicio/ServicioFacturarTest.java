package com.ceiba.factura.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.factura.puerto.repositorio.RepositorioFactura;
import com.ceiba.factura.servicio.data.FacturaBuildData;
import com.ceiba.reserva.modelo.entidad.HistorialReserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.data.HistorialReservaData;
import com.ceiba.utils.MensajesDeExcepcionReserva;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.time.LocalDateTime;
import java.time.Month;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ServicioFacturarTest {

    @Test
    void generarFacturaSuccessCobroMotoBajoCilindraje(){
        //dos horas de moto y 35 de recargo
        Double total = 1435.0;
        RepositorioFactura repositorioFactura = Mockito.mock(RepositorioFactura.class);
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        var servicioFacturar = new ServicioFacturar(repositorioFactura, repositorioReserva);
        Factura factura =FacturaBuildData.reconstruir();
        factura.setFechaFin(LocalDateTime.of(2022, Month.JULY, 15, 20, 00));
        Mockito.when(repositorioReserva.obtenerPorId(1)).thenReturn(HistorialReservaData.facturarMoto());
        Mockito.when(repositorioFactura.obtener(1)).thenReturn(factura);
        Factura respuesta = servicioFacturar.facturar(factura);
        Assertions.assertTrue(respuesta.getValorTotal().equals(total));
    }
    @Test
    void generarFacturaSuccessCobroMotoAltoCilindraje(){
        //dos horas de moto alto cilindraje y 60 de recargo
        Double total = 2460.0;
        RepositorioFactura repositorioFactura = Mockito.mock(RepositorioFactura.class);
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        var servicioFacturar = new ServicioFacturar(repositorioFactura, repositorioReserva);
        Factura factura =FacturaBuildData.reconstruir();
        factura.setFechaFin(LocalDateTime.of(2022, Month.JULY, 15, 20, 00));
        Mockito.when(repositorioReserva.obtenerPorId(1)).thenReturn(HistorialReservaData.facturarMotoAltoCilindraje());
        Mockito.when(repositorioFactura.obtener(1)).thenReturn(factura);
        Factura respuesta = servicioFacturar.facturar(factura);
        Assertions.assertTrue(respuesta.getValorTotal().equals(total));
    }
    @Test
    void generarFacturaSuccessCobroCarro(){
        //dos horas de carro y 35 de recargo
        Double total = 4100.0;
        RepositorioFactura repositorioFactura = Mockito.mock(RepositorioFactura.class);
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        var servicioFacturar = new ServicioFacturar(repositorioFactura, repositorioReserva);
        Factura factura =FacturaBuildData.reconstruirCarro();
        factura.setFechaFin(LocalDateTime.of(2022, Month.JULY, 15, 20, 00));
        Mockito.when(repositorioReserva.obtenerPorId(2)).thenReturn(HistorialReservaData.facturarCarro());
        Mockito.when(repositorioFactura.obtener(2)).thenReturn(factura);
        Factura respuesta = servicioFacturar.facturar(factura);
        Assertions.assertTrue(respuesta.getValorTotal().equals(total));
    }

    @Test
    void generarFacturaSuccessCobroCarroSinRecargo(){
        //dos horas de carro y 0 de recargo
        Double total = 6000.0;
        RepositorioFactura repositorioFactura = Mockito.mock(RepositorioFactura.class);
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        var servicioFacturar = new ServicioFacturar(repositorioFactura, repositorioReserva);
        Factura factura =FacturaBuildData.reconstruirCarro();
        factura.setFechaFin(LocalDateTime.of(2022, Month.JULY, 15, 21, 00));
        Mockito.when(repositorioReserva.obtenerPorId(2)).thenReturn(HistorialReservaData.facturarCarroSinRecargo());
        Mockito.when(repositorioFactura.obtener(2)).thenReturn(factura);
        Factura respuesta = servicioFacturar.facturar(factura);
        Assertions.assertTrue(respuesta.getValorTotal().equals(total));
    }


    @Test
    void generarFacturaDeMasDeUnMesSuccessCobroCarro(){
        //31 dias y 3 horas de carro y 0 de recargo
        Double total = 1288800.0;
        RepositorioFactura repositorioFactura = Mockito.mock(RepositorioFactura.class);
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        var servicioFacturar = new ServicioFacturar(repositorioFactura, repositorioReserva);
        Factura factura =FacturaBuildData.reconstruirCarro();
        Mockito.when(repositorioReserva.obtenerPorId(2)).thenReturn(HistorialReservaData.facturarCarroSinRecargo());
        Mockito.when(repositorioFactura.obtener(2)).thenReturn(factura);
        factura.setFechaFin(LocalDateTime.of(2022, Month.AUGUST, 15, 21, 00));
        Factura respuesta = servicioFacturar.facturar(factura);
        Assertions.assertTrue(respuesta.getValorTotal().equals(total));
    }

    @Test
    void generarFacturaDeMasDeUnMesSuccessCobroMoto(){
        //31 dias y 3 horas de moto y 0 de recargo
        Double total = 420390.0;
        RepositorioFactura repositorioFactura = Mockito.mock(RepositorioFactura.class);
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        var servicioFacturar = new ServicioFacturar(repositorioFactura, repositorioReserva);
        Factura factura =FacturaBuildData.reconstruirMoto();
        Mockito.when(repositorioReserva.obtenerPorId(3)).thenReturn(HistorialReservaData.facturarMotoSinRecargo());
        Mockito.when(repositorioFactura.obtener(3)).thenReturn(factura);
        factura.setFechaFin(LocalDateTime.of(2022, Month.AUGUST, 15, 21, 00));
        Factura respuesta = servicioFacturar.facturar(factura);
        Assertions.assertTrue(respuesta.getValorTotal().equals(total));
    }

    @Test
    void generarFacturaDeUnDiaSuccessCobroMotoAltoCilindraje(){
        //25 horas de moto y 0 de recargo
        Double total = 24800.0;
        RepositorioFactura repositorioFactura = Mockito.mock(RepositorioFactura.class);
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        var servicioFacturar = new ServicioFacturar(repositorioFactura, repositorioReserva);
        Factura factura =FacturaBuildData.reconstruirAltoCilindraje();
        Mockito.when(repositorioReserva.obtenerPorId(3)).thenReturn(HistorialReservaData.facturarMotoSinRecargoAltoCilindraje());
        Mockito.when(repositorioFactura.obtener(3)).thenReturn(factura);
        factura.setFechaFin(LocalDateTime.of(2022, Month.JULY, 16, 19, 00));
        Factura respuesta = servicioFacturar.facturar(factura);
        Assertions.assertTrue(respuesta.getValorTotal().equals(total));
    }
    @Test
    void generarFacturaDeMedioDiaSuccessCobroMoto(){
        //14 horas de moto cilindrajepequenio y 0 de recargo
        Double total = 8400.0;
        RepositorioFactura repositorioFactura = Mockito.mock(RepositorioFactura.class);
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        var servicioFacturar = new ServicioFacturar(repositorioFactura, repositorioReserva);
        Factura factura =FacturaBuildData.reconstruirMoto();
        Mockito.when(repositorioReserva.obtenerPorId(3)).thenReturn(HistorialReservaData.facturarMotoSinRecargo());
        Mockito.when(repositorioFactura.obtener(3)).thenReturn(factura);
        factura.setFechaFin(LocalDateTime.of(2022, Month.JULY, 16, 8, 00));
        Factura respuesta = servicioFacturar.facturar(factura);
        Assertions.assertTrue(respuesta.getValorTotal().equals(total));
    }
    @Test
    void generarFacturaSinFactura(){
        //14 horas de moto cilindrajepequenio y 0 de recargo
        Double total = 8400.0;
        RepositorioFactura repositorioFactura = Mockito.mock(RepositorioFactura.class);
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        var servicioFacturar = new ServicioFacturar(repositorioFactura, repositorioReserva);
        Factura factura =FacturaBuildData.reconstruirMoto();
        Mockito.when(repositorioReserva.obtenerPorId(3)).thenReturn(HistorialReservaData.facturarMotoSinRecargo());
        Mockito.when(repositorioFactura.obtener(3)).thenReturn(null);
        factura.setFechaFin(LocalDateTime.of(2022, Month.JULY, 16, 8, 00));
        BasePrueba.assertThrows(() ->  servicioFacturar.facturar(factura), ExcepcionValorInvalido.class, MensajesDeExcepcionReserva.NO_EXISTE_UNA_FACTURA.getMensaje());
    }
    @Test
    void crearFacturaSuccess(){
        RepositorioFactura repositorioFactura = Mockito.mock(RepositorioFactura.class);
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        var servicioFacturar = new ServicioFacturar(repositorioFactura, repositorioReserva);
          HistorialReserva historialReserva= HistorialReservaData.facturarMotoSinRecargo();
         servicioFacturar.crearFactura(historialReserva);
        verify(repositorioFactura, times(1)).crearFactura(any());
    }
}
