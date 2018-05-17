package org.nobleprog.camel.component.jdbc.route;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestRoute extends RouteBuilder {
    @Autowired
    private CamelContext camelContext;

    public void configure() throws Exception {
        //TODO: Uncomment below to see the tracing of our route
        //camelContext.setTracing(true);

        from("direct:start")
                .bean(OrderToSqlBean.class, "createOrderSql")
                .to("jdbc:dataSource")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        exchange.getIn().setBody("Order Created Successfully");
                    }
                })
        ;
    }
}
