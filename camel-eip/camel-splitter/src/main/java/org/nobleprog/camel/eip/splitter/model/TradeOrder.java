package org.nobleprog.camel.eip.splitter.model;

public class TradeOrder {
    private String orderId;
    private int quantity;
    private String date;
    private String status;
    private String buySell;

    public TradeOrder() {
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String value) {
        this.orderId = value;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int value) {
        this.quantity = value;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String value) {
        this.date = value;
    }

    public String getBuySell() {
        return this.buySell;
    }

    public void setBuySell(String value) {
        this.buySell = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
