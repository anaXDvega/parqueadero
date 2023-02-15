update factura
set estado = :estado,
 fecha_fin = CAST(:fechaFin AS DATETIME),
 valor_total = :valorTotal
where id = :id