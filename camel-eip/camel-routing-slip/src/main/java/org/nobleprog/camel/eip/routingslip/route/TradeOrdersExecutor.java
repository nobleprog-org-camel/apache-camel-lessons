package org.nobleprog.camel.eip.routingslip.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.nobleprog.camel.eip.routingslip.model.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TradeOrdersExecutor extends RouteBuilder{
    @Autowired
    private TradeExecutionService tradeExecutionService;

    @Override
    public void configure() throws Exception {
        from("jms:queue:fullfillTrade")
                .log("trade.recieved.is ${body}")
                .unmarshal().json(JsonLibrary.Jackson, Trade.class)
                .bean(tradeExecutionService,"executeTrade")
                .marshal().json(JsonLibrary.Jackson)
                .to("jms:queue:processedOrder");
    }
}
