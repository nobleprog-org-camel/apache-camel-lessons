package org.nobleprog.camel.transform.baen;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;


public class CsvProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String message = exchange.getIn().getBody(String.class); StringBuilder tradesCsv = new StringBuilder(); tradesCsv.append("ID,").append("BUY/SELL,").append("QUANTITY,").append("TradeDate").append("\r\n"); String [] trades = message.split("\r\n");

        for(String body : trades){
            String orderId = body.substring(0,4).replaceAll("-","");
            String buySell = body.substring(4,8).replaceAll("-","");
            String qty = body.substring(8,11).replaceAll("-","");
            String tradeDate = body.substring(11).replaceAll("-","");

            tradesCsv.append(orderId)
                    .append(",").append(buySell)
                    .append(",").append(qty)
                    .append(",").append(tradeDate)
                    .append("\r\n");
        }

        exchange.getIn().setBody(tradesCsv.toString());
    }
}
