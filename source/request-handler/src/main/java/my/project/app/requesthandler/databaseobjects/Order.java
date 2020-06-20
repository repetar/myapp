package my.project.app.requesthandler.databaseobjects;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.BasicDBObject;

import java.util.Date;

public class Order implements  IDatabaseObject {

    BasicDBObject basicDBO = new BasicDBObject();

    private String orderNumber;

    private OrderStatus orderStatus;

    private Date orderDate;

    private Date shipmentDate;

    private Date expectedDeliveryDate;

    private Date deliveryDate;

    /**
     * Instead of keeping a list of orders inside User class, to avoid growing arrays,
     * we will keep the userId inside of Order class.
     * Solving 1-to-N relations.
     */
    private String userId;

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

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(Date shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public Date getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BasicDBObject createDBObject() {
        basicDBO.put("orderNumber", this.getOrderNumber());
        basicDBO.put("orderStatus", this.getOrderStatus());
        basicDBO.put("orderDate", this.getOrderDate());
        basicDBO.put("shipmentDate", this.getShipmentDate());
        basicDBO.put("expectedDeliveryDate", this.getExpectedDeliveryDate());
        basicDBO.put("deliveryDate", this.getDeliveryDate());
        return basicDBO;
    }

    private enum OrderStatus { IN_PROGRESS, COMPLETED, CANCELED }
}