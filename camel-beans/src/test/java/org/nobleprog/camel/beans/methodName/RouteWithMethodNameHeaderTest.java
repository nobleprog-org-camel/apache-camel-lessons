package org.nobleprog.camel.beans.methodName;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import static org.junit.Assert.*;

public class RouteWithMethodNameHeaderTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new RouteWithMethodNameHeader();
    }

    @Test
    public void methodNameHeaderTest(){
        MockEndpoint endHardWay = getMockEndpoint("mock:endHeader");

        endHardWay.whenAnyExchangeReceived(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                log.info("Received body "+ exchange.getIn().getBody());
            }
        });

        template.sendBodyAndHeader("direct:startHeader","Message Body","CamelBeanMethodName","invoke");
        template.sendBodyAndHeader("direct:startHeader","Message Body","CamelBeanMethodName","process");
        //Next call will result in AmbiguousMethodCallException
        template.sendBody("direct:startHeader","Message Body");


    }


    @Test
    public void methodNameInRouteTest(){
        MockEndpoint endHardWay = getMockEndpoint("mock:endName");

        endHardWay.whenAnyExchangeReceived(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                log.info("Received body "+ exchange.getIn().getBody());
            }
        });

        template.sendBody("direct:startName","Message Body");
    }

}