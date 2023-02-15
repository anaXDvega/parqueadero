package com.ceiba.reserva.adaptador.repositorio;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.reserva.modelo.entidad.HistorialReserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

import static com.ceiba.utils.ConstantesParqueadero.ESTADO_ACTIVA;

@Repository
public class RepositorioReservaMysql implements RepositorioReserva {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "historial_reserva", value = "obtenerporid")
    private static String sqlObtenerPorId;
    @SqlStatement(namespace = "historial_reserva", value = "crear")
    private static String sqlCrearReserva;

    @SqlStatement(namespace = "historial_reserva", value = "existereserva")
    private static String sqlExiste;
    @SqlStatement(namespace = "historial_reserva", value = "actualizar")
    private static String sqlActualizar;
    @SqlStatement(namespace = "historial_reserva", value = "finalizarreserva")
    private static String sqlFinalizarReserva;
    @SqlStatement(namespace = "historial_reserva", value = "actualizarDisponibilidad")
    private static String sqlActualizarDisponibilidad;
    @SqlStatement(namespace = "historial_reserva", value = "contarvehiculosestacionados")
    private static String sqlCantVehiculosEstacionados;

    @SqlStatement(namespace = "historial_reserva", value = "obtenerporplaca")
    private static String sqlObtenerPorPlaca;

    @SqlStatement(namespace = "historial_reserva", value = "eliminar")
    private static String sqlEliminar;
    public RepositorioReservaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }


    @Override
    public Long crearReserva(HistorialReserva historialReserva) {
    return customNamedParameterJdbcTemplate.crear(historialReserva, sqlCrearReserva);
    }

    @Override
    public void actualizar(HistorialReserva historialReserva) {
        this.customNamedParameterJdbcTemplate.actualizar(historialReserva, sqlActualizar);
    }
    @Override
    public void finalizarReserva(HistorialReserva historialReserva) {
        this.customNamedParameterJdbcTemplate.actualizar(historialReserva, sqlFinalizarReserva);
    }
    @Override
    public boolean existe(String placa, LocalDateTime fecha) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("placa", placa);
        paramSource.addValue("fecha", fecha);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, paramSource, Boolean.class);
    }

    @Override
    public HistorialReserva getReserva(String placa, LocalDateTime fecha) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("placaVehiculo", placa);
        paramSource.addValue("fecha", fecha);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() ->
                this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPorPlaca,
                        paramSource, new MapeoHistorialReserva()));

    }

    @Override
    public HistorialReserva obtenerPorId(int placa) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("placa", placa).addValue("estado", ESTADO_ACTIVA);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlObtenerPorId,paramSource, new MapeoHistorialReserva()));
    }

    @Override
    public int cantidadDeEstacionamientosDisponibles(int tipoDeVehiculo) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("tipoVehiculo", tipoDeVehiculo);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlCantVehiculosEstacionados, paramSource, int.class);
    }

    @Override
    public void actualizarEstacionamientosDisponibles(LocalDateTime horaActual) {
        this.customNamedParameterJdbcTemplate.actualizar(new HistorialReserva(horaActual), sqlActualizarDisponibilidad);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }
}
