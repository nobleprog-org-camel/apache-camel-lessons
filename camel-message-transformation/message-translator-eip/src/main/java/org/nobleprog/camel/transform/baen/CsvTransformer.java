package org.nobleprog.camel.transform.baen;


public class CsvTransformer {

    public String transform(String message){
        StringBuilder tradesCsv = new StringBuilder();
        tradesCsv.append("ID,").append("BUY/SELL,").append("QUANTITY,").append("TradeDate").append("\r\n");
        String [] trades = message.split("\r\n");
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

        return tradesCsv.toString();
    }
}
