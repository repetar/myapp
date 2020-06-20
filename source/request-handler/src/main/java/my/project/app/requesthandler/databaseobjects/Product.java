package my.project.app.requesthandler.databaseobjects;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

import java.time.Period;
import java.util.Date;

public class Product implements IDatabaseObject {

    private String productName;

    private float productPrice;

    private String productDescription;

    private Quantity quantity;

    public Product(final String productName,
                   final float productPrice,
                   final String productDescription,
                   final int availableQuantity) {

        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.availableQuantity = availableQuantity;

    }

    public void setProductName(final String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductPrice(final float productPrice) { this.productPrice = productPrice; }

    public float getProductPrice() {
        return this.productPrice;
    }

    public void setProductDescription( final String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductDescription() {
        return this.productDescription;
    }

    public void setAvailableQuantity( final int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public int getAvailableQuantity() {
        return this.availableQuantity;
    }

    public DBObject createDBObject() {
        BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
        return docBuilder.get();
    }

}
