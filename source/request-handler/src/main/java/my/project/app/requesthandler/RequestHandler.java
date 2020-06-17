package my.project.app.requesthandler;

import com.mongodb.*;
import com.mongodb.DBCollection;

import java.net.InetAddress;

import my.project.app.requesthandler.databaseobjects.TestObject;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;


public class RequestHandler {

    private static DBObject createDBObject(TestObject to) {
        BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();

        docBuilder.append("att1", to.getAtt1());
        docBuilder.append("att2", to.getAtt2());
        docBuilder.append("att3", to.getAtt3());
        docBuilder.append("att4", to.isAtt4());
        return docBuilder.get();
    }

    public static void main(final String[] args) {

        System.out.println("Hello!!!!!!!!!!!!!!!!!");
        InetAddress[] mongoPods = null;


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


        MongoClient mongoClient = new MongoClient(list);
        DB db = mongoClient.getDB("mytestdb");
        TestObject to = new TestObject(1, 2, "teststring", true);


        // create
        System.out.println("### CERATE");
        DBCollection col = db.getCollection("testcollection");
        DBObject dbo = createDBObject(to);

        WriteResult result = col.insert(dbo);
        System.out.println(result.getUpsertedId());
        System.out.println(result.getN());
        System.out.println(result.isUpdateOfExisting());
        System.out.println(result.wasAcknowledged());


        // read
        System.out.println("### READ");
        DBObject query = BasicDBObjectBuilder.start().add("att1", to.getAtt1()).get();
        DBCursor cursor = col.find(query);
        while(cursor.hasNext()){
            System.out.println(cursor.next());
        }

        //update example
        System.out.println("### UPDATE");
        to.setAtt1(6554);
        dbo = createDBObject(to);
        result = col.update(query, dbo);
        System.out.println(result.getUpsertedId());
        System.out.println(result.getN());
        System.out.println(result.isUpdateOfExisting());
        System.out.println(result.wasAcknowledged());

        //delete example
        System.out.println("### DELETE");
        result = col.remove(query);
        System.out.println(result.getUpsertedId());
        System.out.println(result.getN());
        System.out.println(result.isUpdateOfExisting());
        System.out.println(result.wasAcknowledged());

        //close resources
        mongoClient.close();


        while(true) {
            //

        }

    }

}
