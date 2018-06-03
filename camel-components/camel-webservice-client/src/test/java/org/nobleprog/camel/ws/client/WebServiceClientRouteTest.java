package org.nobleprog.camel.ws.client;

import org.apache.camel.ProducerTemplate;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;
import org.nobleprog.camel.webservice.api.IncomingOrder;
import org.nobleprog.camel.webservice.api.OrderStatusReport;

import static org.junit.Assert.*;

public class WebServiceClientRouteTest extends CamelTestSupport{

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new WebServiceClientRoute();
    }

    @Test
    public void testWebServiceClient() throws  Exception {
        IncomingOrder incomingOrder = new IncomingOrder();
        incomingOrder.setOrderId("11");
        incomingOrder.setQuantity(1);
        incomingOrder.setBuySell("Buy");
        incomingOrder.setDate("22");

        final OrderStatusReport orderStatusReport = template.requestBody("direct:start", incomingOrder, OrderStatusReport.class);
        assertNotNull(orderStatusReport);
        assertEquals(orderStatusReport.getStatus(),"PartialFilled");
    }
}