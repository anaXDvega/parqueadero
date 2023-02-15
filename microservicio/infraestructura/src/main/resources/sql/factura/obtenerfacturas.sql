select  id, id_reserva, fecha_inicio, fecha_fin, valor_total, estado
from factura
where estado<>'ANULADA'