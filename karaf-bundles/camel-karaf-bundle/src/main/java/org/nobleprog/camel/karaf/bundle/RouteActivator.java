package org.nobleprog.camel.karaf.bundle;


import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class RouteActivator implements BundleActivator {

    CamelContext camelContext;

    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Inside bundle activator");

        camelContext = new DefaultCamelContext();
        camelContext.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("file:src/data")
                        .log("Processed file from src/data ${body}")
                        .to("file:src/data/output");
            }
        });

        camelContext.start();
    }

    public void stop(BundleContext bundleContext) throws Exception {
        camelContext.stop();
    }
}
