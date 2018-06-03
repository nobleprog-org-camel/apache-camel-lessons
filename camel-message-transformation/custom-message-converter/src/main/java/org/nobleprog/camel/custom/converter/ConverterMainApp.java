package org.nobleprog.camel.custom.converter;


import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

import java.util.concurrent.TimeUnit;

public class ConverterMainApp {

    public static void main(String[] args) throws Exception {
        CamelContext camelContext = new DefaultCamelContext();

        camelContext.addRoutes(new ConverterRoute());

        camelContext.start();

        TimeUnit.SECONDS.sleep(3);

        camelContext.stop();
    }
}
