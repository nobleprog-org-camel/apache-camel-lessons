package org.nobleprog.camel.middleware.client.api;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.ProxyBuilder;
import org.nobleprog.camel.middleware.domain.service.TradeExecutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter(JmsConfig.class)
public class TradeExecutionConfig {

    @Autowired
    private CamelContext camelContext;

    @Bean
    public TradeExecutionService tradeExecutionService() throws Exception {
        TradeExecutionService tradeExecutionService = new ProxyBuilder(camelContext)
                .endpoint("jms:queue:trade?replyTo=queue:orderReply")
                .build(TradeExecutionService.class);
        return tradeExecutionService;
    }

}
