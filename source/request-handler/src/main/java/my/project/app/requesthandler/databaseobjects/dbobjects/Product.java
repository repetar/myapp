package my.project.app.requesthandler.databaseobjects.dbobjects;

import org.springframework.data.annotation.Id;

public class Product {

    @Id
    private int id;

    private String productName;

    private double productPrice;

    private String productDescription;

    private String category;

    private Quantity quantity;

    public Product(final String productName,
                   final double productPrice,
                   final String category,
                   final String productDescription,
                   final Quantity quantity) {

        this.productName = productName;
        this.category = category;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }
}
