package org.nobleprog.camel.errorhandling.deadletterchannel.service;

import org.springframework.stereotype.Component;

@Component
public class TradeOrderService {


    public String validate(String order){
        return order;
    }

    public String enrich(String order){
        throw new IllegalArgumentException("Can not enrich this order");
    }

    public String decrypt(String order){
        return order.concat("decrypt");
    }
}
