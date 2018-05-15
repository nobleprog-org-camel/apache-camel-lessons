package org.nobleprog.camel.component.jdbc.route;

import org.nobleprog.camel.component.jdbc.model.TradeOrder;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class SqlToOrderBean {

    public TradeOrder tradeOrder(List<Map<String,Object>> rows){
        TradeOrder tradeOrder = new TradeOrder();
        if(rows != null && !rows.isEmpty()){
            Map<String,Object> row = rows.get(0);
            tradeOrder.setOrderId(String.valueOf(row.get("ORDER_ID")));
            tradeOrder.setQuantity(new BigDecimal(String.valueOf(row.get("QUANTITY"))).intValueExact());
            tradeOrder.setBuySell(String.valueOf(row.get("BUY_SELL")));
            tradeOrder.setDate(String.valueOf(row.get("TRADE_DATE")));
        }
        return tradeOrder;
    }
}
