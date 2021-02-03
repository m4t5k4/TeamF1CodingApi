package com.example.f1codingbackend.controller;

import com.example.f1codingbackend.model.Role;
import com.example.f1codingbackend.repository.RoleRepository;
import com.example.f1codingbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/roles")
    public List<Role> all() { return roleRepository.findAll(); }

    @GetMapping("/roles/{id}")
    public Role one(@PathVariable Integer id) { return roleRepository.findById(id); }
}
