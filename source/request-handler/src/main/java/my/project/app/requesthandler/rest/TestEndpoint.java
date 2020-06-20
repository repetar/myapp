package my.project.app.requesthandler.rest;


import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import my.project.app.requesthandler.databaseconnector.DatabaseConnector;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import my.project.app.requesthandler.databaseobjects.TestObject;
import my.project.app.requesthandlerapi.model.ErrorDetails;

import java.util.ArrayList;
import java.util.List;

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

        // prepare db connection
        DatabaseConnector dbc = new DatabaseConnector();
        dbc.connect();

        // prepare and execute query
        my.project.app.requesthandler.databaseobjects.TestObject to = new TestObject(111, 2, "teststring", true);
        DBObject query = BasicDBObjectBuilder.start().add("att1", to.getAtt1()).get();
        DBCursor c = dbc.read("mytestdb", "testcollection", query);

        // a number of DB objects have been return. parse them to TestObjects
        List<TestObject> tos = new ArrayList<TestObject>();

        while(c.hasNext()){
            DBObject dbo = c.next();
            TestObject too = new TestObject((int)dbo.get("att1"), (int)dbo.get("att2"), (String)dbo.get("att3"), (boolean)dbo.get("att4"));
            tos.add(too);
        }

        System.out.println("Printing strings from all dbobjects 111");
        for (TestObject t:tos) {
            System.out.println("dbo string:" + t.getAtt3());
        }

        return Response.ok().build();
    }
}
