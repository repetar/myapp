package my.project.app.requesthandler.databaseobjects.dbobjecthandlers;

import my.project.app.requesthandler.databaseobjects.dbobjects.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    // method names must follow attribute names
    User findByFirstName(String firstName);

}
