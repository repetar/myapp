package com.student.information.system.controller;

import my.project.app.requesthandler.databaseobjects.user.UserHandlerImpl;
import my.project.app.requesthandler.databaseobjects.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Required imports
@RestController
@RequestMapping("/users")
public class Users {

    @Autowired
    private UserHandlerImpl userHandler;

    @GetMapping(value = "/")
    public List<User> getAllUsers() {
        return userHandler.findAll();
    }

    /*
    @GetMapping(value = "/{id}")
    public User getStudentByStudentNumber(@PathVariable("id") String id) {
        return userHandler.getById(id);
    }


     */

    @PostMapping(value = "/")
    public ResponseEntity<?> putUser(@RequestBody User user) {
        userHandler.put(user);
        return new ResponseEntity("Student added successfully", HttpStatus.OK);
    }

    /*
    @DeleteMapping(value = "/{studentNumber}")
    public void deleteStudent(@PathVariable Long studentNumber) {
        studentService.deleteStudent(studentService.findByStudentNumber(studentNumber).getId());
    }
    */


}