package org.nobleprog.camel.karaf.settlement.client;


import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.nobleprog.karaf.service.SettlementDateService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class SettlementDateConsumerActivator implements BundleActivator {

    private CamelContext camelContext;

    public void start(BundleContext bundleContext) throws Exception {
        camelContext = new DefaultCamelContext();

        SettlementDateService settlementDateService = getSettlementDateService(bundleContext);

        camelContext.addRoutes(new SettlementDateConsumerRoute(settlementDateService));

        camelContext.start();
    }

    private SettlementDateService getSettlementDateService(BundleContext bundleContext) {
        return bundleContext.getService(bundleContext.getServiceReference(SettlementDateService.class));
    }

    public void stop(BundleContext bundleContext) throws Exception {
        camelContext.stop();
    }
}
