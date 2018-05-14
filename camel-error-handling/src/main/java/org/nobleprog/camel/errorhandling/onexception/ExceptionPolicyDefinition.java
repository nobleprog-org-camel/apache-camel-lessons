package org.nobleprog.camel.errorhandling.onexception;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.TransactedDefinition;
import org.nobleprog.camel.errorhandling.deadletterchannel.service.TradeOrderService;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ExceptionPolicyDefinition extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        onException(IOException.class).maximumRedeliveries(3);

        from("direct:order")
                .bean(TradeOrderService.class, "validate");
    }
}
