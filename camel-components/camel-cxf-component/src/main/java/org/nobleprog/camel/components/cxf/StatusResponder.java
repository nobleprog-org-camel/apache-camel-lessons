package org.nobleprog.camel.components.cxf;

import org.apache.camel.Exchange;
import trade.order.OrderStatusReport;
/**
 * Created by sahdev on 5/6/2018.
 */
public class StatusResponder {

    public OrderStatusReport orderStatusReport(Exchange exchange){
        OrderStatusReport orderStatusReport = new OrderStatusReport();
        orderStatusReport.setOrderId("1");
        orderStatusReport.setStatus("PartialFilled");
        exchange.getIn().setBody(orderStatusReport);
        return orderStatusReport;

    }
}
