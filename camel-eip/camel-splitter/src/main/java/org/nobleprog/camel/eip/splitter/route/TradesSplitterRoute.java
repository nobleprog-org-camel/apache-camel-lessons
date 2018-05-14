package org.nobleprog.camel.eip.splitter.route;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TradesSplitterRoute extends RouteBuilder {

    @Autowired
    private TradeOrderSplitterService tradeOrderSplitterService;

    @Autowired
    private OutgoingOrderTransformerService outgoingOrderTransformerService;


    public void configure() throws Exception {
        from("cxfrs:http://localhost:8080?resourceClasses=org.nobleprog.camel.eip.splitter.rest.TradesRestService&bindingStyle=SimpleConsumer&providers=jacksonJsonProvider")
                .toD("direct:${header.operationName}");


        from("direct:createOrder")
                .split(method(outgoingOrderTransformerService), new AggregationStrategy() {
                    @Override
                    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
                        newExchange.getIn().setBody("Orders sent to stock exchanges");
                        return newExchange;
                    }
                }).parallelProcessing()
                .marshal().json(JsonLibrary.Jackson)
                .wireTap("jms:queue:fullfillTrade");


        from("direct:createOrderResponse")
                .split().method(tradeOrderSplitterService)
                .parallelProcessing()
                .marshal().json(JsonLibrary.Jackson)
                .wireTap("jms:queue:fullfillTrade");


    }

}
