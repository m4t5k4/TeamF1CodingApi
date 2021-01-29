package com.example.f1codingbackend.controller;

import com.example.f1codingbackend.model.User;
import com.example.f1codingbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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

    @PutMapping("/employees")
    public User replaceUser(@RequestBody User user)
    {
        User currentUser = userRepository.findUserById(user.getId());
        currentUser.setFirstname(user.getFirstname());
        currentUser.setLastname(user.getLastname());
        currentUser.setPassword(user.getPassword());
        currentUser.setUsername(user.getUsername());
        currentUser.setRoles(user.getRoles());
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
