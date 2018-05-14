package org.nobleprog.camel.eip.cbr.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ContentBasedRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file://camel-integration-patterns/content-based-router/data/input").choice()
                .when(header("CamelFileName").endsWith("xml")).to("jms:queue:xmlOrders")
                .when(header("CamelFileName").endsWith("csv")).to("jms:queue:csvOrders")
                .otherwise().to("jms:queue:badOrders").stop()
                .end()
                .to("jms:queue:furtherProcessing");
    }
}