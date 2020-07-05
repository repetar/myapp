package my.project.app.requesthandler.databaseobjects.order;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {

    // method names must follow attribute names

}
