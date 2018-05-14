package org.nobleprog.camel.eip.routingslip.route;

import org.nobleprog.camel.eip.routingslip.model.Trade;
import org.springframework.stereotype.Component;

@Component
public class TradeExecutionService {

    public Trade executeTrade(Trade trade){
        trade.setStatus("Filled");

        return trade;
    }

    public Trade unmarshal(String body){
        System.out.println("Recevied body "+ body);
        Trade trade = new Trade();
        trade.setBrokerName("Testssss");
        return trade;
    }
}
