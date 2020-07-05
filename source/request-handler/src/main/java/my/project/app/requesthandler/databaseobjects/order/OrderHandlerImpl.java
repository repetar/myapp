package my.project.app.requesthandler.databaseobjects.order;


import my.project.app.requesthandler.databaseobjects.product.Product;
import my.project.app.requesthandler.databaseobjects.product.ProductHandlerImpl;
import my.project.app.requesthandler.databaseobjects.product.ProductRepository;
import my.project.app.requesthandler.databaseobjects.quantity.Quantity;
import my.project.app.requesthandler.databaseobjects.quantity.QuantityHandlerImpl;
import my.project.app.requesthandler.exceptions.OutOfStockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class OrderHandlerImpl implements  OrderHandler {


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductHandlerImpl productHandler;

    @Autowired
    QuantityHandlerImpl quantityHandler;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    public OrderHandlerImpl() {
    }

    public void put(final Order order) {
        orderRepository.save(order);
    }

    public List<Order> findAll() {
        return this.orderRepository.findAll();
    }

    public Order findById(final String id) {
        return this.orderRepository.findById(id).get();
    }

    public List<Order> findByUserId(final String userId) {
        return null;
    }


    @Transactional
    public void newOrder(final Order order) throws OutOfStockException {
        Quantity quantity = quantityHandler.getQuantityByProductId(order.getProductId());
        // update product quantity
        System.out.println("available quantity: "  + quantity.getAvailableQuantity() + " for id: " + quantity.getId());
        if (quantity.getAvailableQuantity() > 1) {
            quantity.setAvailableQuantity(quantity.getAvailableQuantity() -1);

        } else {
            throw new OutOfStockException("Product is out of stock");
        }

        quantityHandler.put(quantity);
        orderRepository.save(order);


    }
    // decrease product availability count if at least 1
    // add new order together with count decrease. transaction, thread safe
    public void newOrder(final Order order, final Product product) {


    }
}
