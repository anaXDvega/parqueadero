update historial_reserva
set estado = :estado
where placa = :placa and fecha = :fecha and estado<>'FINALIZADA';