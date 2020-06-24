package my.project.app.requesthandler.rest;

import my.project.app.requesthandler.databaseobjects.dbobjects.User;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface Users extends MongoRepository<User, String> {

    List<User> findByFirstName(@Param("firstName") String firstName);

}