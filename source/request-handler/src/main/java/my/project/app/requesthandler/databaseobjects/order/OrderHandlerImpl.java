package my.project.app.requesthandler.databaseobjects.order;

import my.project.app.requesthandler.databaseobjects.product.Product;
import my.project.app.requesthandler.databaseobjects.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderHandlerImpl implements  OrderHandler {


    @Autowired
    private OrderRepository orderRepository;

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

    public Order findProduct (Order order) {
        Example<Order> example = Example.of(order);
        return this.orderRepository.findOne(example).get();
    }

    public List<Order> findByUserId(final String userId) {
        return null;
    }
}
