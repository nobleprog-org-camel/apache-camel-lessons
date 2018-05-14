package org.nobleprog.camel.eip.dynamicrouter;

import org.apache.camel.Exchange;
import org.apache.camel.Header;

public class DynamicRouterBean {

    public String compute(String body, @Header(Exchange.SLIP_ENDPOINT) String previousRoute){
        return whereToGo(body,previousRoute);
    }

    private String whereToGo(String body, String previousRoute){
        if(previousRoute == null){
            return "direct:startRoute";
        }else if(previousRoute.equals("direct://startRoute")){
            return "direct:endRoute";
        } else {
            return null;
        }
    }
}
