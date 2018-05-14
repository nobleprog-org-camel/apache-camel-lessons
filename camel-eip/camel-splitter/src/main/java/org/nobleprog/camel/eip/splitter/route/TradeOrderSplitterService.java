package org.nobleprog.camel.eip.splitter.route;

import org.nobleprog.camel.eip.splitter.model.TradeOrder;
import org.nobleprog.camel.eip.splitter.model.TradesOrder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TradeOrderSplitterService {

    public List<TradeOrder> split(TradesOrder tradesOrder){
        return tradesOrder.getTrades().stream().map(trade -> {
            trade.setStatus("New");
            return trade;
        }).collect(Collectors.toList());
    }
}
