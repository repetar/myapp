package my.project.app.requesthandler.rest;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/orders")
@Singleton
public class Orders {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addOrder(final String parameters) {
        return null;
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrders(final String parameters) {
        return null;
    }


    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteOrders(final String parameters) {
        return null;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateOrders(final String parameters) {
        return null;
    }
}
