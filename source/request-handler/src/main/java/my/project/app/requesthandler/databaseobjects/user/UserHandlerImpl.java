package my.project.app.requesthandler.databaseobjects.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

// service annotations goes into implementation
@Service
// as per standard, the implementation class name must follow intercae name + impl
public class UserHandlerImpl implements UserHandler {

    @Autowired
    private UserRepository userRepository;

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

        System.out.println("finding user by id");
        return this.userRepository.findById(id).get();
    }

    public User findUser(User user) {
        Example<User> example = Example.of(user);
        return userRepository.findOne(example).get();
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);

    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

}
