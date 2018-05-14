package org.nobleprog.camel.beans.methodName;


public class PojoBean {

    public String invoke(String body){
        return  body + " invoked";
    }

    public String process(String body){
        return  body + " processed";
    }
}
