package  my.project.app.requesthandler.rest;

import my.project.app.requesthandler.databaseobjects.user.UserHandlerImpl;
import my.project.app.requesthandler.databaseobjects.user.User;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

//Required imports
@RestController
@RequestMapping("/users")
public class Users {

    @Autowired
    private UserHandlerImpl userHandler;

    //  {'Access-Control-Allow-Origin': '*'}
    @GetMapping(value = "/")
    public ResponseEntity<List<User>> getAllUsers() {
        System.out.println("getting all users");
        return ResponseEntity.ok().body(userHandler.findAll());
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable final String id) {
        System.out.println("trying to find by id " + id);
        return ResponseEntity.ok().body(userHandler.findById(id));

    }

    @GetMapping(value = "/email")
    public ResponseEntity<User> getUserByEmail(@RequestBody final String email) {
        System.out.println("trying to find by email " + email);
        User user = userHandler.findByEmail(email);
        System.out.println("id: " + user.getId() + "  " + user.getFirstName());
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/")
    public ResponseEntity<String> putUser(@RequestBody final User user) {
        try {
            userHandler.put(user);
        } catch (DuplicateKeyException e) {
            System.out.println("Email already taken.");
            return ResponseEntity.ok().body("email taken");
        }
        return ResponseEntity.ok().body(user.getId());
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResult> login(@RequestBody final User user) {
        User myuser = userHandler.findByEmail(user.getEmail());
        if (myuser != null && myuser.getPassword().equals(user.getPassword())) {
            System.out.println("login succesfull");
            return ResponseEntity.ok().body(new LoginResult("succesfull", myuser.getId()));
        } else {
            System.out.println("login failed");
            return ResponseEntity.ok().body(new LoginResult("fail", null));
        }
    }


    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable final String id) {
        userHandler.deleteUser(id);
    }


}