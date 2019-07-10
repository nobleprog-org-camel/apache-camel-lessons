package org.nobleprog.camel.component.custom.endpoint;

import org.apache.camel.Component;
import org.apache.camel.Consumer;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.impl.DefaultEndpoint;
import org.nobleprog.camel.component.custom.consumer.MyConsumer;
import org.nobleprog.camel.component.custom.producer.MyProducer;

public class MyEndpoint extends DefaultEndpoint{

    public MyEndpoint(String endpointUri, Component component) {
        super(endpointUri, component);
    }


    @Override
    public Producer createProducer() throws Exception {
        return new MyProducer(this);
    }

    @Override
    public Consumer createConsumer(Processor processor) throws Exception {
        return new MyConsumer(this,processor);
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
