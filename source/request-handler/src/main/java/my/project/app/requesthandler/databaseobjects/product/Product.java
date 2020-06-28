package my.project.app.requesthandler.databaseobjects.product;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {

    @Id
    private String id;

    @Indexed(unique=true)
    private String productName;

    private double productPrice;

    private String productDescription;

    private String category;

    public Product() {

    }

    public Product(final String productName,
                   final double productPrice,
                   final String category,
                   final String productDescription) {

        this.productName = productName;
        this.category = category;
        this.productDescription = productDescription;
        this.productPrice = productPrice;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

}
