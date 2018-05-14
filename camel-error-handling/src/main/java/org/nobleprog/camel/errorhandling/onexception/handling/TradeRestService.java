package org.nobleprog.camel.errorhandling.onexception.handling;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/trade/status")
public interface TradeRestService {
    @GET
    @Path("/{id}")
    Response getOrderStatus(@PathParam("id") String orderId);

}
