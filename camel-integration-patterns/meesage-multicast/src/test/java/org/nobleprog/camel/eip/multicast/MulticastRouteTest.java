package org.nobleprog.camel.eip.multicast;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import static org.junit.Assert.*;

public class MulticastRouteTest extends CamelTestSupport{
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new MulticastRoute();
    }

    @Test
    public void testMulticast(){
        MockEndpoint consumerA = getMockEndpoint("mock:consumerA");
        MockEndpoint consumerB = getMockEndpoint("mock:consumerB");

        consumerA.whenAnyExchangeReceived(exchange -> log.info("Recieved message "+exchange.getIn().getBody()));
        consumerB.whenAnyExchangeReceived(exchange -> log.info("Recieved message "+exchange.getIn().getBody()));

        template.sendBody("direct:multicast","Send to all consumers");
    }

    @Test
    public void testMulticastParallel(){
        MockEndpoint consumerA = getMockEndpoint("mock:consumerA");
        MockEndpoint consumerB = getMockEndpoint("mock:consumerB");

        consumerA.whenAnyExchangeReceived(exchange -> log.info("Recieved message "+exchange.getIn().getBody()));
        consumerB.whenAnyExchangeReceived(exchange -> log.info("Recieved message "+exchange.getIn().getBody()));

        template.sendBody("direct:multicastParallel","Send to all consumers");
    }
}