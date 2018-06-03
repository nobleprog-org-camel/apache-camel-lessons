package org.nobleprog.camel.custom.converter.service;

import org.apache.camel.Converter;
import org.nobleprog.camel.custom.converter.model.TradeOrder;

@Converter
public class TradeOrderConverter {

    @Converter
    public static TradeOrder convert(String orderString){
        TradeOrder tradeOrder = new TradeOrder();

        String orderId = orderString.substring(0,4).replaceAll("-","");
        String buySell = orderString.substring(4,8).replaceAll("-","");
        String qty = orderString.substring(8,11).replaceAll("-","");
        String tradeDate = orderString.substring(11).replaceAll("-","");

        tradeOrder.setOrderId(orderId);
        tradeOrder.setBuySell(buySell);
        tradeOrder.setQty(qty);
        tradeOrder.setTradeDate(tradeDate);

        return tradeOrder;
    }
}
