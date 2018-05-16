package org.nobleprog.camel.components.jms.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ConsumerRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("jms:queue:tradeInQueue")
                .log("Received jms message ${body}")
                //TODO: pass incoming message to tradeOutQueue
                .end();
    }
}
