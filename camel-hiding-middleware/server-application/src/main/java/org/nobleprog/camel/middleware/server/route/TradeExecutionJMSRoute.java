package org.nobleprog.camel.middleware.server.route;

import org.apache.camel.builder.RouteBuilder;
import org.nobleprog.camel.middleware.domain.service.TradeExecutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TradeExecutionJMSRoute extends RouteBuilder {

    @Autowired
    private TradeExecutionService tradeExecutionService;

    @Override
    public void configure() throws Exception {
        from("jms:queue:trade")
                .log("Received body ${body}")
                .bean(tradeExecutionService);
    }
}
