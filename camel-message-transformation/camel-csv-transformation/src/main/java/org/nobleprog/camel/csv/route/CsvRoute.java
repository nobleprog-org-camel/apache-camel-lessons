package org.nobleprog.camel.csv.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;
import org.nobleprog.camel.csv.model.Trade;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CsvRoute extends RouteBuilder {

    DataFormat csvDataFormat = new BindyCsvDataFormat(Trade.class);

    public void configure() throws Exception {
        from("file://camel-message-transformation/camel-csv-transformation/data/input")
                //TODO:Invoke unmarshal using csvDataFormat
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        List<Trade> trades = exchange.getIn().getBody(List.class);
                        for (Trade trade : trades) {
                            trade.setSettlementDate("05-June-2018");
                        }
                    }
                })
                //TODO: invoke marshal using csvDataFormat
                .to("file://camel-message-transformation/camel-csv-transformation/data/output?fileName=order-status.csv");
    }
}
