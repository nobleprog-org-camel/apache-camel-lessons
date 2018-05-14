package org.nobleprog.camel.beans.parameterBinding;

import org.apache.camel.builder.RouteBuilder;

public class ParameterBindingRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:startParamContext")
                .bean(CamelTypeParameterBean.class)
                .to("mock:endParamContext");

        from("direct:startParamAnnotated")
                .bean(AnnotatedParameterBean.class)
                .to("mock:endParamAnnotated");

        from("direct:startHeaderAnnotated")
                .bean(AnnotatedHeaderParamBean.class)
                .to("mock:endHeaderAnnotated");

    }
}
