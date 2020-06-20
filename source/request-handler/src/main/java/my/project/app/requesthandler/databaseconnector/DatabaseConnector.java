package my.project.app.requesthandler.databaseconnector;

import com.mongodb.*;
import my.project.app.requesthandler.databaseobjects.IDatabaseObject;
import my.project.app.requesthandler.databaseobjects.TestObject;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnector {

    private static volatile DatabaseConnector instance;

    MongoClient mongoClient;

    InetAddress[] mongoPods;

    private DatabaseConnector() {
        this.connect();
    }

    public static DatabaseConnector getInstance() {

        if (instance == null) {
            synchronized (DatabaseConnector.class) {
                if (instance == null) {
                    instance = new DatabaseConnector();
                }
            }
        }
        return instance;
    }

    public void connect() {
        try {
            mongoPods = InetAddress.getAllByName("example-mongodb-svc");
        } catch (UnknownHostException e) {
            System.out.println("Exception while getting mongo pods:" + e);
            // what to do if this fails??
        }
        List serverList = new ArrayList();
        for (InetAddress address : mongoPods) {
            serverList.add(new ServerAddress(address.getHostAddress(), 27017));
        }
        mongoClient = new MongoClient(serverList);
    }

    public void create(final String database, final String collection, final IDatabaseObject BasicDBObject) {

        System.out.println("### CREATE");
        BasicDBObject dbo = BasicDBObject.createDBObject();
        this.mongoClient.getDB(database).getCollection(collection).insert(dbo);
    }

    public DBCursor read(final String database, final String collection, final BasicDBObject query) {

        // read
        System.out.println("### READ query:" + query.toString());
        return this.mongoClient.getDB(database).getCollection(collection).find(query);
    }

    public void update(final String database, final String collection, final BasicDBObject query, final IDatabaseObject BasicDBObject) {

        //update example
        System.out.println("### UPDATE");
        BasicDBObject dbo = BasicDBObject.createDBObject();
        this.mongoClient.getDB(database).getCollection(collection).update(query, dbo);
    }

    public void delete(final String database, final String collection, final BasicDBObject query) {

        System.out.println("### DELETE");
        this.mongoClient.getDB(database).getCollection(collection).remove(query);
    }

    public void close() {
        this.mongoClient.close();
    }
}
