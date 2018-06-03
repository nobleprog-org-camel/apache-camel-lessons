package org.nobleprog.camel.components.cxf.rest;


import org.nobleprog.camel.webservice.api.IncomingOrder;

import javax.ws.rs.*;

@Path("/place/trade/")
@Consumes("application/json")
@Produces("application/json")
public interface TradeRestService {
    @GET
    @Path("/{id}")
    IncomingOrder getOrder(@PathParam("id") int orderId);

    @PUT
    void updateOrder(IncomingOrder order);

    @POST
    String createOrder(IncomingOrder order);

    @DELETE
    @Path("/{id}")
    void cancelOrder(@PathParam("id") int orderId);
}
