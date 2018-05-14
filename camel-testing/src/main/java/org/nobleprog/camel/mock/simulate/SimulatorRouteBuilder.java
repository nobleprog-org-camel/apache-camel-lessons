package org.nobleprog.camel.mock.simulate;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SimulatorRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:remoteStart")
                .to("mock:ftp")
                .to("mock:further");
    }
}
