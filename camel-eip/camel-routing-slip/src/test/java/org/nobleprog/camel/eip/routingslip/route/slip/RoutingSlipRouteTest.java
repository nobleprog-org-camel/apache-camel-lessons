package org.nobleprog.camel.eip.routingslip.route.slip;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class RoutingSlipRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new RoutingSlipRoute();
    }

    @Test
    public void testRoutingSlipDefintion() {
        template.sendBody("direct:start", "GoldenBroker Trade Order");
        template.sendBody("direct:start", "BrokerA Trade Order");
        template.sendBody("direct:start", "BrokerB Trade Order");
    }
}