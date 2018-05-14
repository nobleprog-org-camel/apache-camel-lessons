package org.nobleprog.camel.eip.splitter.route;

import org.nobleprog.camel.eip.splitter.model.OutgoingOrder;
import org.nobleprog.camel.eip.splitter.model.TradeOrder;
import org.nobleprog.camel.eip.splitter.model.TradesOrder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OutgoingOrderTransformerService {

    public List<OutgoingOrder> split(TradesOrder tradesOrder){
        return tradesOrder.getTrades().stream().map(trade -> {
            OutgoingOrder outgoingOrder = new OutgoingOrder();
            outgoingOrder.setOrderId(trade.getOrderId());
            outgoingOrder.setDate(trade.getDate());
            outgoingOrder.setBuySell(trade.getBuySell());
            outgoingOrder.setQuantity(trade.getQuantity());

            outgoingOrder.setBrokerName(tradesOrder.getBrokerName());
            outgoingOrder.setPartnership(tradesOrder.getPartnership());
            outgoingOrder.setOrdersPlaced(tradesOrder.getTrades().size());
            return outgoingOrder;
        }).collect(Collectors.toList());
    }
}
