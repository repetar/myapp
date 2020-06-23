package my.project.app.requesthandler.databaseobjects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.BasicDBObject;

import java.beans.ConstructorProperties;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Order implements  IDatabaseObject {

    BasicDBObject basicDBO = new BasicDBObject();

    @JsonProperty("orderNumber")
    private String orderNumber;

    @JsonProperty("orderStatus")
    private OrderStatus orderStatus;

    @JsonProperty("orderDate")
    private String orderDate;

    @JsonProperty("shipmentDate")
    private String shipmentDate;

    @JsonProperty("expectedDeliveryDate")
    private String expectedDeliveryDate;

    @JsonProperty("deliveryDate")
    private String deliveryDate;

    @JsonProperty("productId")
    private int productId;

    /**
     * Instead of keeping a list of orders inside User class, to avoid growing arrays,
     * we will keep the userId inside of Order class.
     * Solving 1-to-N relations.
     */
    @JsonProperty("userId")
    private Double userId;

    public Order (BasicDBObject dbObject) {

            this.orderNumber = dbObject.getString("orderNumber");
            this.orderStatus = OrderStatus.valueOf(dbObject.getString("orderStatus"));
            this.orderDate = dbObject.getString("orderDate");
            this.shipmentDate = dbObject.getString("shipmentDate");
            this.expectedDeliveryDate = dbObject.getString("expectedDeliveryDate");
            this.deliveryDate = dbObject.getString("deliveryDate");
            this.productId = dbObject.getInt("productId");
            this.userId = dbObject.getDouble("userId");
    }

    @ConstructorProperties({"orderNumber",
            "orderDate",
            "orderStatus",
            "shipmentDate",
            "expectedDeliveryDate",
            "deliveryDate",
            "productId",
            "userId"})
    public Order(final String orderNumber,
                 final String orderDate,
                 final OrderStatus orderStatus,
                 final String shipmentDate,
                 final String expectedDeliveryDate,
                 final String deliveryDate,
                 final int productId,
                 final Double userId) {

            this.orderNumber = orderNumber;
            this.orderDate = orderDate;
            this.orderStatus = orderStatus;
            this.shipmentDate = shipmentDate;
            this.expectedDeliveryDate = expectedDeliveryDate;
            this.deliveryDate = deliveryDate;
            this.productId = productId;
            this.userId = userId;

    }

    public void setUserId(Double userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId =  productId;
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

    public Double getUserId() {
        return userId;
    }

    public BasicDBObject createDBObject() {
        basicDBO.put("orderNumber", this.getOrderNumber());
        basicDBO.put("orderStatus", this.getOrderStatus().toString());
        basicDBO.put("orderDate", this.getOrderDate());
        basicDBO.put("shipmentDate", this.getShipmentDate());
        basicDBO.put("expectedDeliveryDate", this.getExpectedDeliveryDate());
        basicDBO.put("deliveryDate", this.getDeliveryDate());
        basicDBO.put("productId", this.getProductId());
        basicDBO.put("userId", this.getUserId());
        return basicDBO;
    }

    public enum OrderStatus { IN_PROGRESS, COMPLETED, CANCELED }
}