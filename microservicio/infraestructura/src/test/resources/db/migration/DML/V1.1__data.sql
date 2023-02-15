insert into historial_Reserva(id, tipo_vehiculo, cilindraje, placa, fecha, estado, tiempo_estimado)
values(5,1,300, 'prueba05', '2022-12-29 13:11:00', 'FINALIZADO', 0);
insert into historial_Reserva(id, tipo_vehiculo, cilindraje, placa, fecha, estado, tiempo_estimado)
values(2,1,300, 'prueba01', '2022-12-29 13:12:00', 'ACTIVA', 0);
insert into historial_Reserva(id, tipo_vehiculo, cilindraje, placa, fecha, estado, tiempo_estimado)
values(3,2,300, 'prueba02',  '2022-12-29 13:13:00', 'PENDIENTE', 0);

insert into factura(id, id_reserva, fecha_inicio, fecha_fin, valor_total, estado )
values(5, 1, '2022-12-29 13:14:00','2022-12-29 13:15:00', '910','FINALIZADO');
insert into factura(id, id_reserva, fecha_inicio, fecha_fin, valor_total, estado )
values(2, 2,'2022-12-29 13:16:00', '2022-12-29 13:16:00', '910','ACTIVA');
insert into factura(id, id_reserva, fecha_inicio, fecha_fin, valor_total, estado )
values(3, 3, '2022-12-29 13:18:00', '2022-12-29 13:19:00', '910','FINALIZADO');