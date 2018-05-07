package org.nobleprog.camel.casestudy.config;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.sql.SqlComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;


@Component
public class RouteConfig extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        from("direct:start").log("org.nobleprog.log?level=INFO").
                to("sql:select id from Trade where status='NEW'?dataSource=dataSource")
                .to("log:org.nobleprog.camel.casestudy?level=INFO")
                .to("sql:update Trade set status='FILLED'?dataSource=dataSource");

    }

}
