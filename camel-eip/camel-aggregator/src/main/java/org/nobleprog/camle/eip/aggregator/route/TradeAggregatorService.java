package org.nobleprog.camle.eip.aggregator.route;

import org.apache.camel.Exchange;
import org.nobleprog.camle.eip.aggregator.model.TradeOrderResult;
import org.springframework.stereotype.Component;

@Component
public class TradeAggregatorService {

    public String getCorrelationKey(TradeOrderResult tradeOrderResult){
        System.out.println("Returning correlation id "+tradeOrderResult.getBrokerName());
        return tradeOrderResult.getBrokerName();
    }

}
