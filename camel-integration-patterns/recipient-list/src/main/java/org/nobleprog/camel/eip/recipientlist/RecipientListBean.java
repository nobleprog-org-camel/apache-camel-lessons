package org.nobleprog.camel.eip.recipientlist;

public class RecipientListBean {

    public String compute(String body){
        if(body.contains("multiple")){ //TODO
            return "mock:consumerA,mock:consumerB";
        }
        return "mock:consumerA";
    }
}
