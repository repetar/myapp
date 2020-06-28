package my.project.app.requesthandler.databaseobjects.quantity;

import my.project.app.requesthandler.databaseobjects.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuantityRepository extends MongoRepository<Quantity, String> {

    // method names must follow attribute names

}
