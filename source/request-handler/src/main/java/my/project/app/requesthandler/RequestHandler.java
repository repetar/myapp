package my.project.app.requesthandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.*;

import com.mongodb.util.JSON;
import my.project.app.requesthandler.databaseconnector.DatabaseConnector;
import my.project.app.requesthandler.databaseobjects.*;
import my.project.app.requesthandler.httpserver.HttpServer;
import my.project.app.requesthandler.utils.Constants;
import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RequestHandler {


    public static void main(final String[] args) {


        System.out.println("Hello!!!!!!!!!!!!!!!!!");

        DBCursor cursor;
        DatabaseConnector dbc = DatabaseConnector.getInstance();

        TestObject to = new TestObject(111, 3, "teststring", true);
        dbc.create(Constants.DATABASE_NAME, Constants.COLLECTION_NAME, to);

        BasicDBObject query = new BasicDBObject();
        query.put("att1" , 111);

        dbc.read(Constants.DATABASE_NAME, Constants.COLLECTION_NAME, query);

        query.put("att1", 111);
        cursor = dbc.read(Constants.DATABASE_NAME, Constants.COLLECTION_NAME, query);
        while(cursor.hasNext()){
            BasicDBObject dbo = (BasicDBObject) cursor.next();
            System.out.println("dbo to string" + dbo.toString());
            System.out.println("dbo to json" + dbo.toJson());
        }
        System.out.println("###############################################################");

        dbc.create(Constants.DATABASE_NAME, Constants.COLLECTION_NAME, to);

        query.put("att1", to.getAtt1());
        cursor = dbc.read(Constants.DATABASE_NAME, Constants.COLLECTION_NAME, query);
        System.out.println("cursor size:" + cursor.size());
        while(cursor.hasNext()){
            BasicDBObject dbo = (BasicDBObject) cursor.next();
            System.out.println("dbo to string" + dbo.toString());
            System.out.println("dbo to json" + dbo.toJson());
        }
        System.out.println("###############################################################");

        query.put("att1", 222);
        cursor = dbc.read(Constants.DATABASE_NAME, Constants.COLLECTION_NAME, query);
        while(cursor.hasNext()){
            BasicDBObject dbo = (BasicDBObject) cursor.next();
            System.out.println("dbo to string" + dbo.toString());
            System.out.println("dbo to json" + dbo.toJson());
        }
        System.out.println("###############################################################");


        to.setAtt1(6554);
        dbc.update(Constants.DATABASE_NAME, Constants.COLLECTION_NAME, query, to);



        ////////////////////////////////////////////////////////////////7

        Quantity product1quantity = new Quantity(111, 8765L, 9L );
        Product product1 = new Product(111,"product1",  100, "category2", "first product", product1quantity);
        Product product2 = new Product(344,"product2",  100, "category2", "first product", product1quantity);

       // dbc.create(Constants.PRODUCT_DATABASE, Constants.PRODUCT_COLLECTION, product1);
        JSONArray ja = new JSONArray();

        ObjectMapper mapper = new ObjectMapper();
        try {
            JSONObject jo = new JSONObject(mapper.writeValueAsString(product1));
            System.out.println("product listing: " + jo.toString());
            ja.put(jo);
            jo = new JSONObject(mapper.writeValueAsString(product2));
            System.out.println("product listing: " + jo.toString());
            ja.put(jo);
        } catch (JsonProcessingException e) {
            System.out.println("problem mapping json objects" + e);
        }

        System.out.println("json array: " + ja.toString());


        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String d = formatter.format(new Date());
        Order o = new Order("122-345", d, Order.OrderStatus.IN_PROGRESS, d, d, d, 235, 9874d);

        dbc.create(Constants.DATABASE_NAME, Constants.COLLECTION_NAME, o);

        BasicDBObject q1 = new BasicDBObject();
        q1.put("orderNumber", o.getOrderNumber());
        DBCursor c1 = dbc.read(Constants.DATABASE_NAME, Constants.COLLECTION_NAME, q1);
        while(c1.hasNext()){
            BasicDBObject dbo = (BasicDBObject) c1.next();
            System.out.println("dbo to string" + dbo.toString());
            System.out.println("dbo to json" + dbo.toJson());
            ObjectMapper mp = new ObjectMapper();
            Order oo = new Order(dbo);
            try {
                JSONObject obb = new JSONObject(mp.writeValueAsString(oo));
                System.out.println("printing json object from object:" + obb);

            } catch (JsonProcessingException e) {
                System.out.println("problem mapping json objects" + e);
            }

        }

        System.out.println("######################################################################### user");
        User u = new User(9987,"name", "surname", "099-876-5432", "user address somewhere");
        dbc.create(Constants.DATABASE_NAME, Constants.COLLECTION_NAME, u);
        BasicDBObject q11 = new BasicDBObject();
        q11.put("userId", u.getUserId());
        c1 = dbc.read(Constants.DATABASE_NAME, Constants.COLLECTION_NAME, q11);

        while(c1.hasNext()){
            BasicDBObject dbo = (BasicDBObject) c1.next();
            System.out.println("dbo to string" + dbo.toString());
            System.out.println("dbo to json" + dbo.toJson());
            ObjectMapper mp = new ObjectMapper();
            User oo = new User(dbo);
            try {
                JSONObject obb = new JSONObject(mp.writeValueAsString(oo));
                System.out.println("printing json object from object:" + obb);

                User nu = mp.readValue(obb.toString(), User.class);
                System.out.println(nu.getAddress());

            } catch (JsonProcessingException e) {
                System.out.println("problem mapping json objects" + e);
            }



        }


        try (HttpServer httpServer = new HttpServer()) {
            httpServer.start();
            httpServer.join();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.exit(1);

        }




        dbc.delete(Constants.DATABASE_NAME, Constants.COLLECTION_NAME, query);

        dbc.close();

        while(true) {
            //

        }

    }

}
