package org.nobleprog.camel.components.jms.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RequestReplyRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("jms:incomingOrder")
            //TODO: implement inOut to force incomingOrder queue to send response back
        ;

        from("jms:validateOrder")
                .bean(OrderValidationBean.class);
    }
}
