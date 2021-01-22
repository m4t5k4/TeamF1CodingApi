package com.example.f1codingbackend.controller;

import com.example.f1codingbackend.model.User;
import com.example.f1codingbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/employees")
    public List<User> user()
    {
        List<User> userList = userRepository.findAll();
        return  userList;
    }

    @GetMapping("/employees/{id}")
    public User one(@PathVariable Long id)
    {
        return userRepository.findUserById(id);
    }

    @PostMapping("/employees")
    User add(@RequestBody User newUser)
    {
        userRepository.save(newUser);
        return newUser;
    }

    @PutMapping("/employees/{id}")
    public User replaceUser(@RequestBody User user,@PathVariable Long id)
    {
        User currentUser = userRepository.findUserById(id);
        currentUser.setFirstname(user.getFirstname());
        currentUser.setLastname(user.getLastname());
        currentUser.setPassword(user.getPassword());
        currentUser.setUsername(user.getUsername());
        userRepository.save(currentUser);
        return currentUser;
    }

    @DeleteMapping("/employees/{id}")
    public void deleteUser(@PathVariable Long id)
    {
        User user = userRepository.findUserById(id);
        userRepository.delete(user);
    }
}
