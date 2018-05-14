package org.nobleprog.camel.components.cxf.rest;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.apache.camel.spring.javaconfig.CamelConfiguration;
import org.apache.camel.spring.javaconfig.Main;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Application extends CamelConfiguration{

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.setConfigClass(Application.class);
        main.run();
    }

    @Bean
    public JacksonJaxbJsonProvider jacksonJaxbJsonProvider(){
        return new JacksonJaxbJsonProvider();
    }
}
