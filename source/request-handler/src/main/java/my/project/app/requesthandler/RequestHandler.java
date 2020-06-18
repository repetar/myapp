package my.project.app.requesthandler;

import com.mongodb.*;

import my.project.app.requesthandler.databaseconnector.DatabaseConnector;
import my.project.app.requesthandler.databaseobjects.TestObject;
import my.project.app.requesthandler.httpserver.HttpServer;

public class RequestHandler {


    public static void main(final String[] args) {


        System.out.println("Hello!!!!!!!!!!!!!!!!!");

        try (HttpServer httpServer = new HttpServer()) {
            httpServer.start();
            httpServer.join();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.exit(1);

        }

        DatabaseConnector dbc = new DatabaseConnector();
        dbc.connect();
        TestObject to = new TestObject(1, 2, "teststring", true);
        dbc.create("mytestdb", "testcollection", to);

        DBObject query = BasicDBObjectBuilder.start().add("att1", to.getAtt1()).get();
        dbc.read("mytestdb", "testcollection", query);

        to.setAtt1(6554);
        dbc.update("mytestdb", "testcollection", query, to);

        dbc.delete("mytestdb", "testcollection", query);

        dbc.close();

        while(true) {
            //

        }

    }

}
