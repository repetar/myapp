package my.project.app.requesthandler.rest;


import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import my.project.app.requesthandler.databaseconnector.DatabaseConnector;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/getTestObject")
public class TestEndpoint {

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTestResponse(final String attributes) {
        System.out.println("####################################");
        System.out.println("####################################");
        System.out.println("#       test end point working     #");
        System.out.println("####################################");
        System.out.println("####################################");

        System.out.println("input:" + attributes);

        /*
        DatabaseConnector dbc = new DatabaseConnector();
        dbc.connect();

        DBObject query = BasicDBObjectBuilder.start().add("att1", to.getAtt1()).get();
        dbc.read("mytestdb", "testcollection", query);
        */


        return Response.ok().build();
    }
}
