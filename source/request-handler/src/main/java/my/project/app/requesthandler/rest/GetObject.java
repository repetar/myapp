package my.project.app.requesthandler.rest;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import my.project.app.requesthandler.databaseconnector.DatabaseConnector;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import my.project.app.requesthandler.databaseobjects.TestObject;
import my.project.app.requesthandler.utils.Constants;
import my.project.app.requesthandlerapi.model.ErrorDetails;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Path("/getObject")
public class GetObject {

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getObjectResponse(final String attributes) {
        System.out.println("####################################");
        System.out.println("####################################");
        System.out.println("#       test end point working     #");
        System.out.println("####################################");
        System.out.println("####################################");

        System.out.println("input:" + attributes);

        // prepare db connection
        DatabaseConnector dbc = DatabaseConnector.getInstance();

        // prepare and execute query
        my.project.app.requesthandler.databaseobjects.TestObject to = new TestObject(111, 2, "teststring", true);
        DBObject query = BasicDBObjectBuilder.start().add("att1", to.getAtt1()).get();
        DBObject q1 = (DBObject) JSON.parse(attributes);

        System.out.print("query: " + query.toString() + "   q1:" + q1.toString() + " running q1");
        DBCursor c = dbc.read(Constants.DATABASE_NAME, Constants.COLLECTION_NAME, q1);

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

        String response = null;

        ObjectMapper mapper = new ObjectMapper();
        try {
            response = mapper.writeValueAsString(tos.get(1));

        } catch (JsonProcessingException e) {
            System.out.println("problem processing json" + e);
        }

        return Response.ok(response).build();
    }
}
