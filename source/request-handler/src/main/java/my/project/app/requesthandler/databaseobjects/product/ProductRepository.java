package my.project.app.requesthandler.databaseobjects.product;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

    // method names must follow attribute names

}
