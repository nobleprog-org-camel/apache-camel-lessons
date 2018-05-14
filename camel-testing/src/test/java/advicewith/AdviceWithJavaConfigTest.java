package advicewith;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.AdviceWithRouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringDelegatingTestContextLoader;
import org.apache.camel.test.spring.CamelSpringRunner;
import org.apache.camel.test.spring.MockEndpoints;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nobleprog.camel.advicewith.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@RunWith(CamelSpringRunner.class)
@ContextConfiguration(classes = Application.class,loader = CamelSpringDelegatingTestContextLoader.class)
public class AdviceWithJavaConfigTest {

    @Autowired
    private CamelContext camelContext;

    @EndpointInject(uri = "mock:catchHttpOrder")
    private MockEndpoint mockEndpoint;

    @Autowired
    private ProducerTemplate producerTemplate;


    @Test
    public void testHttpRouteAdivicedWith() throws Exception {
        camelContext.getRouteDefinition("orderDispatchRoute").adviceWith(camelContext, new AdviceWithRouteBuilder() {
            @Override
            public void configure() throws Exception {
                interceptSendToEndpoint("http://localhost:8090/order")
                        .skipSendToOriginalEndpoint()
                        .to(mockEndpoint);

            }
        });

        camelContext.start();

        mockEndpoint.expectedMessageCount(1);
        mockEndpoint.expectedBodiesReceived("Trade-Order-To-Send");
        producerTemplate.sendBody("direct:start","Trade,Order,To,Send");

        mockEndpoint.assertIsSatisfied();
    }
}
