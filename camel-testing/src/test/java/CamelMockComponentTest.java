import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;
import org.nobleprog.camel.mock.CamelRouteBuilder;


public class CamelMockComponentTest extends CamelTestSupport {

    @Override
    protected CamelContext createCamelContext() throws Exception {
        CamelContext context = super.createCamelContext();
        // seda is a very very basic in memory JMS broker
        context.addComponent("jms", context.getComponent("seda"));
        return context;
    }

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelRouteBuilder();
    }

    @Test
    public void testMock() throws InterruptedException {

        //TODO: implement to getMockEndpoint and set expectations with 1 and "Camel Mock","Another mock"

        template.sendBody("jms:queue:testQueue","Another mock");
        template.sendBody("jms:queue:testQueue","Camel Mock");

        //TODO: invoke mock's assertIsSatisfied
    }
}
