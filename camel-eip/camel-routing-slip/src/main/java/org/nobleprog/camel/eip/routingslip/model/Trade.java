package org.nobleprog.camel.eip.routingslip.model;


import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "brokerName",
        "partnership",
        "ordersPlaced",
        "orderId",
        "quantity",
        "date",
        "buySell",
        "status"
})
@XmlRootElement(name = "trade")
public class Trade {
    @XmlElement
    private String brokerName;
    @XmlElement
    private String partnership;
    @XmlElement
    private int ordersPlaced;

    @XmlElement
    private String orderId;
    @XmlElement
    private int quantity;
    @XmlElement
    private String date;
    @XmlElement
    private String buySell;
    @XmlElement
    private String status;

    public Trade() {
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
