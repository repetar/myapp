package my.project.app.requesthandler.databaseobjects;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.BasicDBObject;

import java.time.Period;
import java.util.Date;

public class Product implements IDatabaseObject {

    BasicDBObject basicDBO = new BasicDBObject();

    private String productName;

    private float productPrice;

    private String productDescription;

    private Quantity quantity;

    public Product(final String productName,
                   final float productPrice,
                   final String productDescription) {

        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    public BasicDBObject createDBObject() {
        basicDBO.put("productName", this.getProductName());
        basicDBO.put("productPrice", this.getProductPrice());
        basicDBO.put("productDescription", this.getProductDescription());
        basicDBO.put("quantity", this.quantity.createDBObject());
        return basicDBO;
    }
}
