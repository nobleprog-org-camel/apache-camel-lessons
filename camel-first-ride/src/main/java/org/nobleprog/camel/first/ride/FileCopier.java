package org.nobleprog.camel.first.ride;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.main.Main;

import java.util.concurrent.TimeUnit;

public class FileCopier {

    public static void main(String args[]) throws Exception {
        CamelContext camelContext = new DefaultCamelContext();
        camelContext.addRoutes(createCamelRoute());
        camelContext.start();
        TimeUnit.SECONDS.sleep(2);
        camelContext.stop();

    }

    private static RouteBuilder createCamelRoute(){
        return new FileCopyingRoute();
    }

    private static class FileCopyingRoute extends RouteBuilder{

        public void configure() throws Exception {

            from("file://camel-first-ride//src//main//resources//input")
                    .log("Recieved file content ${body}")
                    .to("file://camel-first-ride//src//main//resources//output")
                    .end();

        }
    }
}
