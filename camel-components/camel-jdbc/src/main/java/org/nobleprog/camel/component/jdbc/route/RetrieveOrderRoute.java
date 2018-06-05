package org.nobleprog.camel.component.jdbc.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RetrieveOrderRoute extends RouteBuilder{

    public void configure() throws Exception {
        from("direct:getOrder")
                .bean(OrderToSqlBean.class,"selectOrderSql")
                .to("jdbc:dataSource")
                .bean(SqlToOrderBean.class);
    }
}
