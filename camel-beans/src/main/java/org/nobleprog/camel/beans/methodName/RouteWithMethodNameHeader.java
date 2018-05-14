package org.nobleprog.camel.beans.methodName;

import org.apache.camel.builder.RouteBuilder;

public class RouteWithMethodNameHeader extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        from("direct:startHeader")
                .bean(PojoBean.class)
                .to("mock:endHeader");

        from("direct:startName")
                // When method is not correctly specified camel throws MethodNotFoundException
                .bean(PojoBean.class,"invoke")
                .to("mock:endName");
    }
}
