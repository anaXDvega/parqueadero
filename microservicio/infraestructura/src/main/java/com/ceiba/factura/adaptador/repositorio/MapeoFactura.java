package com.ceiba.factura.adaptador.repositorio;
import com.ceiba.factura.modelo.dto.FacturaDTO;
import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class MapeoFactura implements RowMapper<Factura>, MapperResult {
    @Override
    public Factura mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        var id = resultSet.getInt("id");
        var idReserva = resultSet.getInt("id_reserva");
        var fechaInicio = resultSet.getTimestamp("fecha_inicio");
        var valor =resultSet.getDouble("valor_total");
        var estado=resultSet.getString("estado");
        return Factura.reconstruir(id, idReserva, fechaInicio.toLocalDateTime(),  valor, estado);
    }
}
