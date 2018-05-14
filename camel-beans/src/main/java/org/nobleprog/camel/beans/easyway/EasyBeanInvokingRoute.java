package org.nobleprog.camel.beans.easyway;


import org.apache.camel.builder.RouteBuilder;
import org.nobleprog.camel.beans.bean.PojoBean;

public class EasyBeanInvokingRoute extends RouteBuilder{

    PojoBean pojoBean = new PojoBean();

    @Override
    public void configure() throws Exception {
        from("direct:startHardWay")
                .bean(pojoBean)
                .to("mock:endHardWay");
    }
}
