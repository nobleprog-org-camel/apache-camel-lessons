package org.nobleprog.camel.advicewith.http;


import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class AdviceAndResponseWithRoute extends RouteBuilder{
    @Override
    public void configure() throws Exception {
        from("direct:startAdviceResponse").routeId("orderHttpRoute")
                .enrich("http://localhost:8090/order",new EnricherAggregator())
                .transform(body().regexReplaceAll(",","-"))
                .log("Message with http response ${body}")
                .to("mock:catchit");

    }
}
