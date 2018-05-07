package org.nobleprog.camel.casestudy.route;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Contoller {

    @Autowired
    CamelContext camelContext;

    @Autowired
    ProducerTemplate producerTemplate;

    @RequestMapping(value = "/invoke")
    public void startCamel(){
        producerTemplate.sendBody("direct:start","Invoking camel route from rest");
    }
}
