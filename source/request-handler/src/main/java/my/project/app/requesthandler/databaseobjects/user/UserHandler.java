package my.project.app.requesthandler.databaseobjects.user;

import java.util.List;

public interface UserHandler {

    List<User> findAll();

    void put(User user);

    User findById(String id);

    void deleteUser(String id);

    User findByEmail(String email);
}
