package com.ceiba.reserva.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.reserva.modelo.entidad.HistorialReserva;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoHistorialReserva implements RowMapper<HistorialReserva>, MapperResult {

    @Override
    public HistorialReserva mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        var id = resultSet.getInt("id");
        var tipoVehiculo = resultSet.getInt("tipo_vehiculo");
        var placa = resultSet.getString("placa");
        var fecha = resultSet.getTimestamp("fecha");
        var estado=resultSet.getString("estado");
        var cilindraje = resultSet.getLong("cilindraje");
        var tiempoEstimado= resultSet.getLong("tiempo_estimado");
        return HistorialReserva.reconstruir(id, tipoVehiculo, placa, fecha.toLocalDateTime(), cilindraje,tiempoEstimado, estado);
    }

}
