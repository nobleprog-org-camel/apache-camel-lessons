package org.nobleprog.camel.beans.parameterBinding;

import org.apache.camel.Body;
import org.apache.camel.Headers;

import java.util.Map;

public class AnnotatedHeaderParamBean {


    public String invoke(String body) {
        return body + " invoked";
    }

    //TODO: Annotate Headers and Body
    public String process( Map<String, Object> headers, String body) {
        return body + " with Annotated Body processed";
    }
}
