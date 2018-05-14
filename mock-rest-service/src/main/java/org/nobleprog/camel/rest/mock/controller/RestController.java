package org.nobleprog.camel.rest.mock.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private static int requestCounter = 0;

    @RequestMapping(value = "/settlementDate")
    public String getNextBusinessDay(){
        LocalDate nextDay = LocalDate.now().plusDays(1);
        if(nextDay.getDayOfWeek() == DayOfWeek.SATURDAY){
            return nextDay.plusDays(2).toString();
        }else if(nextDay.getDayOfWeek() == DayOfWeek.SUNDAY){
            return nextDay.plusDays(1).toString();
        }
        return nextDay.toString();
    }

    @RequestMapping(value = "/orders")
    public String orders(){
        System.out.println("request received at "+ LocalDateTime.now());
        requestCounter++;
        if(requestCounter <=2){
            return "error";
        }
        return "success";
    }
}
