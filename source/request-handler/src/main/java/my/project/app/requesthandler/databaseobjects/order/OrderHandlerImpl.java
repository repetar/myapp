package my.project.app.requesthandler.databaseobjects.order;

import my.project.app.requesthandler.databaseobjects.quantity.Quantity;
import my.project.app.requesthandler.databaseobjects.quantity.QuantityHandlerImpl;
import my.project.app.requesthandler.exceptions.OutOfStockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class OrderHandlerImpl implements  OrderHandler {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    QuantityHandlerImpl quantityHandler;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    public OrderHandlerImpl() {
    }

    public void put(final Order order) {
        this.orderRepository.save(order);
    }

    public List<Order> findAll() {
        return this.orderRepository.findAll();
    }

    public Order findById(final String id) {
        return this.orderRepository.findById(id).get();
    }

    public List<Order> findByUserId(final String userId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId));
        List<Order> orders = this.mongoTemplate.find(query, Order.class);
        System.out.println("printing orders");
        for (Order order : orders) {
            System.out.println("uid: " + order.getUserId() + " date: " + order.getOrderDate());

        }
        return orders;
    }

    @Transactional
    public void newOrder(final Order order) throws OutOfStockException {
        Quantity quantity = this.quantityHandler.getQuantityByProductId(order.getProductId());
        // update product quantity
        System.out.println("available quantity: "  + quantity.getAvailableQuantity() + " for id: " + quantity.getId());
        if (quantity.getAvailableQuantity() > 1) {
            quantity.setAvailableQuantity(quantity.getAvailableQuantity() -1);

        } else {
            throw new OutOfStockException("Product is out of stock");
        }

        this.quantityHandler.put(quantity);
        this.orderRepository.save(order);


    }
}
