package org.nobleprog.camel.eip.filter;

import org.apache.camel.spring.javaconfig.CamelConfiguration;
import org.apache.camel.spring.javaconfig.Main;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@ComponentScan
@Configuration
public class Application extends CamelConfiguration{

    public static void main(String[] args) throws Exception {

        Main main = new Main();
        main.setConfigClass(Application.class);
        main.run();

    }
}
