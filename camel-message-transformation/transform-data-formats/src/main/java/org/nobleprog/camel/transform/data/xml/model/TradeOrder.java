package org.nobleprog.camel.transform.data.xml.model;


import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "orderId",
        "quantity",
        "date",
        "buySell",
        "settlementDate"
})
@XmlRootElement(name = "tradeOrder")
public class TradeOrder {


    @XmlElement(required = true)
    private String orderId;
    private int quantity;
    @XmlElement(required = true)
    private String date;
    @XmlElement(required = true)
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
