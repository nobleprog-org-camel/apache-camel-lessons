package org.nobleprog.camel.beans.parameterBinding;

import org.apache.camel.Body;
import org.apache.camel.CamelContext;

public class AnnotatedParameterBean {

    public String invoke(CamelContext camelContext){
        return  " with context invoked";
    }

    //TODO: 1. Just run without changing, 2. Annotate Body
    public String process(String body){
        return body + " with Annotated Body processed";
    }
}
