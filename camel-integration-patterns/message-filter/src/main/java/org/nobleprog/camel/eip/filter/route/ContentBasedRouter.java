package org.nobleprog.camel.eip.filter.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ContentBasedRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file://camel-integration-patterns/message-filter/data/input").choice()
                .when(header("CamelFileName").endsWith("xml")).to("jms:queue:xmlOrders")
                .when(header("CamelFileName").endsWith("csv")).to("jms:queue:csvOrders")
                .otherwise().to("jms:queue:badOrders");
    }
}
