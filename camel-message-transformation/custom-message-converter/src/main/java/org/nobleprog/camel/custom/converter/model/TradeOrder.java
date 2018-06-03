package org.nobleprog.camel.custom.converter.model;

public class TradeOrder {
    private String orderId;
    private String buySell;
    private String qty;
    private String tradeDate;

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }


    public void setBuySell(String buySell) {
        this.buySell = buySell;
    }

    public String getBuySell() {
        return buySell;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getQty() {
        return qty;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

    public String getTradeDate() {
        return tradeDate;
    }
}
