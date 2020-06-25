package my.project.app.requesthandler.databaseobjects.dbobjects.product;

import my.project.app.requesthandler.databaseobjects.dbobjects.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

    // method names must follow attribute names

}
