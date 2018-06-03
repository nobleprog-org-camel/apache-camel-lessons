package org.nobleprog.camel.components.cxf;


import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.CxfEndpoint;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.main.Main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) throws Exception {
       // ApplicationContext context = new ClassPathXmlApplicationContext("camel-route.xml");
        //CamelContext camelContext = context.getBean("camel", CamelContext.class);
        CamelContext camelContext = new DefaultCamelContext();
        Endpoint endpoint = createEndpoint();
        endpoint.setCamelContext(camelContext);

        camelContext.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from(endpoint)
                        .log("Trade successfully processed ${body}")
                        .bean(StatusResponder.class);
            }
        });
        camelContext.start();

        Main main = new Main();
        main.run();

    }

    private static Endpoint createEndpoint() throws ClassNotFoundException {
        CxfEndpoint cxfEndpoint = new CxfEndpoint();
        cxfEndpoint.setBeanId("cxfEndpoint");
        cxfEndpoint.setAddress("http://localhost:8083/service");
        cxfEndpoint.setServiceClass("org.nobleprog.camel.webservice.api.TradeEndpoint");
        return cxfEndpoint;
    }
}
