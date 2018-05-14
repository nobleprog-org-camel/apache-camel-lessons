package org.nobleprog.camel.errorhandling.redelivery.route;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RouteDefinition extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        errorHandler(defaultErrorHandler().maximumRedeliveries(3)
            .redeliveryDelay(3000)
            .retryAttemptedLogLevel(LoggingLevel.WARN));


        from("direct:startRedelivery")
                .log("Sending order to http "+body().toString())
                .to("http://localhost:8089/orders")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        if(exchange.getIn().getBody(String.class).contains("error")){
                            throw new IllegalStateException("Remote service error");
                        }

                    }
                })
                .to("mock:end");
    }
}
