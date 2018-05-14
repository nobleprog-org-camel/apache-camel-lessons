package org.nobleprog.camel.eip.splitter.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.component.jms.JmsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.ConnectionFactory;

@Configuration
public class JmsConfig {

    @Bean
    public JmsComponent jmsComponent() {
        JmsComponent jmsComponent = new JmsComponent(new JmsConfiguration(connectionFactory()));
        return jmsComponent;
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        return new ActiveMQConnectionFactory("tcp://localhost:61616");
    }
}
