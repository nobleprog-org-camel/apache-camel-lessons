package org.nobleprog.camel.custom.converter.execution;

import org.nobleprog.camel.custom.converter.model.TradeOrder;

public class TradeOrderExecutor {

    public String execute(TradeOrder tradeOrder) {
        System.out.println("Trade Order executed");
        return tradeOrder.getOrderId() + " Executed";
    }

}
