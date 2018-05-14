package org.nobleprog.camel.eip.routingslip.route.slip;

public class RouteSlipComputer {

    public String compute(String body){
        String routeSlip = "";
        if(body.contains("GoldenBroker")){
            return "direct:sendToMarket";
        }
        return "direct:doValidation,direct:sendToMarket";
    }
}
