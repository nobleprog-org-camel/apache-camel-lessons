package org.nobleprog.camel.errorhandling.deadletterchannel;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.component.jms.JmsConfiguration;
import org.apache.camel.spring.javaconfig.CamelConfiguration;
import org.apache.camel.spring.javaconfig.Main;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Application extends CamelConfiguration{

    public static void main(String args[]) throws Exception {
        Main main = new Main();
        main.setConfigClass(Application.class);

        main.run();
    }

}
