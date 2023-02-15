package com.ceiba.reserva.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.reserva.modelo.dto.HistorialReservaDTO;
import com.ceiba.reserva.modelo.entidad.HistorialReserva;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoReserva implements RowMapper<HistorialReservaDTO>, MapperResult {
    @Override
    public HistorialReservaDTO mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        var id = resultSet.getInt("id");
        var tipoVehiculo = resultSet.getInt("tipo_vehiculo");
        var placa = resultSet.getString("placa");
        var fecha = resultSet.getTimestamp("fecha");
        var estado=resultSet.getString("estado");
        var cilindraje = resultSet.getLong("cilindraje");
        var tiempoEstimado= resultSet.getLong("tiempo_estimado");
        return new  HistorialReservaDTO(id, tipoVehiculo, placa, fecha.toLocalDateTime(), estado, cilindraje,tiempoEstimado);

    }
}
