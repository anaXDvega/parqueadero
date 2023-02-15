package com.ceiba.factura.adaptador.dao;

import com.ceiba.factura.modelo.dto.FacturaDTO;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoFacturaResumen implements RowMapper<FacturaDTO>, MapperResult {
    @Override
    public FacturaDTO mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        var id = resultSet.getInt("id");
        var idReserva = resultSet.getInt("id_reserva");
        var fechaInicio = resultSet.getTimestamp("fecha_inicio");
        var fechaFin = resultSet.getTimestamp("fecha_fin");
        var valor =resultSet.getDouble("valor_total");
        var estado=resultSet.getString("estado");
        return new FacturaDTO(id, idReserva, fechaInicio.toLocalDateTime(),fechaFin.toLocalDateTime(),   valor, estado);
    }
}
