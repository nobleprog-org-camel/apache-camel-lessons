package org.nobleprog.camel.components.jms.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RequestReplyRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("jms:incomingOrder")
                .inOut("jms:validateOrder");

        from("jms:validateOrder")
                .bean(OrderValidationBean.class);
    }
}
