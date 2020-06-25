package my.project.app.requesthandler.databaseobjects.dbobjects.order;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Order {

    @Id
    private ObjectId id;

    private String orderNumber;

    private OrderStatus orderStatus;

    private String orderDate;

    private String shipmentDate;

    private String expectedDeliveryDate;

    private String deliveryDate;

    /**
     * Instead of keeping a list of orders inside User class, to avoid growing arrays,
     * we will keep the userId inside of Order class.
     * Solving 1-to-N relations.
     */
    private String userId;

    public Order(final String orderNumber,
                 final String orderDate,
                 final OrderStatus orderStatus,
                 final String shipmentDate,
                 final String expectedDeliveryDate,
                 final String deliveryDate,
                 final String userId) {

            this.orderNumber = orderNumber;
            this.orderDate = orderDate;
            this.orderStatus = orderStatus;
            this.shipmentDate = shipmentDate;
            this.expectedDeliveryDate = expectedDeliveryDate;
            this.deliveryDate = deliveryDate;
            this.userId = userId;

    }

    public enum OrderStatus { IN_PROGRESS, COMPLETED, CANCELED }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(String shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public String getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(String expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}