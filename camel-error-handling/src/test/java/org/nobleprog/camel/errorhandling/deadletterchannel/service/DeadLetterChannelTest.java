package org.nobleprog.camel.errorhandling.deadletterchannel.service;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.AdviceWithRouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringDelegatingTestContextLoader;
import org.apache.camel.test.spring.CamelSpringRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nobleprog.camel.errorhandling.redelivery.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@RunWith(CamelSpringRunner.class)
@ContextConfiguration(classes = Application.class, loader = CamelSpringDelegatingTestContextLoader.class)
public class DeadLetterChannelTest {

    @Autowired
    private CamelContext camelContext;

    @EndpointInject(uri = "mock:catchDeadLetters")
    private MockEndpoint mockEndpoint;

    @Autowired
    private ProducerTemplate producerTemplate;


    @Test
    public void deadLetterChannelTest() throws Exception {
        camelContext.getRouteDefinition("tradeRoute").adviceWith(camelContext, new AdviceWithRouteBuilder() {
            @Override
            public void configure() throws Exception {
                interceptSendToEndpoint("jms:queue:dead")
                        .skipSendToOriginalEndpoint()
                        .to(mockEndpoint);

            }
        });

        camelContext.start();

        mockEndpoint.expectedMessageCount(1);
        mockEndpoint.expectedBodiesReceived("Trade,Order,To,Send".concat("decrypt"));
        producerTemplate.sendBody("direct:start", "Trade,Order,To,Send");

        mockEndpoint.assertIsSatisfied();

    }

    @Test
    public void deadLetterChannel_UseOriginalMessage() throws Exception {
        camelContext.getRouteDefinition("tradeRoute").adviceWith(camelContext, new AdviceWithRouteBuilder() {
            @Override
            public void configure() throws Exception {
                interceptSendToEndpoint("jms:queue:dead")
                        .skipSendToOriginalEndpoint()
                        .to(mockEndpoint);

            }
        });

        camelContext.start();

        mockEndpoint.expectedMessageCount(1);
        mockEndpoint.expectedBodiesReceived("Trade,Order,To,Send");
        producerTemplate.sendBody("direct:start", "Trade,Order,To,Send");

        mockEndpoint.assertIsSatisfied();

    }


}