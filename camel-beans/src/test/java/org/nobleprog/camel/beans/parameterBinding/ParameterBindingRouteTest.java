package org.nobleprog.camel.beans.parameterBinding;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParameterBindingRouteTest extends CamelTestSupport{
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new ParameterBindingRoute();
    }

    @Test
    public void camelTypeParameterBindingTest(){
        MockEndpoint endHardWay = getMockEndpoint("mock:endParamContext");

        endHardWay.whenAnyExchangeReceived(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                log.info("Received body "+ exchange.getIn().getBody());
            }
        });

        template.sendBody("direct:startParamContext","Message Body");

    }

    @Test
    public void annotatedParameterBindingTest(){
        MockEndpoint endHardWay = getMockEndpoint("mock:endParamAnnotated");

        endHardWay.whenAnyExchangeReceived(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                log.info("Received body "+ exchange.getIn().getBody());
            }
        });

        template.sendBody("direct:startParamAnnotated","Message Body");
    }

    @Test
    public void parameterWithAnnotatedHeaderTest(){
        MockEndpoint endHardWay = getMockEndpoint("mock:endHeaderAnnotated");

        endHardWay.whenAnyExchangeReceived(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                log.info("Received body "+ exchange.getIn().getBody());
            }
        });

        template.sendBody("direct:startHeaderAnnotated","Message Body");
    }
}