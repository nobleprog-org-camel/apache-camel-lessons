import org.apache.camel.CamelContext;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.nobleprog.camel.webservice.api.IncomingOrder;
import org.nobleprog.camel.webservice.api.OrderStatusReport;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CxfWebServiceTest extends CamelSpringTestSupport {

    private CamelContext camelContext;

    @Override
    public void setUp() throws Exception {
        super.setUp();

    }

    protected AbstractApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("camel-route.xml");
    }

    @Test
    public void testOrderOk() throws Exception {
        IncomingOrder incomingOrder  = new IncomingOrder();
        incomingOrder.setOrderId("12");

        OrderStatusReport output = template.requestBody("cxf:bean:tradeEndpoint",incomingOrder,OrderStatusReport.class);
        System.out.println(output);
    }
}
