package org.nobleprog.camel.component.custom;

import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

import java.util.concurrent.TimeUnit;

public class Application {

    public static void main(String[] args) throws Exception {
        CamelContext camelContext = new DefaultCamelContext();
        camelContext.addRoutes(createRoute());
        camelContext.start();
        TimeUnit.MINUTES.sleep(2);
        camelContext.stop();
    }

    private static RoutesBuilder createRoute() {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("mycomponent:uri_part")
                        .to("mycomponent:uri_part");
            }
        };

    }
}
