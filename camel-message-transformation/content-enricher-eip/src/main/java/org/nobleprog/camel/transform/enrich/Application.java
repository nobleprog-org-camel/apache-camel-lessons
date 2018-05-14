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
                        .enrich("http://localhost:8089/settlementDate", new AggregationStrategy() {
                            @Override
                            public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
                                if(newExchange == null){
                                    return oldExchange;
                                }
                                String [] tradeOrders = oldExchange.getIn().getBody(String.class).split("\r\n");
                                String settlementDate = newExchange.getIn().getBody(String.class);
                                StringBuilder enrichedBody = new StringBuilder();
                                for(String order : tradeOrders){
                                    enrichedBody.append(order).append(settlementDate).append("\r\n");
                                }
                                oldExchange.getIn().setBody(enrichedBody.toString());
                                return oldExchange;
                            }
                        })
                        .bean(new CsvProcessor())
                        .to("file://camel-message-transformation/content-enricher-eip/data/ouput");
            }
        };
    }
}
