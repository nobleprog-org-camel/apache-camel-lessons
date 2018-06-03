package org.nobleprog.camel.async;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class AsyncProcessingRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new AsyncProcessingRoute();
    }

    @Test
    public void testAsyncRoute() throws Exception {
        template.sendBody("direct:start", "Message 1");
        template.sendBody("direct:start", "Message 2");
        template.sendBody("direct:start", "Message 3");
    }
}