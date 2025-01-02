package com.api.rest.controllers;

import com.api.rest.models.userModel;
import com.api.rest.services.userService;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    userService userService;

    @GetMapping()
    public ArrayList<userModel> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(path = "/{id}")
    public Optional<userModel> getUserById(@PathVariable("id") Long id) {
        return this.userService.getUserById(id);
    }

    @PostMapping()
    public userModel createUser(@RequestBody userModel user) {
        return this.userService.createUser(user);
    }   

    @GetMapping(path = "/query")
    public ArrayList<userModel> getUsersByPriority(@RequestParam("priority") Integer priority) {
        return this.userService.getUsersByPriority(priority);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        boolean ok = this.userService.deleteUser(id);
        if (ok) {
            return "User deleted";
        } else {
            return "User not deleted";
        }
    }


}
