package org.nobleprog.karaf.service;

import org.nobleprog.karaf.service.impl.SettlementDateServiceImpl;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ServiceActivator implements BundleActivator {

    ServiceRegistration registration;
    SettlementDateService settlementDateService = new SettlementDateServiceImpl();

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        registration = bundleContext.registerService(SettlementDateService.class.getName(),settlementDateService,null);
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        registration.unregister();
    }
}
