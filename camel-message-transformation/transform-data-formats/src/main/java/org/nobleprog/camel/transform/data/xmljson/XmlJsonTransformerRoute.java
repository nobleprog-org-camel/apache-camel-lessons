package org.nobleprog.camel.transform.data.xmljson;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xmljson.XmlJsonDataFormat;
import org.springframework.stereotype.Component;

@Component
public class XmlJsonTransformerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("file://camel-message-transformation/transform-data-formats/data/xmljson/input?fileName=xml-order.xml")
                .marshal().xmljson()
                .to("file://camel-message-transformation/transform-data-formats/data/xmljson/output?fileName=xml-to-json.json");


        /*XmlJsonDataFormat xmlJsonDataFormat = new XmlJsonDataFormat();
        xmlJsonDataFormat.setRootName("TradeOrder");*/
        from("file://camel-message-transformation/transform-data-formats/data/xmljson/input?fileName=json-order.json")
                //.unmarshal(xmlJsonDataFormat) TODO: uncomment and run to rename the root element in xml
                .unmarshal().xmljson()
                .to("file://camel-message-transformation/transform-data-formats/data/xmljson/output?fileName=json-to-xml.xml");
    }

}
