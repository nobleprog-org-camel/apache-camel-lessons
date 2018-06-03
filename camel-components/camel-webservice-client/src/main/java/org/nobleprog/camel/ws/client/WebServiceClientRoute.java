package org.nobleprog.camel.ws.client;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.nobleprog.camel.webservice.api.TradeEndpoint;

public class WebServiceClientRoute extends RouteBuilder {

    public void configure() throws Exception {
        String uri = "cxf:http://localhost:8083/service?"+"serviceClass=" + TradeEndpoint.class.getName();
        from("direct:start")
                .setHeader("operationName",constant("Process"))
                .to(uri)
                .log("Received response");

    }
}
