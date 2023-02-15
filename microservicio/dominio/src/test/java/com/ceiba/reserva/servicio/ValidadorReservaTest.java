package com.ceiba.reserva.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.reserva.ValidadorReserva;
import com.ceiba.reserva.modelo.entidad.HistorialReserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.data.HistorialReservaData;
import com.ceiba.reserva.servicio.data.HistorialReservaDataBuilder;
import com.ceiba.utils.MensajesDeExcepcionReserva;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.time.Month;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ValidadorReservaTest {

    @Test
    void validarExistenciaReservaRetornaSuccess(){
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        var validadorReserva = new ValidadorReserva(repositorioReserva);
        HistorialReserva historialReserva = HistorialReservaData.reserva();
        when(repositorioReserva.existe(any(), any())).thenReturn(false);
       validadorReserva.validarReserva(historialReserva);
       verify(repositorioReserva, times(1)).existe(historialReserva.getPlaca(), historialReserva.getFecha());
    }

    @Test
    void validarExistenciaReservaRetornaFail(){
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        var validadorReserva = new ValidadorReserva(repositorioReserva);
        HistorialReserva historialReserva =HistorialReservaData.reserva();
        when(repositorioReserva.existe(any(), any())).thenReturn(true);
        BasePrueba.assertThrows(() ->  validadorReserva.validarReserva(historialReserva), ExcepcionDuplicidad.class, MensajesDeExcepcionReserva.EXISTE_UNA_RESERVA.getMensaje());
    }

    @Test
    void validarDisponibilidadCarroFDSRetornaFail(){
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        var validadorReserva = new ValidadorReserva(repositorioReserva);
        HistorialReserva historialReserva = HistorialReservaData.historialReservaCarroFDS();
        when(repositorioReserva.cantidadDeEstacionamientosDisponibles(2)).thenReturn(37);
       BasePrueba.assertThrows(() ->  validadorReserva.validarDisponibilidad(historialReserva), ExcepcionDuplicidad.class, MensajesDeExcepcionReserva.CUPO_LLENO.getMensaje());
    }
    @Test
    void validarDisponibilidadCarroEntreSemanaRetornaFail(){
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        var validadorReserva = new ValidadorReserva(repositorioReserva);
        HistorialReserva historialReserva = HistorialReservaData.historialReservaCarroEntreSemana();
        when(repositorioReserva.cantidadDeEstacionamientosDisponibles(2)).thenReturn(30);
        BasePrueba.assertThrows(() ->  validadorReserva.validarDisponibilidad(historialReserva), ExcepcionDuplicidad.class, MensajesDeExcepcionReserva.CUPO_LLENO.getMensaje());
    }

    @Test
    void validarDisponibilidadMotoEntreSemanaRetornaSucces(){
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        var validadorReserva = new ValidadorReserva(repositorioReserva);
        HistorialReserva historialReserva = HistorialReservaData.reserva();
        when(repositorioReserva.cantidadDeEstacionamientosDisponibles(1)).thenReturn(18);
        validadorReserva.validarDisponibilidad(historialReserva);
        verify(repositorioReserva, times(1)).cantidadDeEstacionamientosDisponibles(1);
    }

    @Test
    void validarDisponibilidadCarroEntreSemanaRetornaSucces(){
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        var validadorReserva = new ValidadorReserva(repositorioReserva);
        HistorialReserva historialReserva = HistorialReservaData.historialReservaCarroEntreSemana();
        when(repositorioReserva.cantidadDeEstacionamientosDisponibles(2)).thenReturn(18);
        validadorReserva.validarDisponibilidad(historialReserva);
        verify(repositorioReserva, times(1)).cantidadDeEstacionamientosDisponibles(2);

    }

    @Test
    void validarDisponibilidadMotoFDSRetornaSuccess(){
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        var validadorReserva = new ValidadorReserva(repositorioReserva);
        HistorialReserva historialReserva =HistorialReservaData.historialReservaMotoFDS();
        when(repositorioReserva.cantidadDeEstacionamientosDisponibles(1)).thenReturn(5);
        validadorReserva.validarDisponibilidad(historialReserva);
        verify(repositorioReserva, times(1)).cantidadDeEstacionamientosDisponibles(1);
    }

    @Test
    void validarDisponibilidadMotoFDSRetornaFail(){
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        var validadorReserva = new ValidadorReserva(repositorioReserva);
        HistorialReserva historialReserva =HistorialReservaData.historialReservaMotoFDS();
        when(repositorioReserva.cantidadDeEstacionamientosDisponibles(1)).thenReturn(6);
        BasePrueba.assertThrows(() ->  validadorReserva.validarDisponibilidad(historialReserva), ExcepcionDuplicidad.class, MensajesDeExcepcionReserva.CUPO_LLENO.getMensaje());
    }

    @Test
    void validarDisponibilidadMotoEntreSemanaRetornaFail(){
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        var validadorReserva = new ValidadorReserva(repositorioReserva);
        HistorialReserva historialReserva =HistorialReservaData.historialReservaMotoEntreSemana();
        when(repositorioReserva.cantidadDeEstacionamientosDisponibles(1)).thenReturn(20);
        BasePrueba.assertThrows(() ->  validadorReserva.validarDisponibilidad(historialReserva), ExcepcionDuplicidad.class, MensajesDeExcepcionReserva.CUPO_LLENO.getMensaje());
    }
    @Test
    void validarDisponibilidadMotoEntreSemanaRetornaSuccess(){
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        var validadorReserva = new ValidadorReserva(repositorioReserva);
        HistorialReserva historialReserva =HistorialReservaData.historialReservaMotoEntreSemana();
        when(repositorioReserva.cantidadDeEstacionamientosDisponibles(1)).thenReturn(5);
        validadorReserva.validarDisponibilidad(historialReserva);
        verify(repositorioReserva, times(1)).cantidadDeEstacionamientosDisponibles(1);
    }
}
