import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringDelegatingTestContextLoader;
import org.apache.camel.test.spring.CamelSpringRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nobleprog.camel.test.javaconfig.Applicaiton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(CamelSpringRunner.class)
@ContextConfiguration(classes = Applicaiton.class, loader = CamelSpringDelegatingTestContextLoader.class)
public class CamelSpringJavaConfigTest {

    @Autowired
    private ProducerTemplate template;

    @EndpointInject(uri = "mock:quote")
    private MockEndpoint mockEndpoint;

    @Test
    public void testJavaConfigRoute() throws InterruptedException {
        mockEndpoint.expectedMessageCount(1);
        mockEndpoint.expectedBodiesReceived("Camel Java Config");

        template.sendBody("direct:start","Camel Java Config");

        mockEndpoint.assertIsSatisfied();
        List<Exchange> exchanges = mockEndpoint.getReceivedExchanges();
        String body = exchanges.get(0).getIn().getBody(String.class);
        assertEquals("Camel Java Config",body);
    }
}
