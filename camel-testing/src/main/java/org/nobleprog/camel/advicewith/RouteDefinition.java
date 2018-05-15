package org.nobleprog.camel.advicewith;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RouteDefinition extends RouteBuilder
{

    @Override
    public void configure() throws Exception {
        from("direct:startAdvice").routeId("orderDispatchRoute")
                .transform(body().regexReplaceAll(",","-"))
                .to("http://localhost:8090/order");
    }
}
