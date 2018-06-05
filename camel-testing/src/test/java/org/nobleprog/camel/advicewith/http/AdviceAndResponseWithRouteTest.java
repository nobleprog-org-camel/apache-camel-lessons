package org.nobleprog.camel.advicewith.http;

import org.apache.camel.*;
import org.apache.camel.builder.AdviceWithRouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringDelegatingTestContextLoader;
import org.apache.camel.test.spring.CamelSpringRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nobleprog.camel.test.javaconfig.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertEquals;

@RunWith(CamelSpringRunner.class)
@ContextConfiguration(classes = Application.class, loader = CamelSpringDelegatingTestContextLoader.class)
public class AdviceAndResponseWithRouteTest {

    @Autowired
    private CamelContext camelContext;

    @EndpointInject(uri = "mock:http")
    private MockEndpoint mockHttp;

    @Autowired
    private ProducerTemplate producerTemplate;


    @Test
    public void testHttpRouteAdivicedWith() throws Exception {
        interceptRemoteHttpInvocationToBeAdviced();

        //TODO call and implement stubRemoteHttpResponseWithMock to send "with,mock,http,response";
        final String response = producerTemplate.requestBody("direct:startAdviceResponse", "Trade,Order,To,Send", String.class);

        assertEquals("Trade-Order-To-Send-with-mock-http-response",response);

    }

    private void interceptRemoteHttpInvocationToBeAdviced() throws Exception {
        camelContext.getRouteDefinition("orderHttpRoute").adviceWith(camelContext, new AdviceWithRouteBuilder() {
            @Override
            public void configure() throws Exception {
                interceptSendToEndpoint("http://localhost:8090/order")
                        .skipSendToOriginalEndpoint()
                        .to(mockHttp);

            }
        });
    }

}