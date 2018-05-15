package org.nobleprog.camel.transform.enrich;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class EnricherStrategy implements AggregationStrategy {
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
}
