package my.project.app.requesthandler.databaseobjects.quantity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "quantity")
public class Quantity {

    @Id
    private String id;

    private int availableQuantity;

    private int soldQuantity;

    // only one quantity instance per product
    @Indexed(unique=true)
    private String productId;

    public Quantity() {

    }

    public Quantity(int availableQuantity,
                    int soldQuantity,
                    String productId) {

        this.availableQuantity = availableQuantity;
        this.soldQuantity = soldQuantity;
        this.productId = productId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public int getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(int soldQuantity) {
        this.soldQuantity = soldQuantity;
    }




}