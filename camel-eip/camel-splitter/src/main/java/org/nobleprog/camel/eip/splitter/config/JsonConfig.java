package org.nobleprog.camel.eip.splitter.config;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsonConfig {

    @Bean
    public JacksonJsonProvider jacksonJsonProvider() {
        return new JacksonJsonProvider();
    }
}
