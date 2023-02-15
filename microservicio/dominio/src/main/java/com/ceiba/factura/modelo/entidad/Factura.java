package com.ceiba.factura.modelo.entidad;

import com.ceiba.dominio.ValidadorArgumento;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import static com.ceiba.utils.ConstantesParqueadero.*;
import static com.ceiba.utils.UtilCalcularTiempo.horasEntreFechas;
import static com.ceiba.utils.UtilCalcularTiempo.localDateTime;

@Getter
public class Factura {
    private int id;

    private int idReserva;

    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;

    private Double valorTotal;
    private String estado;
    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Factura(int idReserva){
        this.idReserva = idReserva;
        this.fechaFin = LocalDateTime.now();
    }
    public Factura(int idReserva, String estado){
        this.idReserva = idReserva;
        this.fechaInicio=LocalDateTime.now();
        this.fechaFin = LocalDateTime.now();
        this.estado= estado;
        this.valorTotal= (double) 0;
    }
    public Factura(int id, int idReserva, LocalDateTime fechaFin, Double valorTotal){
        this.idReserva = idReserva;
        this.id = id;
        this.fechaFin = fechaFin;
        this.valorTotal = valorTotal;
        this.estado= ESTADO_FINALIZADA;
    }
    public Factura(int id, int idReserva, LocalDateTime fechaInicio, Double valorTotal, String estado){
        this.idReserva = idReserva;
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.valorTotal = valorTotal;
        this.estado= estado;
    }

    public static Factura reconstruir(int id, int idReserva, LocalDateTime fechaInicio,
                                      Double valorTotal, String estado) {
        ValidadorArgumento.validarObligatorio(idReserva, IDRESERVA_REQUERIDA);
        ValidadorArgumento.validarObligatorio(fechaInicio, FECHAINICIO_REQUERIDA);
        return new Factura( id, idReserva, fechaInicio,
                valorTotal, estado);
    }

    public static long horasRecargo(LocalDateTime fechaInicio,LocalDateTime fechaReserva) {
      return horasEntreFechas(fechaReserva, fechaInicio);
    }

    public static long calcularHoras(LocalDateTime fechaInicio,LocalDateTime fechaFin) {
        return horasEntreFechas(fechaInicio, fechaFin);
    }

    public static boolean mayorA15Dias(LocalDateTime fechaInicio,LocalDateTime fechaFin) {
        return horasEntreFechas(fechaInicio, fechaFin)>=QUINCE_DIAS_EN_HORAS;
    }
    public static boolean esCilindrajeGrande(int tipoVehiculo, Long cilindraje){
        return tipoVehiculo==1 && cilindraje>=CILINDRAJE_MOTO_GRANDE;
    }
    public static Double calcularPagoSinRecargo(double precioHora,double precioMedioDia,double precioDia, Long cantHoras) {
        Double total= (double) 0;
        while(cantHoras>=12) {
            if(cantHoras/24>=1) {
                total=total+precioDia;
                cantHoras =cantHoras-24;
            }else if(cantHoras/12>=1) {
                total=total+precioMedioDia;
                cantHoras =cantHoras-12;
            }
        }
        total=total+(cantHoras*precioHora);
        return total;
    }
}
