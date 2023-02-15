package com.ceiba.reserva.servicio;

import com.ceiba.reserva.modelo.entidad.HistorialReserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.data.HistorialReservaData;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ServicioEliminarReservaTest {
    @Test
    void validarEliminarCartelera() {
        Long Id = 1L;
        HistorialReserva historialReserva = HistorialReservaData.buildEliminar();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.existe(any(), any())).thenReturn(true);
        ServicioEliminarReserva servicioEliminarReserva = new ServicioEliminarReserva(repositorioReserva);
        servicioEliminarReserva.ejecutar(Id);
        verify(repositorioReserva, times(1)).eliminar(Long.valueOf(historialReserva.getId()));
    }
}
