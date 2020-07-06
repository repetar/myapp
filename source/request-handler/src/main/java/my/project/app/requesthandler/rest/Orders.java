package my.project.app.requesthandler.rest;

import my.project.app.requesthandler.databaseobjects.order.Order;
import my.project.app.requesthandler.databaseobjects.order.OrderHandlerImpl;
import my.project.app.requesthandler.databaseobjects.quantity.QuantityHandlerImpl;
import my.project.app.requesthandler.exceptions.OutOfStockException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoTransactionException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class Orders {

    private static final Logger logger = LogManager.getLogger(Orders.class);

    @Autowired
    private OrderHandlerImpl orderHandler;

    @GetMapping(value="/")
    public ResponseEntity<List<Order>> getAllOrders() {
        logger.info("getting all orders");
        return ResponseEntity.ok().body(this.orderHandler.findAll());
    }

    @GetMapping(value= "/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable final String id) {
        logger.info("trying to find by order id");
        return ResponseEntity.ok().body(this.orderHandler.findById(id));

    }

    @GetMapping(value= "/user/{userId}")
    public ResponseEntity<List<Order>> getOrdersByUserId(@PathVariable final String userId) {
        logger.info("trying to find orders by user id");
        List<Order> orders = this.orderHandler.findByUserId(userId);
        return ResponseEntity.ok().body(orders);
    }

    @PostMapping("/")
    public ResponseEntity<String> putOrder(@RequestBody final Order order) {
        try {
            this.orderHandler.newOrder(order);
        } catch (OutOfStockException e) {
            logger.info("Product is out of stock");
            return ResponseEntity.ok().body("Product is out of stock!");
        } catch (MongoTransactionException e){
            return ResponseEntity.ok().body("Order creation failed.");
        }
        logger.info("post order info: " + order.getId() + " : " + order.getDeliveryDate());
        return ResponseEntity.ok().body("Added order id: " + order.getId());
    }
}
