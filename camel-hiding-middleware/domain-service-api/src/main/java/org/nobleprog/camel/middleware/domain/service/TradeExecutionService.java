package org.nobleprog.camel.middleware.domain.service;

import org.nobleprog.camel.middleware.domain.model.Trade;

public interface TradeExecutionService {

    String execute(Trade trade);

}
