package org.nobleprog.camel.csv;

import org.apache.camel.spring.javaconfig.CamelConfiguration;
import org.apache.camel.spring.javaconfig.Main;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class CsvApplication extends CamelConfiguration {

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.setConfigClass(CsvApplication.class);
        main.run();
    }
}
