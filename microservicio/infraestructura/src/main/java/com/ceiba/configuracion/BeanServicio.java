package com.ceiba.configuracion;
import com.ceiba.factura.puerto.repositorio.RepositorioFactura;
import com.ceiba.factura.servicio.ServicioFacturar;
import com.ceiba.reserva.ValidadorReserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.ServicioEliminarReserva;
import com.ceiba.reserva.servicio.ServicioConfirmarReserva;
import com.ceiba.reserva.servicio.ServicioReservar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {


    @Bean
    public ServicioReservar servicioReserva(RepositorioReserva repositorioReserva, ValidadorReserva validadorReserva) {
        return new ServicioReservar(repositorioReserva, validadorReserva);
    }
    @Bean
    public ServicioConfirmarReserva servicioConfirmarReserva(RepositorioReserva repositorioReserva) {
        return new ServicioConfirmarReserva(repositorioReserva);
    }

    @Bean
    public ServicioEliminarReserva eliminarReservaServicio(RepositorioReserva repositorioReserva) {
        return new ServicioEliminarReserva(repositorioReserva);
    }
    @Bean
    public ValidadorReserva validadorReserva(RepositorioReserva repositorioReserva) {
        return new ValidadorReserva(repositorioReserva);
    }

    @Bean
    public ServicioFacturar servicioFacturar(RepositorioFactura repositorioFactura, RepositorioReserva repositorioReserva) {
        return new ServicioFacturar(repositorioFactura,repositorioReserva);
    }
}
