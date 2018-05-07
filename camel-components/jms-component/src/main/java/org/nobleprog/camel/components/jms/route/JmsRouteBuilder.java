package org.nobleprog.camel.components.jms.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class JmsRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("direct:start").to("jms:queue:tradeInQueue");


    }
}
