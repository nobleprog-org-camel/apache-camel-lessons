package org.nobleprog.camel.eip.filter.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MessageFiltererRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("jms:queue:xmlOrders")

                .to("jms:queue:fulfillment");
    }
}
