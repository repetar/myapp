package my.project.app.requesthandler.databaseobjects.dbobjects;

import org.springframework.data.annotation.Id;

public class Quantity {

    @Id
    private int id;

    private Long availableQuantity;

    private Long soldQuantity;

    public Quantity(Long availableQuantity,
                    Long soldQuantity) {

        this.availableQuantity = availableQuantity;
        this.soldQuantity = soldQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Long availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Long getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(Long soldQuantity) {
        this.soldQuantity = soldQuantity;
    }




}
