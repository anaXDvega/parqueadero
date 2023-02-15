package com.ceiba.factura.adaptador.repositorio;

import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.factura.modelo.entidad.Facturar;
import com.ceiba.factura.puerto.repositorio.RepositorioFactura;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
@Repository
public class RepositorioFacturaMysql  implements RepositorioFactura {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "factura", value = "crear")
    private static String sqlCrearFactura;

    @SqlStatement(namespace = "factura", value = "actualizar")
    private static String sqlActualizarFactura;
    @SqlStatement(namespace = "factura", value = "obtenerporidreserva")
    private static String sqlObtenerPorIdReserva;
    private final MapeoFactura mapeoFactura;

    public RepositorioFacturaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoFactura mapeoFactura) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoFactura = mapeoFactura;
    }

    @Override
    public void actualizarFactura(Facturar facturar) {
        this.customNamedParameterJdbcTemplate.actualizar(new Factura(facturar.getFactura().getId(), facturar.getFactura().getIdReserva(), facturar.getFactura().getFechaFin(), facturar.getFactura().getValorTotal()), sqlActualizarFactura);
    }
    @Override
    public Long crearFactura(Factura factura) {
        return customNamedParameterJdbcTemplate.crear(factura, sqlCrearFactura);
    }

    @Override
    public Factura obtener(int id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlObtenerPorIdReserva,paramSource,  mapeoFactura));
    }
}
