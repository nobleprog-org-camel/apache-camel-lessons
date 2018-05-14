package org.nobleprog.camel.eip.dynamicrouter;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import static org.junit.Assert.*;

public class DynamicRouterDefintionTest extends CamelTestSupport{
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new DynamicRouterDefintion();
    }

    @Test
    public void testDynamicRoute(){
        template.sendBody("direct:start","OrignialBody");
    }
}