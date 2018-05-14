package org.nobleprog.camel.mock;

import org.apache.camel.builder.RouteBuilder;


public class CamelRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("jms:queue:testQueue")
                .to("mock:quote");
    }
}
