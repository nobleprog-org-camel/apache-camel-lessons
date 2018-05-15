package org.nobleprog.camel.transform.data.xml.route;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.nobleprog.camel.transform.data.xml.model.TradeOrder;
import org.springframework.stereotype.Component;

@Component
public class XmlDataTransformerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file://camel-message-transformation/transform-data-formats/data/input")
                .log("successfully unmarshalled ${body}")
                        .enrich("http://localhost:8089/settlementDate", new AggregationStrategy() {
                            @Override
                            public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
                                if(newExchange == null){
                                    return oldExchange;
                                }
                                TradeOrder tradeOrder = oldExchange.getIn().getBody(TradeOrder.class);
                                String settlementDate = newExchange.getIn().getBody(String.class);

                                tradeOrder.setSettlementDate(settlementDate);

                                oldExchange.getIn().setBody(tradeOrder);
                                return oldExchange;
                            }
                        })
                        .to("file://camel-message-transformation/transform-data-formats/data/ouput");
    }
}
