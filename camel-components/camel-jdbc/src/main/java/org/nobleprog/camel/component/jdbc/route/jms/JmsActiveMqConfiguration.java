package org.nobleprog.camel.component.jdbc.route.jms;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.component.jms.JmsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.JmsTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.jms.ConnectionFactory;
import javax.transaction.TransactionManager;

@Configuration
public class JmsActiveMqConfiguration {

    @Bean
    public JmsComponent jmsComponent(JmsConfiguration jmsConfiguration,PlatformTransactionManager platformTransactionManager){
        JmsComponent jmsComponent = new JmsComponent(jmsConfiguration);
        jmsComponent.setTransacted(true);
        jmsComponent.setTransactionManager(platformTransactionManager);
        return jmsComponent;
    }

    @Bean
    public PlatformTransactionManager txManager(JmsConfiguration jmsConfiguration) {
        JmsTransactionManager transactionManager = new JmsTransactionManager(jmsConfiguration.getConnectionFactory());
        return transactionManager;
    }

    @Bean
    public JmsConfiguration jmsConfiguration(){
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        JmsConfiguration jmsConfiguration = new JmsConfiguration(connectionFactory);
        return jmsConfiguration;
    }
}
