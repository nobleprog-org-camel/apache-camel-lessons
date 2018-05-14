package org.nobleprog.camel.transform.baen;

import org.apache.camel.builder.RouteBuilder;

public class TransformerRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:start")
                .transform(body().regexReplaceAll(",","-"))
                .log("transformed: ${body}");
    }
}
