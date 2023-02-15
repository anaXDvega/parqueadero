package com.ceiba.reserva.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.reserva.ValidadorReserva;
import com.ceiba.reserva.modelo.entidad.HistorialReserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.data.HistorialReservaData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ServicioReservarTest {

    @Test
    void realizarReservaSuccess(){
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        ValidadorReserva validadorReserva = Mockito.mock(ValidadorReserva.class);
        var servicioReservar = new ServicioReservar(repositorioReserva, validadorReserva);
        HistorialReserva historialReserva = HistorialReservaData.registrarReserva();
         when(repositorioReserva.crearReserva(historialReserva)).thenReturn(1L);
        servicioReservar.ejecutar(historialReserva);
        Assertions.assertTrue(historialReserva.getEstado().equals("PENDIENTE"));
        Assertions.assertNotNull(servicioReservar.ejecutar(historialReserva));
    }

    @Test
    void realizarReservaNullpointerEnPlaca(){
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        ValidadorReserva validadorReserva = Mockito.mock(ValidadorReserva.class);
        var servicioReservar = new ServicioReservar(repositorioReserva, validadorReserva);
        HistorialReserva historialReserva = HistorialReservaData.registrarReservaSinPlaca();
        when(repositorioReserva.crearReserva(historialReserva)).thenReturn(1L);
        BasePrueba.assertThrows(() -> servicioReservar.ejecutar(historialReserva), ExcepcionValorObligatorio.class, "Placa es requerida");
    }

    @Test
    void realizarReservaErrorCilindrajeMoto(){
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        ValidadorReserva validadorReserva = Mockito.mock(ValidadorReserva.class);
        var servicioReservar = new ServicioReservar(repositorioReserva, validadorReserva);
        HistorialReserva historialReserva =HistorialReservaData.registrarReservaSinCilindrajeTipoMoto();
        when(repositorioReserva.crearReserva(historialReserva)).thenReturn(1L);
        BasePrueba.assertThrows(() -> servicioReservar.ejecutar(historialReserva), ExcepcionValorObligatorio.class, "Cilindraje para motos es requerida");
    }

    @Test
    void realizarReservaCarroSinCilindraje(){
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        ValidadorReserva validadorReserva = Mockito.mock(ValidadorReserva.class);
        var servicioReservar = new ServicioReservar(repositorioReserva, validadorReserva);
        HistorialReserva historialReserva = HistorialReservaData.registrarReservaSinCilindrajeTipoCarro();
        when(repositorioReserva.crearReserva(historialReserva)).thenReturn(1L);
        Assertions.assertNotNull(servicioReservar.ejecutar(historialReserva));
        assertEquals(1L, servicioReservar.ejecutar(historialReserva));
    }

}
