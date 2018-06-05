package org.nobleprog.camel.component.jdbc.rest;

import org.apache.camel.ProducerTemplate;
import org.nobleprog.camel.component.jdbc.model.TradeOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class Controller {

    @Autowired
    ProducerTemplate producerTemplate;

    @RequestMapping(value = "/createOrder",method = RequestMethod.POST)
    public String createOrder(@RequestBody  TradeOrder tradeOrder){
        return producerTemplate.requestBody("direct:createOrder",tradeOrder,String.class);
    }

    @RequestMapping(value = "/getOrder/{id}",method = RequestMethod.GET)
    public TradeOrder getOrder(@PathVariable String id){
        return producerTemplate.requestBody("direct:getOrder",id,TradeOrder.class);
    }
}
