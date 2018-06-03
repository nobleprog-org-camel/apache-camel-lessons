package org.nobleprog.camel.middleware.server.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.component.jms.JmsComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.ConnectionFactory;

@Configuration
public class JmsConfig {

    @Bean
    public ConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory connectionFactory =  new ActiveMQConnectionFactory("tcp://localhost:61616");
        connectionFactory.setTrustAllPackages(true);
        return connectionFactory;
    }

    @Bean
    public JmsComponent jmsComponent(){
        JmsComponent jmsComponent = new JmsComponent();
        jmsComponent.setConnectionFactory(connectionFactory());
        return jmsComponent;
    }

}
