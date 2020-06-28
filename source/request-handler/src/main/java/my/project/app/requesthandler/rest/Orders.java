package my.project.app.requesthandler.rest;

import my.project.app.requesthandler.databaseobjects.order.Order;
import my.project.app.requesthandler.databaseobjects.order.OrderHandlerImpl;
import my.project.app.requesthandler.databaseobjects.product.Product;
import my.project.app.requesthandler.databaseobjects.product.ProductHandlerImpl;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping(value="/")
    public ResponseEntity<List<Order>> getAllOrders() {
        System.out.println("getting all orders");
        return ResponseEntity.ok().body(orderHandler.findAll());
    }

    @GetMapping(value= "/{id}")
    public ResponseEntity<Order> getProductById(@PathVariable final String id) {
        System.out.println("trying to find by order id");
        return ResponseEntity.ok().body(orderHandler.findById(id));

    }

    @PostMapping("/")
    public ResponseEntity<String> putOrder(@RequestBody final Order order) {
        orderHandler.put(order);
        System.out.println("post order info: " + order.getId() + " : " + order.getDeliveryDate());
        return ResponseEntity.ok().body("Added order id: " + order.getId());
    }
}
