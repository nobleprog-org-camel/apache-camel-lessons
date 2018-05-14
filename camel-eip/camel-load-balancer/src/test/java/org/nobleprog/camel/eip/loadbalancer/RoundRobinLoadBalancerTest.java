package org.nobleprog.camel.eip.loadbalancer;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.AdviceWithRouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class RoundRobinLoadBalancerTest extends CamelTestSupport {

    private MockEndpoint httpServer1;
    private MockEndpoint httpServer2;

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new RoundRobinLoadBalancerRoute();
    }

    @Before
    public void setup() throws Exception {
        httpServer1 = getMockEndpoint("mock:server1");
        httpServer2 = getMockEndpoint("mock:server2");

        context.getRouteDefinition("roundRobinRoute").adviceWith(context, new AdviceWithRouteBuilder() {
            @Override
            public void configure() throws Exception {
                interceptSendToEndpoint("http://server_1_for_service.com/process")
                        .skipSendToOriginalEndpoint()
                        .to(httpServer1);

            }
        });
        context.getRouteDefinition("roundRobinRoute").adviceWith(context, new AdviceWithRouteBuilder() {
            @Override
            public void configure() throws Exception {
                interceptSendToEndpoint("http://server_2_for_service.com/process")
                        .skipSendToOriginalEndpoint()
                        .to(httpServer2);

            }
        });

        logHttpRequests();
    }

    private void logHttpRequests() {
        httpServer1.whenAnyExchangeReceived(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                log.info("server_1 recieved body "+exchange.getIn().getBody());
            }
        });
        httpServer2.whenAnyExchangeReceived(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                log.info("server_2 recieved body "+exchange.getIn().getBody());
            }
        });
    }


    @Test
    public void testRoundRobinStrategy() throws Exception {
        context.start();

        template.sendBody("direct:start","Request 1");
        template.sendBody("direct:start","Request 2");
        template.sendBody("direct:start","Request 3");
        template.sendBody("direct:start","Request 4");

        context.stop();
    }

    @Override
    public boolean isUseAdviceWith() {
        return true;
    }
}