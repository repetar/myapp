package my.project.app.requesthandler.rest;

import my.project.app.requesthandler.databaseobjects.order.Order;
import my.project.app.requesthandler.databaseobjects.order.OrderHandlerImpl;
import my.project.app.requesthandler.databaseobjects.product.Product;
import my.project.app.requesthandler.databaseobjects.product.ProductHandlerImpl;
import my.project.app.requesthandler.exceptions.OutOfStockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoTransactionException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@RestController
@RequestMapping("/orders")
public class Orders {

    @Autowired
    private OrderHandlerImpl orderHandler;

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping(value="/")
    public ResponseEntity<List<Order>> getAllOrders() {
        System.out.println("getting all orders");
        return ResponseEntity.ok().body(orderHandler.findAll());
    }

    @GetMapping(value= "/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable final String id) {
        System.out.println("trying to find by order id");
        return ResponseEntity.ok().body(orderHandler.findById(id));

    }

    @GetMapping(value= "/user/{userId}")
    public ResponseEntity<List<Order>> getOrdersByUserId(@PathVariable final String userId) {
        System.out.println("trying to find orders by user id");
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId));
        List<Order> orders = mongoTemplate.find(query, Order.class);
        System.out.println("printing orders");
        for (Order order : orders) {
            System.out.println("uid: " + order.getUserId() + " date: " + order.getOrderDate());

        }
        return ResponseEntity.ok().body(orders);

    }

    @PostMapping("/")
    public ResponseEntity<String> putOrder(@RequestBody final Order order) {
        try {
            orderHandler.newOrder(order);
        } catch (OutOfStockException e) {
            return ResponseEntity.ok().body("Product is out of stock!");
        } catch (MongoTransactionException e){
            return ResponseEntity.ok().body("Order creation failed.");
        }
        System.out.println("post order info: " + order.getId() + " : " + order.getDeliveryDate());
        return ResponseEntity.ok().body("Added order id: " + order.getId());
    }
}
