package org.nobleprog.camel.eip.routingslip.route.slip;

import org.apache.camel.builder.RouteBuilder;

public class RoutingSlipRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:start")
                .routingSlip(method(RouteSlipComputer.class));

        from("direct:sendToMarket").routeId("sendToMarket")
                .transform(body().append(" - Sent to Market"))
                .log("Trade Sent for Execution ${body}");

        from("direct:doValidation").routeId("doValidation")
                .delay(3000)
                .transform(body().append(" - validation passed - "))
                .log("Trade has passed validation ${body}");
    }
}
