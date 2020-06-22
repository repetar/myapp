package my.project.app.requesthandler.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.util.JSON;
import my.project.app.requesthandler.databaseconnector.DatabaseConnector;
import my.project.app.requesthandler.databaseobjects.Product;
import my.project.app.requesthandler.utils.Constants;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/products")
@Singleton
public class Products {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProducts(final String parameters) {

        ObjectMapper mapper = new ObjectMapper();
        List<Product> p = new ArrayList<Product>();

        System.out.println("addProducts endpouint input:" + parameters);

        // create JSONArray from input string
        JSONArray arr = new JSONArray(parameters);
        System.out.println("json array: " + arr.toString());

        // get JSONObjects from array and create java objects from them
        for (int i=0; i<arr.length(); i++) {
            JSONObject o = arr.getJSONObject(i);
            System.out.println("json object" + o.toString());

            try {
                // creates Product object from json based on annotations in class for member variables and constructor
                Product pr = mapper.readValue(o.toString(), Product.class);
                p.add(pr);
            } catch (JsonProcessingException e) {
                System.out.println("problem mapping json objects" + e);
            }

        }

        // create if already exists??? check based on productId?
        // product with given ID already exists.

        // create in DB
        DatabaseConnector dbc = DatabaseConnector.getInstance();
        for (Product pr:p){
            try {
                System.out.println("product erceived: " + mapper.writeValueAsString(pr));
            } catch (JsonProcessingException e) {
                System.out.println("problem mapping json objects" + e);
            }

            dbc.create(Constants.PRODUCT_DATABASE, Constants.PRODUCT_COLLECTION, pr);
        }

        return Response.ok().build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducts(final String parameters) {
        System.out.println("####################################");
        System.out.println("####################################");
        System.out.println("#       getProductList             #");

        System.out.println("input:" + parameters);
        BasicDBObject q1 = null;
        DBCursor c;
        DatabaseConnector dbc = DatabaseConnector.getInstance();

        if (parameters.length() == 0) {
            System.out.println("parameters 0");
            c = dbc.read(Constants.PRODUCT_DATABASE, Constants.PRODUCT_COLLECTION);
        } else {
            q1 = (BasicDBObject) JSON.parse(parameters);
            c = dbc.read(Constants.PRODUCT_DATABASE, Constants.PRODUCT_COLLECTION, q1);
        }


        JSONArray jsonArray = new JSONArray();
        while(c.hasNext()){
            BasicDBObject dbo = (BasicDBObject) c.next();

            System.out.println("dbo to string" + dbo.toString());
            System.out.println("dbo to json" + dbo.toJson());
            ObjectMapper mapper = new ObjectMapper();
            try {
                // creates Product object from json based on annotations in class for member variables and constructor
                Product pr = new Product(dbo);
                // can't add directly to jsonarray, need to create jsonobject first. else jsonarray
                // adds forward slah before each quote
                JSONObject obb = new JSONObject(mapper.writeValueAsString(pr));
                jsonArray.put(obb);

            } catch (JsonProcessingException e) {
                System.out.println("problem mapping json objects" + e);
            }

            System.out.println("json array before return: " + jsonArray.toString());


        }
        return Response.ok(jsonArray.toString()).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteProducts(final String parameters) {
        System.out.println("input:" + parameters);
        BasicDBObject q1 = null;
        DBCursor c;
        DatabaseConnector dbc = DatabaseConnector.getInstance();

        if (parameters.length() == 0) {
            // return error, must provide filter for deletion
        } else {
            q1 = (BasicDBObject) JSON.parse(parameters);
            dbc.delete(Constants.PRODUCT_DATABASE, Constants.PRODUCT_COLLECTION, q1);
        }

        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProducts(final String parameters) {

        // update given attribute for the product with the given productId
        BasicDBObject query =(BasicDBObject) JSON.parse(parameters);
        int productId = query.getInt("productId");

        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.append("productId", productId);

        query.removeField("productId");

        System.out.println("search query:" + searchQuery.toString());
        System.out.println("update query:" + query.toString());

        BasicDBObject updateQuery = new BasicDBObject();
        updateQuery.append("$set", query);

        DatabaseConnector dbc = DatabaseConnector.getInstance();
        dbc.update(Constants.PRODUCT_DATABASE, Constants.PRODUCT_COLLECTION, searchQuery, updateQuery);

        return null;
    }

}
