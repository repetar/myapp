package my.project.app.requesthandler.databaseobjects;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

import java.util.Date;

public class Order implements  IDatabaseObject {

    private String orderNumber;

    private OrderStatus orderStatus;

    private Date orderDate;

    private Date shipmentDate;

    private Date expectedDeliveryDate;

    private Date deliveryDate;

    /**
     * Instead of keeping a list of orders inside User class, to avoid growing arrays,
     * we will keep the userId inside of Order class.
     * Solving 1-to-N relations.
     */
    private String userId;

    public DBObject createDBObject() {
        BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
        return docBuilder.get();
    }

    private enum OrderStatus { IN_PROGRESS, COMPLETED, CANCELED }
}