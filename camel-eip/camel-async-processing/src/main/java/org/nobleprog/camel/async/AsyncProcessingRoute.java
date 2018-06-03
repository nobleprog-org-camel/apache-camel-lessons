package org.nobleprog.camel.async;


import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

import java.time.LocalDateTime;

public class AsyncProcessingRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:start")
                .log("Recieved ${body}")
                .to("seda:processAsync")
                .end()
        ;

        from("seda:processAsync?concurrentConsumers=1")
                .delay(3000)
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        System.out.println("Processing "+ exchange.getIn().getBody() + " at " + LocalDateTime.now() +" "+Thread.currentThread().getName());
                      }
                });
    }
}
