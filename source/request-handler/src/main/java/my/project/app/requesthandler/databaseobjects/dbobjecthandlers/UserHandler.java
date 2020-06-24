package my.project.app.requesthandler.databaseobjects.dbobjecthandlers;

import my.project.app.requesthandler.databaseobjects.dbobjects.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserHandler {

    List<User> findAll();

    void put(User user);

    User findByName(String firstName);

}
