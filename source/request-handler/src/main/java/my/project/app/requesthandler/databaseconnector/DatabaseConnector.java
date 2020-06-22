package my.project.app.requesthandler.databaseconnector;

import com.mongodb.*;
import my.project.app.requesthandler.databaseobjects.IDatabaseObject;
import my.project.app.requesthandler.databaseobjects.TestObject;
import my.project.app.requesthandler.utils.Constants;

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

    public void create(final String database, final String collection, final IDatabaseObject dbObject) {

        System.out.println("### CREATE");
        BasicDBObject dbo = dbObject.createDBObject();
        this.mongoClient.getDB(database).getCollection(collection).insert(dbo);
    }

    public DBCursor read(final String database, final String collection) {

        // read
        return this.mongoClient.getDB(database).getCollection(collection).find();
    }

    public DBCursor read(final String database, final String collection, final BasicDBObject query) {

        // read
        System.out.println("### READ query:" + query.toString());
        return this.mongoClient.getDB(database).getCollection(collection).find(query);
    }

    public DBCursor read(final String database, final String collection, final BasicDBObject query, final BasicDBObject projection) {

        // read
        System.out.println("### READ query:" + query.toString());
        return this.mongoClient.getDB(database).getCollection(collection).find(query, projection);
    }

    public void update(final String database, final String collection, final BasicDBObject searchQuery, final IDatabaseObject dbObject) {

        //update example
        System.out.println("### UPDATE");
        BasicDBObject dbo = dbObject.createDBObject();
        this.mongoClient.getDB(database).getCollection(collection).update(searchQuery, dbo);
    }

    public void update(final String database, final String collection, final BasicDBObject searchQuery, final BasicDBObject updateQuery) {

        //update example
        System.out.println("### UPDATE search query:" + searchQuery + " ; update query: " + updateQuery);
        this.mongoClient.getDB(database).getCollection(collection).update(searchQuery, updateQuery);
    }

    public void delete(final String database, final String collection, final BasicDBObject query) {

        System.out.println("### DELETE");
        this.mongoClient.getDB(database).getCollection(collection).remove(query);
    }

    public void close() {
        this.mongoClient.close();
    }
}
