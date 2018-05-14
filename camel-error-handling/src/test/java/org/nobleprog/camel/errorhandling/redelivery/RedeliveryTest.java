package org.nobleprog.camel.errorhandling.redelivery;

import org.apache.camel.ProducerTemplate;
import org.apache.camel.test.spring.CamelSpringDelegatingTestContextLoader;
import org.apache.camel.test.spring.CamelSpringRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.*;

@RunWith(CamelSpringRunner.class)
@ContextConfiguration(classes = Application.class, loader = CamelSpringDelegatingTestContextLoader.class)
public class RedeliveryTest {

    @Autowired
    private ProducerTemplate producerTemplate;

    @Test
    public void testRedelivery_SeeLogsTest(){
        producerTemplate.sendBody("direct:startRedelivery", "Trade1,Order,To,Send");
        producerTemplate.sendBody("direct:startRedelivery", "Trade2,Order,To,Send");
    }
}