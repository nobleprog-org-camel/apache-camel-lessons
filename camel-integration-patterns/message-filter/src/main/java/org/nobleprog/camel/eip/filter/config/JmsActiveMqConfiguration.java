package org.nobleprog.camel.eip.filter.config;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.component.jms.JmsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.ConnectionFactory;

@Configuration
public class JmsActiveMqConfiguration {

    @Bean
    public JmsComponent jmsComponent(){
        JmsComponent jmsComponent = new JmsComponent(jmsConfiguration());
        return jmsComponent;
    }

    @Bean
    public JmsConfiguration jmsConfiguration(){
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        JmsConfiguration jmsConfiguration = new JmsConfiguration(connectionFactory);
        return jmsConfiguration;
    }
}