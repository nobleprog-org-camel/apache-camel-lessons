package org.nobleprog.camel.beans.hardway;

import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class HardWayBeanRoute extends RouteBuilder {

    private Processor processor = new BeanCallingProcessor();

    @Override
    public void configure() throws Exception {
        from("direct:startHardWay")
                .process(processor)
                .to("mock:endHardWay");
    }
}
