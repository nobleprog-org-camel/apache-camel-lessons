package org.nobleprog.camel.eip.recipientlist;

public class RecipientListBean {

    public String compute(String body){

        return "mock:consumerA";
    }
}
