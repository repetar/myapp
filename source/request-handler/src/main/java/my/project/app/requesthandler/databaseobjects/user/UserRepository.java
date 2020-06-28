package my.project.app.requesthandler.databaseobjects.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface UserRepository extends MongoRepository<User, String> {

    // method names must follow attribute names

    User findByEmail(final String email);

}
