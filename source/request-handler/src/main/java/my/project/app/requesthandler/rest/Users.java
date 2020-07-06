package  my.project.app.requesthandler.rest;

import my.project.app.requesthandler.databaseobjects.user.UserHandlerImpl;
import my.project.app.requesthandler.databaseobjects.user.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//Required imports
@RestController
@RequestMapping("/users")
public class Users {

    private static final Logger logger = LogManager.getLogger(Users.class);

    @Autowired
    private UserHandlerImpl userHandler;

    @GetMapping(value = "/")
    public ResponseEntity<List<User>> getAllUsers() {
        logger.info("getting all users");
        return ResponseEntity.ok().body(this.userHandler.findAll());
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable final String id) {
        logger.info("trying to find by id " + id);
        return ResponseEntity.ok().body(this.userHandler.findById(id));

    }

    @GetMapping(value = "/email")
    public ResponseEntity<User> getUserByEmail(@RequestBody final String email) {
        logger.info("trying to find by email " + email);
        User user = this.userHandler.findByEmail(email);
        logger.info("id: " + user.getId() + "  " + user.getFirstName());
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/")
    public ResponseEntity<String> putUser(@RequestBody final User user) {
        try {
            this.userHandler.put(user);
        } catch (DuplicateKeyException e) {
            logger.info("Email already taken.");
            return ResponseEntity.ok().body("email taken");
        }
        return ResponseEntity.ok().body(user.getId());
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResult> login(@RequestBody final User user) {
        User myuser = this.userHandler.findByEmail(user.getEmail());
        if (myuser != null && myuser.getPassword().equals(user.getPassword())) {
            logger.info("login succesfull");
            return ResponseEntity.ok().body(new LoginResult("succesfull", myuser.getId()));
        } else {
            logger.info("login failed");
            return ResponseEntity.ok().body(new LoginResult("fail", null));
        }
    }


    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable final String id) {
        this.userHandler.deleteUser(id);
    }


}