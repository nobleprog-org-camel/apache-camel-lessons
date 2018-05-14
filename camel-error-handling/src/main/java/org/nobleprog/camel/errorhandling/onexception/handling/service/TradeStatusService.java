package org.nobleprog.camel.errorhandling.onexception.handling.service;

import org.nobleprog.camel.errorhandling.onexception.handling.TestOrderNotSupportedExccption;
import org.springframework.stereotype.Component;

@Component
public class TradeStatusService {

    public String statusOf(String tradeId) {
        if ("test".equals(tradeId)) {
            throw new TestOrderNotSupportedExccption("Test order not supported");
        }

        return "success";
    }
}
