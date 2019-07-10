package org.nobleprog.camel.component.custom.consumer;

import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.impl.ScheduledPollConsumer;

import java.time.LocalDateTime;

public class MyConsumer extends ScheduledPollConsumer {

    public MyConsumer(Endpoint endpoint, Processor processor) {
        super(endpoint, processor);
    }

    @Override
    protected int poll() throws Exception {
        final Exchange exchange = getEndpoint().createExchange();
        LocalDateTime now = LocalDateTime.now();
        exchange.getIn().setBody("Hello World! The time is " + now);
        try {
            getProcessor().process(exchange);
        } finally {
            if(exchange.getException() != null){
                getExceptionHandler().handleException("Exception in custom component",exchange, exchange.getException());
            }
        }
        return 1;
    }
}
