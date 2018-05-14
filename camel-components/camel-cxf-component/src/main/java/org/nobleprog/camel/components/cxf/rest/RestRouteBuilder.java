package org.nobleprog.camel.components.cxf.rest;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestRouteBuilder extends RouteBuilder {

    @Autowired
    private TradeProcessingService tradeProcessingService;

    @Override
    public void configure() throws Exception {
        from("cxfrs:http://localhost:8080?resourceClasses=org.nobleprog.camel.components.cxf.rest.TradeRestService&bindingStyle=SimpleConsumer&providers=jacksonJaxbJsonProvider")
                // call the route based on the operation invoked on the REST web service``
                .toD("direct:${header.operationName}");

        // routes that implement the REST services
        from("direct:createOrder")
                .bean(tradeProcessingService,"createOrder");

        from("direct:getOrder")
                .bean(tradeProcessingService, "getOrder(${header.id})");

        from("direct:updateOrder")
                .bean(tradeProcessingService, "updateOrder");

        from("direct:cancelOrder")
                .bean(tradeProcessingService, "cancelOrder(${header.id})");
    }
}
