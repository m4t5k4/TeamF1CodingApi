package com.example.f1codingbackend.controller;
import com.example.f1codingbackend.model.Employee;
import com.example.f1codingbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @PostConstruct
    public void render()
    {

    }

    @GetMapping("/employee")
    public List<Employee> employees()
    {
        List<Employee> employeeList = employeeRepository.findAll();
        return  employeeList;
    }
}
