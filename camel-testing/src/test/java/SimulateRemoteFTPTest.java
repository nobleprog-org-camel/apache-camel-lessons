import org.apache.camel.*;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringDelegatingTestContextLoader;
import org.apache.camel.test.spring.CamelSpringRunner;
import org.apache.camel.test.spring.CamelSpringTestContextLoader;
import org.apache.camel.test.spring.MockEndpoints;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nobleprog.camel.test.javaconfig.Applicaiton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertEquals;

@RunWith(CamelSpringRunner.class)
@ContextConfiguration(classes = Applicaiton.class,loader = CamelSpringDelegatingTestContextLoader.class)
public class SimulateRemoteFTPTest {

    @EndpointInject(uri = "mock:ftp")
    private MockEndpoint mockEndpoint;

    @EndpointInject(uri = "mock:further")
    private MockEndpoint consumerTemplate;

    @Autowired
    private ProducerTemplate producerTemplate;

    @Test
    public void testRemoteFTPSimulation(){
        mockEndpoint.expectedMessageCount(1);
        mockEndpoint.whenAnyExchangeReceived(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                String body = exchange.getIn().getBody(String.class);
                exchange.getIn().setBody(body+ " Remote FTP response");
            }
        });

        producerTemplate.sendBody("direct:remoteStart","Request");

        String further =consumerTemplate.getReceivedExchanges().get(0).getIn().getBody(String.class);
        assertEquals("Request Remote FTP response",further);
    }

}
