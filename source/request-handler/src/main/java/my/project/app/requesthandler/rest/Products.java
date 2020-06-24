package my.project.app.requesthandler.rest;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/products")
@Singleton
public class Products {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProducts(final String parameters) {
        return null;
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducts(final String parameters) {
        return null;
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteProducts(final String parameters) {
        return null;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProducts(final String parameters) {
        return null;
    }

}
