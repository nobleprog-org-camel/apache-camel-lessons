package org.nobleprog.camel.eip.cbr;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;

import org.apache.camel.spring.javaconfig.CamelConfiguration;
import org.apache.camel.spring.javaconfig.Main;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = {"org.nobleprog.camel.eip.cbr"})
public class Application extends CamelConfiguration{

    public static void main(String[] args) throws Exception {

        Main main = new Main();
        main.setConfigClass(Application.class);
        main.run();

    }

}
