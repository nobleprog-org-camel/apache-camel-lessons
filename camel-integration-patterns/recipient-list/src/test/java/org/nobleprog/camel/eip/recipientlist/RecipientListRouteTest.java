package org.nobleprog.camel.eip.recipientlist;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipientListRouteTest extends CamelTestSupport{
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new RecipientListRoute();
    }

    @Test
    public void testRecipientLiss(){
        MockEndpoint consumerA = getMockEndpoint("mock:consumerA");
        MockEndpoint consumerB = getMockEndpoint("mock:consumerB");

        consumerA.whenAnyExchangeReceived(exchange -> {
            log.info("Recieved message " + exchange.getIn().getBody());
            exchange.getIn().setBody(" Consumer A response ");
        });
        consumerB.whenAnyExchangeReceived(exchange -> {
            log.info("Recieved message " + exchange.getIn().getBody());
            exchange.getIn().setBody(" Consumer B response ");
        });

        template.sendBody("direct:recipientList","Send to multiple");

    }
}