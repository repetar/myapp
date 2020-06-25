package my.project.app.requesthandler.databaseobjects.order;

import my.project.app.requesthandler.databaseobjects.product.Product;

import java.util.List;

public interface OrderHandler {

    List<Order> findAll();

    void put(Order order);

    Order findById(String id);
}
