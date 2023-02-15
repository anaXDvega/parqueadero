package com.ceiba.reserva.modelo.entidad;

import com.ceiba.dominio.ValidadorArgumento;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.utils.ConstantesParqueadero.*;

@Getter
public class HistorialReserva {
    private int id;

    private int tipoVehiculo;

    private Long cilindraje;

    private String placa;

    private LocalDateTime fecha;

    private Long tiempoEstimado;

    private String estado;
    public HistorialReserva(int tipoVehiculo, String placa, LocalDateTime fecha, Long cilindraje, Long tiempoEstimado){
        this.tipoVehiculo = tipoVehiculo;
        this.placa=placa;
        this.fecha=fecha;
        this.estado= ESTADO_PENDIENTE;
        this.cilindraje=cilindraje;
        this.tiempoEstimado=tiempoEstimado;
    }

    public HistorialReserva(int id ,int tipoVehiculo, String placa, LocalDateTime fecha, Long cilindraje, Long tiempoEstimado,String estado){
        this.id = id;
        this.tipoVehiculo = tipoVehiculo;
        this.placa=placa;
        this.fecha=fecha;
        this.estado= estado;
        this.cilindraje=cilindraje;
        this.tiempoEstimado=tiempoEstimado;
    }
    public HistorialReserva(LocalDateTime fecha,String placa){
        this.placa=placa;
        this.fecha=fecha;
        this.estado= ESTADO_ACTIVA;
     }
    public HistorialReserva(LocalDateTime fecha){
        this.fecha=fecha;
        this.estado= ESTADO_ANULADA;
    }

    public HistorialReserva(int id){
        this.id=id;
        this.estado= ESTADO_FINALIZADA;
    }
    public static HistorialReserva actualizar(LocalDateTime fecha, String placa) {
        ValidadorArgumento.validarObligatorio(placa, PLACA_REQUERIDA);
        ValidadorArgumento.validarObligatorio(fecha, FECHA_REQUERIDA);
        return new HistorialReserva(fecha,placa);
    }

    public static HistorialReserva finalizarReserva(int id) {
        return new HistorialReserva(id);
    }
    public static boolean esDiaCompleto(Long tiempoEstimado){
        return tiempoEstimado>=24;
    }

    public static HistorialReserva reservar(HistorialReserva historialReserva) {
        ValidadorArgumento.validarObligatorio(historialReserva.getPlaca(), PLACA_REQUERIDA);
        ValidadorArgumento.validarObligatorio(historialReserva.getTipoVehiculo(), TIPOVEHICULO_REQUERIDO);
        ValidadorArgumento.validarObligatorio(historialReserva.getFecha(), FECHA_REQUERIDA);
        if(historialReserva.getTipoVehiculo()==1){
            ValidadorArgumento.validarObligatorio(historialReserva.getCilindraje(), CILINDRAJE_REQUERIDO);
        }
        return new HistorialReserva( historialReserva.getTipoVehiculo(), historialReserva.getPlaca(), historialReserva.getFecha(), historialReserva.getCilindraje(), historialReserva.getTiempoEstimado());
    }
    public static HistorialReserva reconstruir(int id, int tipoVehiculo, String placa,LocalDateTime  fecha,Long cilindraje, Long tiempoEstimado,String  estado) {
        ValidadorArgumento.validarObligatorio(placa, PLACA_REQUERIDA);
        ValidadorArgumento.validarObligatorio(tipoVehiculo, TIPOVEHICULO_REQUERIDO);
        ValidadorArgumento.validarObligatorio(fecha, FECHA_REQUERIDA);
        if(tipoVehiculo==1){
            ValidadorArgumento.validarObligatorio(cilindraje, CILINDRAJE_REQUERIDO);
        }
        return new HistorialReserva(id, tipoVehiculo,placa,fecha,cilindraje,tiempoEstimado, estado);
    }
}
