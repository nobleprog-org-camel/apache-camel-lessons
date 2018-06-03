package org.nobleprog.camel.components.cxf;

import org.apache.camel.Exchange;
import org.nobleprog.camel.webservice.api.OrderStatusReport;


public class StatusResponder {

    public OrderStatusReport orderStatusReport(Exchange exchange){
        OrderStatusReport orderStatusReport = new OrderStatusReport();
        orderStatusReport.setOrderId("1");
        orderStatusReport.setStatus("PartialFilled");
        exchange.getIn().setBody(orderStatusReport);
        return orderStatusReport;

    }
}
