package org.nobleprog.camel.components.cxf.rest;

import org.nobleprog.camel.components.cxf.IncomingOrder;
import org.nobleprog.camel.components.cxf.OrderStatusReport;
import org.springframework.stereotype.Component;

@Component
public class TradeProcessingService {


    public OrderStatusReport getOrder(String orderId) {
        OrderStatusReport orderStatusReport = new OrderStatusReport();
        orderStatusReport.setOrderId(orderId);
        orderStatusReport.setStatus("Filled");
        return orderStatusReport;
    }

    public String createOrder(IncomingOrder incomingOrder) {
        return "2";
    }

    public void updateOrder(IncomingOrder incomingOrder) {

    }

    public void cancelOrder(String id) {

    }


}
