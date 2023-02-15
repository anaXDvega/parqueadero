package com.ceiba.reserva.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.reserva.modelo.entidad.HistorialReserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.data.HistorialReservaData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;

public class ServicioConfirmarReservaTest {

    @Test
    void activarReservaRetornaSuccess(){
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        var servicioConfirmarReserva = new ServicioConfirmarReserva(repositorioReserva);
        Mockito.when(repositorioReserva.existe(any(), any())).thenReturn(true);
        Mockito.when(repositorioReserva.getReserva(any(),any() )).thenReturn(HistorialReservaData.reserva());
        HistorialReserva respuesta = servicioConfirmarReserva.ejecutar(HistorialReservaData.historialReservaActualizarBuild());
        Assertions.assertTrue(respuesta.getEstado().equals("ACTIVA"));
    }
    @Test
    void activarReservaConReservaActivaRetornaFailed(){
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        var servicioConfirmarReserva = new ServicioConfirmarReserva(repositorioReserva);
        Mockito.when(repositorioReserva.existe(any(), any())).thenReturn(false);
        BasePrueba.assertThrows(() -> servicioConfirmarReserva.ejecutar(HistorialReservaData.historialReservaActualizarBuildRetornaExisteReserva()), ExcepcionSinDatos.class, "No existe una reserva para este vehiculo");
    }

}
