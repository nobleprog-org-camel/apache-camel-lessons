package org.nobleprog.camel.component.jdbc.route.jms;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class JmsConsumerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("direct:incomingMessage")
                .to("jms:incomingMessage");

        from("jms:incomingMessage")
                .bean(MessageToSqlBean.class)
                .to("jdbc:dataSource");

        from("jms:queue:ActiveMQ.DLQ")
                .log("Dead Letter received ${body}");
    }
}
