update historial_reserva
set estado = :estado
where fecha <= :fecha and estado = 'PENDIENTE';