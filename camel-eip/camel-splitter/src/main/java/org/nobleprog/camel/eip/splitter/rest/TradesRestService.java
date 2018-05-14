package org.nobleprog.camel.eip.splitter.rest;

import org.nobleprog.camel.eip.splitter.model.TradesOrder;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/place/trade/")
@Consumes("application/json")
@Produces("application/json")
public interface TradesRestService {

    @POST
    void createOrder(TradesOrder tradesOrder);

    @POST
    @Path(value = "/response")
    void createOrderResponse(TradesOrder tradesOrder);
}
