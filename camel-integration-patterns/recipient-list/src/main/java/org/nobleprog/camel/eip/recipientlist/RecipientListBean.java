package org.nobleprog.camel.eip.recipientlist;

public class RecipientListBean {

    public String compute(String body){
         //TODO; Implement if body has multiple text then send to multiple
        return "mock:consumerA";
    }
}
