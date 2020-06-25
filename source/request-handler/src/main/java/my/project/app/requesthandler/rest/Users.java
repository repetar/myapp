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


    @GetMapping(value = "/{user_id}")
    public User getUserByUserId(@PathVariable final String user_id) {
        System.out.println("trying to find by id");
        User uu = userHandler.findByUserId(user_id);
        if (uu.getFirstName() != null) {
          System.out.println("first name: " + uu.getFirstName() );
        }
        return uu;
    }

    @GetMapping(value = "/id/{id}")
    public User getUserById(@PathVariable final String id) {
        System.out.println("trying to find by id");
        User uu = userHandler.findById(id);
        if (uu.getFirstName() != null) {
            System.out.println("first name: " + uu.getFirstName() );
        }
        return uu;
    }

    @GetMapping(value = "/smtng")
    public String getUserBySmtng() {
        System.out.println("trying to find by id");
        return "kjkjkkj";
    }


/*
    @PostMapping(value = "/")
    public ResponseEntity<?> putUser(@RequestBody User user) {

        userHandler.put(user);
        return new ResponseEntity("User added successfully", HttpStatus.OK);
    }


    @DeleteMapping(value = "/{studentNumber}")
    public void deleteStudent(@PathVariable Long studentNumber) {
        //studentService.deleteStudent(studentService.findByStudentNumber(studentNumber).getId());
    }

 */



}