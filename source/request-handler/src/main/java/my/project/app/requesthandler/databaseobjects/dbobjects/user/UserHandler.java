package my.project.app.requesthandler.databaseobjects.dbobjects.user;

import my.project.app.requesthandler.databaseobjects.dbobjects.user.User;

import java.util.List;

public interface UserHandler {

    List<User> findAll();

    void put(User user);

    User findById(String id);

}
