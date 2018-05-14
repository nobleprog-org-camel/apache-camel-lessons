package org.nobleprog.camel.errorhandling.scopped;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

public class ContextAndRouteScoppedErrorHandling extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        errorHandler(defaultErrorHandler().maximumRedeliveries(3)
                .redeliveryDelay(3000)
                .retryAttemptedLogLevel(LoggingLevel.WARN));


        from("direct:startRedelivery")
                .errorHandler(deadLetterChannel("mock:dead")
                        .asyncDelayedRedelivery()
                        .maximumRedeliveries(2)
                        .redeliveryDelay(1000)
                        .retryAttemptedLogLevel(LoggingLevel.WARN))
                .to("http://localhost:8080/orders")
                .to("direct:end");
    }
}
