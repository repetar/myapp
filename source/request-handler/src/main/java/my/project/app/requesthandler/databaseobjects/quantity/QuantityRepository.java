package my.project.app.requesthandler.databaseobjects.quantity;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuantityRepository extends MongoRepository<Quantity, String> {

    // method names must follow attribute names

}
