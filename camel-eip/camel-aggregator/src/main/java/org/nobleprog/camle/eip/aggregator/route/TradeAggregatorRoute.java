package org.nobleprog.camle.eip.aggregator.route;

import org.apache.camel.Exchange;
import org.apache.camel.Predicate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.nobleprog.camle.eip.aggregator.model.TradeOrderResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.OrderComparator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TradeAggregatorRoute extends RouteBuilder {

    @Autowired
    private TradeAggregatorService tradeAggregatorService;

    @Override
    public void configure() throws Exception {
        from("jms:queue:processedOrder")
                .log("Order status update received ${body}")
                .unmarshal().json(JsonLibrary.Jackson,TradeOrderResult.class)
                .aggregate(method(tradeAggregatorService, "getCorrelationKey"), new AggregationStrategy() {
                    @Override
                    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
                        if(oldExchange == null){
                            List<TradeOrderResult> aggregated = new ArrayList<>();
                            final TradeOrderResult result = newExchange.getIn().getBody(TradeOrderResult.class);
                            aggregated.add(result);
                            newExchange.getIn().setBody(aggregated);

                            newExchange.setProperty("ORDERS_PLACED",result.getOrdersPlaced());
                            newExchange.setProperty("FILE_NAME",result.getBrokerName());
                            return newExchange;
                        }
                        List<TradeOrderResult> aggregated = oldExchange.getIn().getBody(List.class);
                        aggregated.add(newExchange.getIn().getBody(TradeOrderResult.class));
                        oldExchange.getIn().setBody(aggregated);
                        return oldExchange;
                    }
                }).completion(new Predicate() {
            @Override
            public boolean matches(Exchange exchange) {
                return exchange.getProperty("ORDERS_PLACED",Integer.class) == exchange.getProperty(Exchange.AGGREGATED_SIZE,Integer.class);
            }
        })
                .marshal().json(JsonLibrary.Jackson)
                .toD("file://data//orders?fileName=report-${header.FILE_NAME}.json&fileExist=Append");

    }
}
