package org.nobleprog.camel.components.jms;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private ProducerTemplate producerTemplate;

    @RequestMapping(value = "/startJmsRoute")
    public void startJmsRoute(){
        //ProducerTemplate producerTemplate = camelContext.createProducerTemplate();
        producerTemplate.sendBody("direct:start","New Trade Order");
    }
    @RequestMapping(value = "/startRequestReplyRoute")
    public String startRequestReplyRoute(){
        //ProducerTemplate producerTemplate = camelContext.createProducerTemplate();
        return producerTemplate.requestBody("jms:incomingOrder","New Trade Order",String.class);
    }

}
