package my.project.app.requesthandler.databaseobjects.dbobjects.user;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    // method names must follow attribute names

}
