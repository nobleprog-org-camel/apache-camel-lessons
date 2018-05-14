package org.nobleprog.camel.errorhandling.redelivery.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

public class AsyncRedeliverableRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        errorHandler(deadLetterChannel("mock:dead")
            .asyncDelayedRedelivery()
                .maximumRedeliveries(2)
                .redeliveryDelay(1000)
                .retryAttemptedLogLevel(LoggingLevel.WARN)
        );

        from("direct:startAsyncRedelivery")
                .to("http://localhost:8080/orders")
                .to("direct:end");
    }
}
