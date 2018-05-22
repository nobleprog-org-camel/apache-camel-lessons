package org.nobleprog.camel.karaf.bundle;


import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.nobleprog.karaf.service.SettlementDateService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class RouteActivator implements BundleActivator{

    CamelContext camelContext;

    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Inside bundle activator");
        //TODO: Try bundle:start after uncommenting below lines to see you can not access SettlementDateServiceImpl as its private to the bundle
        //SettlementDateService d = new SettlementDateServiceImpl();
        //System.out.println("not working  "+d.getNextBusinessDate());
        final SettlementDateService settlementDateService = bundleContext.getService(bundleContext.getServiceReference(SettlementDateService.class));

        camelContext = new DefaultCamelContext();
        camelContext.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("file:src/data")
                        .log("Processed file from src/data ${body}")
                        .process(new Processor() {
                            public void process(Exchange exchange) throws Exception {
                                String settlementDate = settlementDateService.getNextBusinessDay();
                                String body = exchange.getIn().getBody(String.class);
                                log.warn("Received settlement date is " + settlementDate);
                                exchange.getIn().setBody(settlementDate + " " + body);
                            }
                        })
                        .to("file:src/data/output");
            }
        });

        camelContext.start();
    }

    public void stop(BundleContext bundleContext) throws Exception {
        camelContext.stop();
    }
}
