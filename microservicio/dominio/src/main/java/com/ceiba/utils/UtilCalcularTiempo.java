package com.ceiba.utils;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;


public final  class UtilCalcularTiempo {

    private UtilCalcularTiempo(){
        super();
    }
    public static LocalDateTime localDateTime(Date currentDate) {
        return currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
    public static Boolean validarFinesDeSemana(LocalDateTime fecha) {
        DayOfWeek diaHoy = diaSemana(fecha);
        return (diaHoy == DayOfWeek.SUNDAY || diaHoy == DayOfWeek.SATURDAY);
    }
    public static long horasEntreFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return ChronoUnit.HOURS.between(fechaInicio, fechaFin);
    }

    public static DayOfWeek diaSemana(LocalDateTime fecha) {
         return fecha.getDayOfWeek();
    }
   public static LocalDateTime sumarMinutos(Date tuFechaBase,int minutosASumar){
       Calendar calendar = Calendar.getInstance();
       calendar.setTime(tuFechaBase);
       calendar.add(Calendar.MINUTE, minutosASumar);
       return  localDateTime(calendar.getTime());
   }
}
