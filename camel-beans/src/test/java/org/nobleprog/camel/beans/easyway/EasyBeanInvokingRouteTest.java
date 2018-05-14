package org.nobleprog.camel.beans.easyway;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;
import org.nobleprog.camel.beans.hardway.HardWayBeanRoute;

import static org.junit.Assert.*;

public class EasyBeanInvokingRouteTest extends CamelTestSupport{

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new EasyBeanInvokingRoute();
    }

    @Test
    public void invokeBeanInRouteItselfTest(){
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