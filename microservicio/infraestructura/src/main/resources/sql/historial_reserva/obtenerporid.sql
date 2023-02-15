select  id, tipo_vehiculo, placa, fecha, estado, tiempo_estimado, cilindraje
from historial_reserva
where id = :placa and estado = :estado