package org.nobleprog.camel.middleware.client;

import org.nobleprog.camel.middleware.domain.model.Trade;
import org.nobleprog.camel.middleware.domain.service.TradeExecutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MiddlewareClientTestingService implements CommandLineRunner {

    @Autowired
    private TradeExecutionService tradeExecutionService;

    @Override
    public void run(String... strings) throws Exception {
        Trade trade = new Trade();
        trade.setId("11");
        trade.setInstrument("GOOGL");
        String tradeReference = tradeExecutionService.execute(trade);

        System.out.println(tradeReference);
    }
}
