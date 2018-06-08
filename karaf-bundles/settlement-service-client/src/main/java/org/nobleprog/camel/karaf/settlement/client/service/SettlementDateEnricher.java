package org.nobleprog.camel.karaf.settlement.client.service;


import org.nobleprog.karaf.service.SettlementDateService;

public class SettlementDateEnricher {

    private final SettlementDateService settlementDateService;

    public SettlementDateEnricher(SettlementDateService settlementDateService) {
        this.settlementDateService = settlementDateService;
    }

    public String enrich(String incomingTrade){
        return incomingTrade.concat(" ").concat(settlementDateService.getNextBusinessDay());
    }
}
