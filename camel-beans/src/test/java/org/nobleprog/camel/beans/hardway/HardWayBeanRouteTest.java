package org.nobleprog.camel.beans.hardway;

import static org.junit.Assert.*;


import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class HardWayBeanRouteTest extends CamelTestSupport{

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new HardWayBeanRoute();
    }

    @Test
    public void invokeBeanFromProcessorTest(){
        MockEndpoint endHardWay = getMockEndpoint("mock:endHardWay");

        endHardWay.whenAnyExchangeReceived(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                log.info("Received body "+ exchange.getIn().getBody());
            }
        });

        template.sendBody("direct:startHardWay","Message Body");


    }
}