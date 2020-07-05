package my.project.app.requesthandler.databaseobjects.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

// service annotations goes into implementation
@Service
// as per standard, the implementation class name must follow intercae name + impl
public class UserHandlerImpl implements UserHandler {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    public UserHandlerImpl() {
    }

    public void put(final User user) {
        userRepository.save(user);
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User findById(final String id) {
        return this.userRepository.findById(id).get();
    }

    public User findUser(User user) {
        Example<User> example = Example.of(user);
        return userRepository.findOne(example).get();
    }

    public User findByEmail(String email) {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));
        mongoTemplate.findOne(query, User.class, "users");
        return mongoTemplate.findOne(query, User.class);

    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

}
