package com.agendabierta.domain.utils;

import org.joda.time.Days;
import org.joda.time.LocalDate;

import java.util.Date;


public class DateUtil {

    public static boolean isDayBefore(Date currentDay, Date day){
        Days dia = Days.daysBetween(new LocalDate(currentDay), new LocalDate(day));
        return dia.getDays() == 1;
    }
    public static boolean isInvalidDate(Date date){
        Days dia = Days.daysBetween(new LocalDate(date), new LocalDate());
        return dia.getDays() < 0;
    }

    public static boolean isSameDay(Date currentDay, Date turn){
        Days aux = Days.daysBetween(new LocalDate(currentDay), new LocalDate(turn));
        return aux.getDays() == 0;
    }
}
