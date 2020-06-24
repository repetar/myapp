package my.project.app.requesthandler.databaseobjects.dbobjecthandlers;

import my.project.app.requesthandler.databaseobjects.dbobjects.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

// service annotations goes into implementation
@Service
// as per standard, the implementation class name must follow intercae name + impl
public class UserHandlerImpl implements UserHandler{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserHandlerImpl() {
    }

    public void put(final User user) {
        userRepository.save(user);
    }

    public List<User> findAll(){
        return this.userRepository.findAll();
    }

    public User findByName(String firstName) {
        return this.userRepository.findByFirstName(firstName);
    }

}
