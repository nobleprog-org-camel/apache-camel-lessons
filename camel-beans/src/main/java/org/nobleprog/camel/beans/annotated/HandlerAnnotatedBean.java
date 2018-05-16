package org.nobleprog.camel.beans.annotated;


import org.apache.camel.Handler;

public class HandlerAnnotatedBean {


    public String invoke(String body){
        return  body + " invoked";
    }

    // TODO:Specify Annotation to let camel HANDLE it
    public String process(String body){
        return  body + " processed";
    }
}
