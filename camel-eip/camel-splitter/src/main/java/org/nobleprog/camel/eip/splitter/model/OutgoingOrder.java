package org.nobleprog.camel.eip.splitter.model;


public class OutgoingOrder {

    private String brokerName;
    private String partnership;
    private int ordersPlaced;

    private String orderId;
    private int quantity;
    private String date;
    private String buySell;
    private String status;

    public OutgoingOrder() {
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

    public String getBrokerName() {
        return brokerName;
    }

    public void setBrokerName(String brokerName) {
        this.brokerName = brokerName;
    }

    public String getPartnership() {
        return partnership;
    }

    public void setPartnership(String partnership) {
        this.partnership = partnership;
    }

    public int getOrdersPlaced() {
        return ordersPlaced;
    }

    public void setOrdersPlaced(int ordersPlaced) {
        this.ordersPlaced = ordersPlaced;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
