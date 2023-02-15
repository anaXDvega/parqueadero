create table factura(
 id int(11) not null auto_increment,
 id_reserva int(11) not NULL,
 fecha_inicio datetime,
 fecha_fin datetime,
 valor_total DECIMAL(10,2) not null,
 estado varchar(20) not null,
 primary key (id)
);

create table historial_reserva(
 id int(11) not null auto_increment,
 tipo_vehiculo int(4) not NULL,
 cilindraje int(5) not NULL,
 placa varchar(20) not NULL,
 fecha datetime,
 estado VARCHAR(15) not null,
 tiempo_estimado int(10),
 primary key (id)
);

