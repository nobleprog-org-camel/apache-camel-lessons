package org.nobleprog.camel.beans.parameterBinding;

import org.apache.camel.Body;
import org.apache.camel.CamelContext;

public class AnnotatedParameterBean {

    /*
     If below method is provided then camel will throw AmbiguousMethodException
     */
    /*public String invoke(String body, CamelContext camelContext){
        return  body + " with context invoked";
    }*/

    public String invoke(CamelContext camelContext){
        return  " with context invoked";
    }

    public String process( @Body String body){
        return body + " with Annotated Body processed";
    }
}
