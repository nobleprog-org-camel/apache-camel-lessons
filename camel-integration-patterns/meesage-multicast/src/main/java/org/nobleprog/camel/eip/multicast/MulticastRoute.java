package org.nobleprog.camel.eip.multicast;

import org.apache.camel.builder.RouteBuilder;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MulticastRoute extends RouteBuilder {

    ExecutorService executor = Executors.newFixedThreadPool(15);

    @Override
    public void configure() throws Exception {
        from("direct:multicast")
                .log("Sending same message to all recipients ${body}")
                .multicast()
                .to("mock:consumerA").to("mock:consumerB");

        from("direct:multicastParallel")
                .log("Sending same message to all recipients in parallel")
                .multicast()

                .to("mock:consumerA").to("mock:consumerB");
    }
}
