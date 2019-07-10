package org.nobleprog.camel.component.time;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class TimerRoute  {

    public static void main(String args[]) throws Exception {
        // create CamelContext
        CamelContext context = new DefaultCamelContext();

        // add our route to the CamelContext
        context.addRoutes(new RouteBuilder() {
            public void configure() {
                from("timer://myTimer?period=2000")
                        .setBody().simple("Current time is ${header.firedTime}")
                        .log("${body}");
            }
        });

        // start the route and let it do its work
        context.start();
        Thread.sleep(5000);

        // stop the CamelContext
        context.stop();
    }
}
