package org.nobleprog.camel.beans.annotated;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import static org.junit.Assert.*;


public class AnnotatedBeanMethodRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new AnnotatedBeanMethodRoute();
    }

    @Test
    public void invokeAnnotatedMethodTest(){
        MockEndpoint endHardWay = getMockEndpoint("mock:endHandler");

        endHardWay.whenAnyExchangeReceived(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                log.info("Received body "+ exchange.getIn().getBody());
            }
        });

        template.sendBody("direct:startHandler","Message Body");


    }

}