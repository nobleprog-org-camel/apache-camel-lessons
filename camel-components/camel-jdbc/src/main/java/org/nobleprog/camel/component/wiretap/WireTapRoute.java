package org.nobleprog.camel.component.wiretap;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.builder.ThreadPoolBuilder;

import java.util.concurrent.ExecutorService;

public class WireTapRoute extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        ExecutorService lowPool = new ThreadPoolBuilder(getContext())
                .poolSize(1).maxPoolSize(5).build("LowPool");

        from("direct:start")
                .log("Incoming message ${body}")
                .wireTap("direct:tap")
                //.executorService(lowPool)
                .to("mock:result");

        from("direct:tap")
                .log("Tapped message ${body}")
                .to("mock:tap");
    }
}
