package org.nobleprog.camel.errorhandling.onexception.handling;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.camel.spring.javaconfig.CamelConfiguration;
import org.apache.camel.spring.javaconfig.Main;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Application extends CamelConfiguration {

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.setConfigClass(Application.class);
        main.run();
    }

    @Bean
    public JacksonJsonProvider jacksonJaxbJsonProvider(){
        return new JacksonJsonProvider();
    }
}
