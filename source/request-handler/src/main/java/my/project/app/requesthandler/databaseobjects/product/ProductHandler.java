package my.project.app.requesthandler.databaseobjects.product;

import java.util.List;

public interface ProductHandler {

    List<Product> findAll();

    void put(Product product);

    Product findById(String id);
}
