package org.nobleprog.camel.middleware.server.service;

import org.nobleprog.camel.middleware.domain.model.Trade;
import org.nobleprog.camel.middleware.domain.service.TradeExecutionService;
import org.springframework.stereotype.Component;

@Component
public class TradeExecutionServiceImpl implements TradeExecutionService {
    @Override
    public String execute(Trade trade) {
        return trade.getId() + " with instrument " + trade.getInstrument() + " Executed";
    }
}
