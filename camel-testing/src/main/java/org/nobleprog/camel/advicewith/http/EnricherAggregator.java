package org.nobleprog.camel.advicewith.http;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class EnricherAggregator implements AggregationStrategy {
    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        String httpResponse = newExchange.getIn().getBody(String.class);
        String originalMessage = oldExchange.getIn().getBody(String.class);

        String aggregated = originalMessage + "," + httpResponse;
        oldExchange.getIn().setBody(aggregated);
        return oldExchange;
    }
}
