package org.nobleprog.camel.components.jms.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.component.jms.JmsComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.ConnectionFactory;

@Configuration
public class JmsConfig {

    @Bean
    public JmsComponent jmsComponent(){
        JmsComponent jmsComponent = new JmsComponent();
        //TODO: create ConnectionFactory to configure jms with your broker "tcp://localhost:61616"
        //jmsComponent.setConnectionFactory(connectionFactory());
        return jmsComponent;
    }
}
