package org.nobleprog.camel.component.wiretap;


import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class WireTapRouteTest extends CamelTestSupport{
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new WireTapRoute();
    }

    @Test
    public void test() {
        template.sendBody("direct:start","Message body");
    }
}