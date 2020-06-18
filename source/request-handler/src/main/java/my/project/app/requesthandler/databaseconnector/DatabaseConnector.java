package my.project.app.requesthandler.databaseconnector;

import com.mongodb.*;
import my.project.app.requesthandler.databaseobjects.IDatabaseObject;
import my.project.app.requesthandler.databaseobjects.TestObject;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnector {

    InetAddress[] mongoPods;
    MongoClient mongoClient;

    public DatabaseConnector() {


    }

    public void connect() {

        try {
            mongoPods = InetAddress.getAllByName("example-mongodb-svc");

        } catch (UnknownHostException e) {
            System.out.println("Exception while getting mongo pods:" + e);

        }

        List list = new ArrayList();

        for (InetAddress address : mongoPods) {
            //mongoAddresses.add(address.getHostAddress());
            list.add(new ServerAddress(address.getHostAddress(), 27017));

        }

        mongoClient = new MongoClient(list);

    }

    public void create(final String database, final String collection, final IDatabaseObject dbObject) {


        System.out.println("### CREATE");
        DB db = this.mongoClient.getDB(database);
        DBCollection col = db.getCollection(collection);
        DBObject dbo = dbObject.createDBObject();

        WriteResult result = col.insert(dbo);

        System.out.println(result.getUpsertedId());
        System.out.println(result.getN());
        System.out.println(result.isUpdateOfExisting());
        System.out.println(result.wasAcknowledged());

    }

    public void read(final String database, final String collection, final DBObject query) {

        // read
        System.out.println("### READ");
        DB db = this.mongoClient.getDB(database);
        DBCollection col = db.getCollection(collection);
        DBCursor cursor = col.find(query);
        while(cursor.hasNext()){
            System.out.println(cursor.next());
        }

    }

    public void update(final String database, final String collection, final DBObject query, final IDatabaseObject dbObject) {

        //update example
        System.out.println("### UPDATE");

        DBObject dbo = dbObject.createDBObject();
        DB db = this.mongoClient.getDB(database);
        DBCollection col = db.getCollection(collection);
        WriteResult result = col.update(query, dbo);
        System.out.println(result.getUpsertedId());
        System.out.println(result.getN());
        System.out.println(result.isUpdateOfExisting());
        System.out.println(result.wasAcknowledged());

    }

    public void delete(final String database, final String collection, final DBObject query) {

        System.out.println("### DELETE");
        DB db = this.mongoClient.getDB(database);
        DBCollection col = db.getCollection(collection);
        WriteResult result = col.remove(query);

        System.out.println(result.getUpsertedId());
        System.out.println(result.getN());
        System.out.println(result.isUpdateOfExisting());
        System.out.println(result.wasAcknowledged());

    }

    public void close() {
        this.mongoClient.close();
    }
}
