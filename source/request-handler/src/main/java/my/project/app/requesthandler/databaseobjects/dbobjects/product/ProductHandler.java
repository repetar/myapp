package my.project.app.requesthandler.databaseobjects.dbobjects.product;

import my.project.app.requesthandler.databaseobjects.dbobjects.user.User;

import java.util.List;

public interface ProductHandler {

    List<Product> findAll();

    void put(Product product);

    Product findById(String id);
}
