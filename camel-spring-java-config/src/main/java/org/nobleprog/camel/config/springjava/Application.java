package org.nobleprog.camel.config.springjava;

import org.apache.camel.spring.javaconfig.Main;
import org.nobleprog.camel.config.springjava.config.IntegrationConfig;


public class Application {

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.setConfigClass(IntegrationConfig.class);
        main.run();
    }
}
