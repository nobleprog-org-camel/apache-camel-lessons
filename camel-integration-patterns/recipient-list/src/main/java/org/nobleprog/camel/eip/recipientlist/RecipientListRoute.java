package org.nobleprog.camel.eip.recipientlist;

import org.apache.camel.builder.RouteBuilder;

public class RecipientListRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:recipientList")
                .log("computing recipientlist from ${body}")
                .recipientList(bean(RecipientListBean.class));
    }
}
