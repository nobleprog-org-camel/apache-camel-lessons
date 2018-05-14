package org.nobleprog.camel.beans.annotated;


import org.apache.camel.builder.RouteBuilder;

public class AnnotatedBeanMethodRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:startHandler")
                .bean(HandlerAnnotatedBean.class)
                .to("mock:endHandler");

    }
}
