select  id, tipo_vehiculo, placa, fecha, estado, tiempo_estimado, cilindraje
from historial_reserva
where placa = :placaVehiculo and fecha = :fecha and  estado<>'FINALIZADA'