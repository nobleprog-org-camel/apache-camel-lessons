package org.nobleprog.camel.component.custom.component;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.impl.DefaultComponent;
import org.nobleprog.camel.component.custom.endpoint.MyEndpoint;

import java.util.Map;

public class MyComponent extends DefaultComponent {

    public MyComponent() {
        System.out.println("Defualt");
    }

    public MyComponent(CamelContext context) {

        super(context);
        System.out.println("Context const");
    }

    @Override
    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
        Endpoint endpoint =  new MyEndpoint(uri, this);
        setProperties(endpoint,parameters);
        return endpoint;
    }
}
