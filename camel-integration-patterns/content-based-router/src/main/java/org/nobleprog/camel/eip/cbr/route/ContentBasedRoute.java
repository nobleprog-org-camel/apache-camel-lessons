package org.nobleprog.camel.eip.cbr.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ContentBasedRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file://camel-integration-patterns/content-based-router/data/input")
                .choice()
                .when(header("CamelFileName").endsWith("xml")).to("jms:queue:xmlOrders")
                //TODO:implement csvOrders based on file name header
                .otherwise().to("jms:queue:badOrders").stop()
                .end()
                .to("jms:queue:furtherProcessing");
    }
}
