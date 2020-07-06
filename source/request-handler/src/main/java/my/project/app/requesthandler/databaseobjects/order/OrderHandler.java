package my.project.app.requesthandler.databaseobjects.order;

import my.project.app.requesthandler.exceptions.OutOfStockException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderHandler {

    List<Order> findAll();

    void put(Order order);

    Order findById(String id);

    List<Order> findByUserId(final String userId);

    @Transactional
    void newOrder(final Order order) throws OutOfStockException;
}
