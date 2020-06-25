package my.project.app.requesthandler.databaseobjects.product;

import org.springframework.data.annotation.Id;

public class Quantity {

    @Id
    private int id;

    private Double availableQuantity;

    private Double soldQuantity;

    public Quantity(Double availableQuantity,
                    Double soldQuantity) {

        this.availableQuantity = availableQuantity;
        this.soldQuantity = soldQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Double availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Double getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(Double soldQuantity) {
        this.soldQuantity = soldQuantity;
    }




}
