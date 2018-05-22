package org.nobleprog.karaf.service.impl;

import org.nobleprog.karaf.service.SettlementDateService;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class SettlementDateServiceImpl implements SettlementDateService {

    public String getNextBusinessDay() {

        LocalDate nextDay = LocalDate.now().plusDays(1);
        if(nextDay.getDayOfWeek() == DayOfWeek.SATURDAY){
            return nextDay.plusDays(2).toString();
        }else if(nextDay.getDayOfWeek() == DayOfWeek.SUNDAY){
            return nextDay.plusDays(1).toString();
        }
        return nextDay.toString();
    }
}
