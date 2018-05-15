package org.nobleprog.camel.component.jdbc.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RestRoute extends RouteBuilder {

    public void configure() throws Exception {
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
