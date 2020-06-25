package my.project.app.requesthandler.databaseobjects.order;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.UUID;

public class Order {

    @Id
    private String id;

    private String orderId;

    private String orderNumber;

    private OrderStatus orderStatus;

    private String orderDate;

    private String shipmentDate;

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
                 final String deliveryDate,
                 final String userId) {

            this.orderNumber = orderNumber;
            this.orderDate = orderDate;
            this.orderStatus = orderStatus;
            this.shipmentDate = shipmentDate;
            this.deliveryDate = deliveryDate;
            this.userId = userId;
            this.orderId = UUID.randomUUID().toString();


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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