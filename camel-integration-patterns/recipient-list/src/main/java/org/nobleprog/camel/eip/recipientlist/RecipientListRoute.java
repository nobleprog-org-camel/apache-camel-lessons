package org.nobleprog.camel.eip.recipientlist;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.processor.aggregate.AggregationStrategy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RecipientListRoute extends RouteBuilder {

    ExecutorService executor = Executors.newFixedThreadPool(2);

    @Override
    public void configure() throws Exception {
        from("direct:recipientList")
                .log("computing recipientlist from ${body}")
                .recipientList(method(RecipientListBean.class))
                .parallelProcessing().executorService(executor)
                .aggregationStrategy(new AggregationStrategy() {
                    @Override
                    public Exchange aggregate(Exchange oldExhange, Exchange newExchange) {
                        return newExchange;
                    }
                }) ;
    }
}
