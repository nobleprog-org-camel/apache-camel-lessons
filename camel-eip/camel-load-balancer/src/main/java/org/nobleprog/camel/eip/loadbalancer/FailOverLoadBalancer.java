package org.nobleprog.camel.eip.loadbalancer;

import org.apache.camel.builder.RouteBuilder;


public class FailOverLoadBalancer extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:start").routeId("failOverRoute")
                .loadBalance().failover(IllegalStateException.class)
                .to("http://server_1_for_service.com/process")
                .to("http://server_2_for_service.com/process");

    }
}
