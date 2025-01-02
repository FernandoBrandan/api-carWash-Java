package com.api.rest.services;

import com.api.rest.models.userModel;
import com.api.rest.repositories.userRepository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {
    @Autowired
    userRepository userRepository;

    public ArrayList<userModel> getUsers() {
        userRepository.findAll().forEach(userModel -> {
            System.out.println(userModel.getName());
        });
        return (ArrayList<userModel>) userRepository.findAll();
    }

    public Optional<userModel> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public userModel createUser(userModel user) {
        if (user.getId() != null) {
            throw new IllegalArgumentException("New users should not have an ID");
        }
        System.out.println("Creating user");
        return userRepository.save(user);
    }

    public userModel updateUser(userModel user) {
        if (user.getId() == null || !userRepository.existsById(user.getId())) {
            throw new Error("User not found with id: " + user.getId());
        }
        System.out.println("Updating user");
        return userRepository.save(user);
    }

    public ArrayList<userModel> getUsersByPriority(Integer priority) {
        return userRepository.findByPriority(priority);
    }

    public boolean deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}