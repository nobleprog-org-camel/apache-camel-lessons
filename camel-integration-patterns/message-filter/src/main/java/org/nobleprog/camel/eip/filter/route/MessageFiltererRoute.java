package org.nobleprog.camel.eip.filter.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MessageFiltererRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("jms:queue:xmlOrders")
                //TODO: implment filter here with xpath expression  "//date[text()!='31-DEC-9999']"
                .to("jms:queue:fulfillment");
    }
}
