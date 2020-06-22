package my.project.app.requesthandler.databaseobjects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.BasicDBObject;

import java.beans.ConstructorProperties;

public class Quantity implements IDatabaseObject{

    BasicDBObject basicDBO = new BasicDBObject();

    @JsonProperty("productId")
    private int productId;

    @JsonProperty("availableQuantity")
    private Long availableQuantity;

    @JsonProperty("soldQuantity")
    private Long soldQuantity;

    public Quantity (BasicDBObject dbObject) {

        this.productId = dbObject.getInt("productId");
        this.availableQuantity = dbObject.getLong("availableQuantity");
        this.soldQuantity = dbObject.getLong("soldQuantity");
    }

    @ConstructorProperties({"productId",
            "availableQuantity",
            "soldQuantity"})
    public Quantity(int productId,
                    Long availableQuantity,
                    Long soldQuantity) {
        this.productId = productId;
        this.availableQuantity = availableQuantity;
        this.soldQuantity = soldQuantity;
    }

    public Quantity(Quantity quantity) {
        this(quantity.getProductId(), quantity.getAvailableQuantity(), quantity.getSoldQuantity());
    }

    public int getProductId() {
        return productId;
    }

    public Long getAvailableQuantity() {
        return availableQuantity;
    }

    public Long getSoldQuantity() {
        return soldQuantity;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setAvailableQuantity(Long availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public void setSoldQuantity(Long soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public BasicDBObject createDBObject() {
        basicDBO.put("productId", this.getProductId());
        basicDBO.put("availableQuantity", this.getAvailableQuantity());
        basicDBO.put("soldQuantity", this.getSoldQuantity());
        return basicDBO;
    }
}
