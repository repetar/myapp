package my.project.app.requesthandler.databaseobjects;

import com.mongodb.BasicDBObject;

public class Quantity implements IDatabaseObject{

    BasicDBObject basicDBO = new BasicDBObject();

    private String product_id;

    private Long availableQuantity;

    private Long soldQuantity;

    public String getProduct_id() {
        return product_id;
    }

    public Long getAvailableQuantity() {
        return availableQuantity;
    }

    public Long getSoldQuantity() {
        return soldQuantity;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public void setAvailableQuantity(Long availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public void setSoldQuantity(Long soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public BasicDBObject createDBObject() {
        basicDBO.put("product_id", this.getProduct_id());
        basicDBO.put("availableQuantity", this.getAvailableQuantity());
        basicDBO.put("soldQuantity", this.getSoldQuantity());
        return basicDBO;
    }
}
