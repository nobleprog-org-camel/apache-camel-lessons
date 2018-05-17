package org.nobleprog.camel.eip.loadbalancer;

import org.apache.camel.builder.RouteBuilder;

public class RoundRobinLoadBalancerRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:start").routeId("roundRobinRoute")
                .log("Request received ${body}")
                //TODO: Implement loadbalancer with RoundRobin strategy
                .to("http://server_1_for_service.com/process").to("http://server_2_for_service.com/process");
    }
}
