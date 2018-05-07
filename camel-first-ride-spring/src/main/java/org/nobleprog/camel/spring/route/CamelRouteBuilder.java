package org.nobleprog.camel.spring.route;

import org.apache.camel.builder.RouteBuilder;

public class CamelRouteBuilder extends RouteBuilder{
    @Override
    public void configure() throws Exception {
        from("file://camel-first-ride-spring/data/input?noop=true")
                .to("file://camel-first-ride-spring/data/output");
    }
}
