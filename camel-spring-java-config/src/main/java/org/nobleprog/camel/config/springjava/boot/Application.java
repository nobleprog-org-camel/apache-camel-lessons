package org.nobleprog.camel.config.springjava.boot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.nobleprog.camel.config.springjava.config"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
