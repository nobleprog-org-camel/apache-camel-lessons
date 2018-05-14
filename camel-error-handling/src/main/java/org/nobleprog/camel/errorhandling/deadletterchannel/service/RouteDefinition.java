package org.nobleprog.camel.errorhandling.deadletterchannel.service;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RouteDefinition extends RouteBuilder {

    @Autowired
    private TradeOrderService tradeOrderService;

    @Override
    public void configure() throws Exception {

        errorHandler(deadLetterChannel("jms:queue:dead"));
        //errorHandler(deadLetterChannel("jms:queue:dead").useOriginalMessage());

        from("direct:start").routeId("tradeRoute")
                .bean("tradeOrderService", "decrypt")
                .bean("tradeOrderService", "validate")
                .bean("tradeOrderService", "enrich")
                .to("jms:queue:order");
    }
}
