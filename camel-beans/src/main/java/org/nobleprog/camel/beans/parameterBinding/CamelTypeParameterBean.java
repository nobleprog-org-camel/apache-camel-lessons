package org.nobleprog.camel.beans.parameterBinding;

import org.apache.camel.CamelContext;

public class CamelTypeParameterBean {

    /*
       1. We could pass Exchange camel type as well here
       2. If we wish to change body parameter position we have to prefix it with @Body annotation
     */
    public String invoke(String body, CamelContext camelContext){
        return  body + " with context invoked";
    }

    public String process(String body){
        return body + " without context processed";
    }
}
