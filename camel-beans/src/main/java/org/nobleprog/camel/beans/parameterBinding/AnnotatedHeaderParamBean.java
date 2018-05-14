package org.nobleprog.camel.beans.parameterBinding;

import org.apache.camel.Body;
import org.apache.camel.Headers;

import java.util.Map;

public class AnnotatedHeaderParamBean {


    public String invoke(String body) {
        return body + " invoked";
    }

    public String process(@Headers Map<String, Object> headers, @Body String body) {
        return body + " with Annotated Body processed";
    }
}
