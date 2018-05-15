package org.nobleprog.camel.transform.enrich;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.main.Main;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class Application {

    public static void main(String[] args) throws Exception {
        CamelContext camelContext = new DefaultCamelContext();
        camelContext.addRoutes(createEnricherRoute());

        camelContext.start();

        Main main = new Main();
        main.run();
    }

    private static RoutesBuilder createEnricherRoute() {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("file://camel-message-transformation/content-enricher-eip/data/input")
                        .bean(new CsvProcessor())
                        .to("file://camel-message-transformation/content-enricher-eip/data/ouput");
            }
        };
    }
}
