package org.nobleprog.camel.transform.data.json.model;


public class TradeOrder {

    private String orderId;
    private int quantity;
    private String date;
    private String buySell;
    private String settlementDate;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String value) {
        this.orderId = value;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int value) {
        this.quantity = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String value) {
        this.date = value;
    }

    public String getBuySell() {
        return buySell;
    }

    public void setBuySell(String value) {
        this.buySell = value;
    }

    public String getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(String settlementDate) {
        this.settlementDate = settlementDate;
    }
}
