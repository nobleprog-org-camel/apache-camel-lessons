import org.apache.camel.CamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;

public class CamelSpring {

    public static void main(String[] args) throws Exception {
        /*ApplicationContext context = new ClassPathXmlApplicationContext("camel-route-context.xml");
        CamelContext camelContext = context.getBean("camel", CamelContext.class);
        camelContext.start();
        TimeUnit.SECONDS.sleep(3);
        camelContext.stop();*/

        ApplicationContext context = new ClassPathXmlApplicationContext("camel-route-context.xml");
        CamelContext camelContext = context.getBean("camel-route", CamelContext.class);
        camelContext.start();
        TimeUnit.SECONDS.sleep(3);
        camelContext.stop();
    }
}
