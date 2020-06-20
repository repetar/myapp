package my.project.app.requesthandler.databaseobjects;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.BasicDBObject;

import java.time.Period;
import java.util.Date;

/**
 * Discounts will be linked to products by holding product_id. We don't want
 * to have a constantly growing array of discounts in the Product class.
 */
public class Discount implements IDatabaseObject {

    BasicDBObject basicDBO = new BasicDBObject();

    private int discount;

    private Date startDate;

    private Period period;

    private int productId;

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public BasicDBObject createDBObject() {
        basicDBO.put("discount", this.getDiscount());
        basicDBO.put("startDate", this.getStartDate());
        basicDBO.put("period", this.getPeriod());
        basicDBO.put("productId", this.getProductId());
        return basicDBO;
    }

}


