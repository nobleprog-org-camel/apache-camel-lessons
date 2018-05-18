package org.nobleprog.camel.eip.loadbalancer;

import org.apache.camel.builder.RouteBuilder;

public class RoundRobinWithFailOverLoadBalancer extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:start").routeId("roundRobinFailOverRoute")
                .loadBalance().failover(1,false,true,IllegalStateException.class)
                .to("http://server_1_for_service.com/process")
                .to("http://server_2_for_service.com/process");
    }
}
