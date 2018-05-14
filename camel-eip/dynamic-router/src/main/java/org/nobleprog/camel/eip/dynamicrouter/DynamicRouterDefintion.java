package org.nobleprog.camel.eip.dynamicrouter;

import org.apache.camel.builder.RouteBuilder;

public class DynamicRouterDefintion extends RouteBuilder {
    public void configure() throws Exception {
        from("direct:start").dynamicRouter(method(DynamicRouterBean.class));

        from("direct:startRoute")
                .log("direct:startRoute ==> ${body}")
                .transform(body().append(":START"))
                .log("after:startRoute ==> ${body}");

        from("direct:endRoute")
                .log("before:endRoute ==> ${body}")
                .transform(body().append(":END"))
                .log("after:endRoute ==> ${body}");
    }
}
