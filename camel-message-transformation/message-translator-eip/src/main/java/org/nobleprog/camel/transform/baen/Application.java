package org.nobleprog.camel.transform.baen;

import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

import java.util.concurrent.TimeUnit;

public class Application {

    public static void main(String argsp[]) throws Exception {

        CamelContext camelContext = new DefaultCamelContext();
        camelContext.addRoutes(transformerWithProcessor());

        //camelContext.addRoutes(transformerWithBean());
        camelContext.addRoutes(new TransformerRoute());
        camelContext.start();

        TimeUnit.SECONDS.sleep(3);

        camelContext.stop();
    }

    private static RoutesBuilder transformerWithBean() {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("file://camel-message-transformation/message-translator-eip/data/input")
                        .bean(new CsvTransformer())
                        .to("file://camel-message-transformation/message-translator-eip/data/output")
                        .end()
                        .to("direct:start");
            }
        };
    }

    private static RoutesBuilder transformerWithProcessor() {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("file://camel-message-transformation/message-translator-eip/data/input")
                        .process(new CsvProcessor())
                        .to("file://camel-message-transformation/message-translator-eip/data/output")
                        .end()
                        .to("direct:start");
            }
        };
    }
}
