package org.nobleprog.camel.karaf.settlement.client;


import org.apache.camel.builder.RouteBuilder;
import org.nobleprog.camel.karaf.settlement.client.service.SettlementDateEnricher;
import org.nobleprog.karaf.service.SettlementDateService;

public class SettlementDateConsumerRoute extends RouteBuilder {

    private final SettlementDateEnricher settlementDateEnricher;

    public SettlementDateConsumerRoute(SettlementDateService settlementDateService) {
        this.settlementDateEnricher = new SettlementDateEnricher(settlementDateService);

        /*SettlementDateService s = new SettlementDateServiceImpl();
        System.out.println("Create it success " + s.getNextBusinessDay());*/
    }

    public void configure() throws Exception {
        from("file:camel/settlement-date/data")
                .log("camel/settlement-date/data ${body}")
                .bean(settlementDateEnricher)
                .to("file:camel/settlement-date/data/output");
    }
}
