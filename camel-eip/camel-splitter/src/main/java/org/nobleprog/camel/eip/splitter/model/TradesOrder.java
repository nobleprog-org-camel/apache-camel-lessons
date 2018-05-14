package org.nobleprog.camel.eip.splitter.model;


import java.util.List;

public class TradesOrder {
    private String brokerName;
    private String partnership;
    private List<TradeOrder> trades;

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

    public List<TradeOrder> getTrades() {
        return trades;
    }

    public void setTrades(List<TradeOrder> trades) {
        this.trades = trades;
    }
}
