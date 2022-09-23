package com.agendabierta.domain.utils;

import org.junit.jupiter.api.Test;


import org.joda.time.LocalDate;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DataUtilTest {
    @Test
    public void isDayBeforeTest(){
        Date jueves = new Date(2022,9,24);
        Date viernes = new Date(2022,9,23);
        boolean result = DataUtil.isDayBefore(jueves, viernes);
        assertTrue(result);
    }
}