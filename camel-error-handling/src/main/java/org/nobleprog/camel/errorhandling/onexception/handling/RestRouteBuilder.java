package org.nobleprog.camel.errorhandling.onexception.handling;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.nobleprog.camel.errorhandling.onexception.handling.service.TradeStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;

@Component
public class RestRouteBuilder extends RouteBuilder {

    @Autowired
    private TradeStatusService tradeStatusService;

    @Override
    public void configure() throws Exception {

        onException(TestOrderNotSupportedExccption.class)
                .handled(true)
                .process(new Processor() {
                             @Override
                             public void process(Exchange exchange) throws Exception {
                                 exchange.getIn().setBody(Response.status(Response.Status.BAD_REQUEST).entity("Test order are bad").build());
                             }
                         }
                );

        from("cxfrs:http://localhost:8080?resourceClasses=org.nobleprog.camel.errorhandling.onexception.handling.TradeRestService&bindingStyle=SimpleConsumer")
                //Note: In order to use dynamic values from the header we have to use toD() instead of to()
                .toD("direct:${header.operationName}");


        from("direct:getOrderStatus")
                .bean(tradeStatusService, "statusOf")
                .process(new Processor() {
                    public void process(Exchange exchange) throws Exception {
                        String response = exchange.getIn().getBody(String.class);
                        Response restResposne = Response.ok().entity(response).build();
                        exchange.getIn().setBody(restResposne);
                    }
                });

    }
}
