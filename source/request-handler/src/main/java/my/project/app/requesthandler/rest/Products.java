package my.project.app.requesthandler.rest;

import my.project.app.requesthandler.databaseobjects.product.Product;
import my.project.app.requesthandler.databaseobjects.product.ProductHandler;
import my.project.app.requesthandler.databaseobjects.user.User;
import my.project.app.requesthandler.databaseobjects.user.UserHandlerImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/products")
@Singleton
public class Products {

    @Autowired
    private ProductHandler productHandler;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProducts(final String parameters) {
        return null;
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProducts(final String parameters) {
        return productHandler.findAll();
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
