package  my.project.app.requesthandler.rest;

import my.project.app.requesthandler.databaseobjects.user.UserHandlerImpl;
import my.project.app.requesthandler.databaseobjects.user.User;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping(value = "/")
    public List<User> getAllUsers() {
        System.out.println("getting all users");
        return userHandler.findAll();
    }


    @GetMapping(value = "/{id}")
    public User getUserById(@PathVariable final String id) {
        System.out.println("trying to find by id");
        return userHandler.findById(id);

    }

    @PostMapping("/")
    public ResponseEntity<?> putUser(@RequestBody final User user) {
        userHandler.put(user);
        System.out.println("post user info: " + user.getId() + " : " + user.getFirstName() + " : " + user.getEmail());
        return new ResponseEntity("User added successfully", HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}")
    public void deleteStudent(@PathVariable final String id) {
        userHandler.deleteUser(id);
    }





}