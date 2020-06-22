package my.project.app.requesthandler.databaseobjects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.BasicDBObject;

import java.beans.ConstructorProperties;

public class Product implements IDatabaseObject {

    BasicDBObject basicDBO = new BasicDBObject();

    @JsonProperty("productId")
    private int productId;

    @JsonProperty("productName")
    private String productName;

    @JsonProperty("productPrice")
    private double productPrice;

    @JsonProperty("productDescription")
    private String productDescription;

    @JsonProperty("category")
    private String category;

    @JsonProperty("quantity")
    private Quantity quantity;


    public Product (BasicDBObject dbObject) {
        this.productId = dbObject.getInt("productId");
        this.productName = dbObject.getString("productName");
        this.productPrice = dbObject.getDouble("productPrice");
        this.category = dbObject.getString("category");
        this.productDescription = dbObject.getString("productDescription");
        this.quantity = new Quantity((BasicDBObject) dbObject.get("quantity"));
    }

    @ConstructorProperties({"productId",
            "productName",
            "productPrice",
            "category",
            "productDescription",
            "quantity"})
    public Product(final int productId,
                   final String productName,
                   final double productPrice,
                   final String category,
                   final String productDescription,
                   final Quantity quantity) {

        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }

    public Product(final int productId,
                   final String productName,
                   final float productPrice,
                   final String productDescription) {

        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
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
        basicDBO.put("productId", this.getProductId());
        basicDBO.put("productName", this.getProductName());
        basicDBO.put("productPrice", this.getProductPrice());
        basicDBO.put("category", this.getCategory());
        basicDBO.put("productDescription", this.getProductDescription());
        basicDBO.put("quantity", this.quantity.createDBObject());
        return basicDBO;
    }
}
