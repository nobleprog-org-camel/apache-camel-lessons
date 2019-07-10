package org.nobleprog.camel.component.custom.producer;

import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultProducer;

public class MyProducer extends DefaultProducer {

    public MyProducer(Endpoint endpoint) {
        super(endpoint);
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("The response is " + exchange.getIn().getBody(String.class));
    }
}
