package org.nobleprog.camel.components.cxf;


import org.apache.camel.CamelContext;
import org.apache.camel.main.Main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("camel-route.xml");
        CamelContext camelContext = context.getBean("camel", CamelContext.class);
        camelContext.start();

        Main main = new Main();
        main.run();

    }
}
