package org.nobleprog.camel.eip.loadbalancer;

import org.apache.camel.builder.RouteBuilder;


public class FailOverLoadBalancer extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:start").routeId("failOverRoute")
                //TODO: Implement LoadBalanncer with Failover strategy in case of IllegalStateException comes during route execution
                .to("http://server_1_for_service.com/process")
                .to("http://server_2_for_service.com/process");

    }
}
