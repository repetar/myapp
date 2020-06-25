package my.project.app.requesthandler.databaseobjects.user;

import java.util.List;

public interface UserHandler {

    List<User> findAll();

    void put(User user);

    User findById(String id);

    User findByUserId(String userId);


}
