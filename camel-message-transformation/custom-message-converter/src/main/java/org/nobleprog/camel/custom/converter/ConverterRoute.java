package org.nobleprog.camel.custom.converter;


import org.apache.camel.builder.RouteBuilder;
import org.nobleprog.camel.custom.converter.execution.TradeOrderExecutor;
import org.nobleprog.camel.custom.converter.model.TradeOrder;
import org.nobleprog.camel.custom.converter.service.TradeOrderConverter;

public class ConverterRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file://camel-message-transformation/custom-message-converter/data/input")
                .convertBodyTo(String.class)
                .bean(TradeOrderExecutor.class)
                .to("file://camel-message-transformation/custom-message-converter/data/output");
    }
}
