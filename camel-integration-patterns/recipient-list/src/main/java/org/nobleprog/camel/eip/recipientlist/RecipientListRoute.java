package org.nobleprog.camel.eip.recipientlist;

import org.apache.camel.builder.RouteBuilder;

public class RecipientListRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:recipientList")
                .log("computing recipientlist from ${body}")
                .recipientList(method(RecipientListBean.class));
        //TODO:implement parallel processing
        //TODO: implement aggregation if consumer send you response back
    }
}
