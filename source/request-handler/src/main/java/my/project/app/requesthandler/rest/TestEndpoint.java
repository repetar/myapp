package my.project.app.requesthandler.rest;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/test")
public class TestEndpoint {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTestResponse() {
        System.out.println("####################################");
        System.out.println("####################################");
        System.out.println("#       test end point working     #");
        System.out.println("####################################");
        System.out.println("####################################");

        return Response.ok().build();
    }
}
