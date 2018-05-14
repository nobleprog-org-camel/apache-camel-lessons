package org.nobleprog.camel.config.springjava.config;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RouteDefinition extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file://camel-spring-java-config/data/input")
                .to("file://camel-spring-java-config/data/output");
    }
}
