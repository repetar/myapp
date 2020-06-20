package my.project.app.requesthandler.databaseobjects;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

import java.time.Period;
import java.util.Date;

/**
 * Discounts will be linked to products by holding product_id. We don't want
 * to have a constantly growing array of discounts in the Product class.
 */
public class Discount implements IDatabaseObject {

    private int discount;

    private Date startDate;

    private Period period;

    public DBObject createDBObject() {
        BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
        return docBuilder.get();
    }

}


