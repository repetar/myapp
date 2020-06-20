package my.project.app.requesthandler;

import com.mongodb.*;

import com.mongodb.util.JSON;
import my.project.app.requesthandler.databaseconnector.DatabaseConnector;
import my.project.app.requesthandler.databaseobjects.TestObject;
import my.project.app.requesthandler.httpserver.HttpServer;
import my.project.app.requesthandler.utils.Constants;

public class RequestHandler {


    public static void main(final String[] args) {


        System.out.println("Hello!!!!!!!!!!!!!!!!!");

        DatabaseConnector dbc = DatabaseConnector.getInstance();

        TestObject to = new TestObject(111, 3, "teststring", true);
        dbc.create(Constants.DATABASE_NAME, Constants.COLLECTION_NAME, to);

        DBObject query = BasicDBObjectBuilder.start().add("att1" , 111).add("attr2", 3).get();

        dbc.read(Constants.DATABASE_NAME, Constants.COLLECTION_NAME, query);

        query = BasicDBObjectBuilder.start().add("att1", 111).get();
        dbc.read(Constants.DATABASE_NAME, Constants.COLLECTION_NAME, query);

        TestObject to1 = new TestObject(222, 2, "teststring", true);
        dbc.create(Constants.DATABASE_NAME, Constants.COLLECTION_NAME, to1);

        query = BasicDBObjectBuilder.start().add("att1", to1.getAtt1()).get();
        dbc.read(Constants.DATABASE_NAME, Constants.COLLECTION_NAME, query);

        query = BasicDBObjectBuilder.start().add("att1", 222).get();
        dbc.read(Constants.DATABASE_NAME, Constants.COLLECTION_NAME, query);

        to.setAtt1(6554);
        dbc.update(Constants.DATABASE_NAME, Constants.COLLECTION_NAME, query, to);

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
