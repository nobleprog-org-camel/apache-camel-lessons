package org.nobleprog.camel.beans.hardway;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.nobleprog.camel.beans.bean.PojoBean;

public class BeanCallingProcessor implements Processor{

    private PojoBean pojoBean = new PojoBean();

    @Override
    public void process(Exchange exchange) throws Exception {
        String body = exchange.getIn().getBody(String.class);


    }
}
