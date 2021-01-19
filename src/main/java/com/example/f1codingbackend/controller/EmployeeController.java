package com.example.f1codingbackend.controller;

import com.example.f1codingbackend.model.Employee;
import com.example.f1codingbackend.repository.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class EmployeeController {
    private EmployeeRepository employeeRepository;
    public EmployeeController(EmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;
    }
    @PostConstruct
    public void render()
    {
        for (int i = 0 ; i < 10 ; i++)
        {
            Employee employee = new Employee();
            employee.setFirstname("test " + i);
            employee.setEmail("test" + i + "@mail.com");
            employee.setFirstname("Test" + i);
            employee.setLastname("Test" + i);
            employee.setPassword("test123");
            employee.setRoleId(1);
            employeeRepository.save(employee);
        }
    }
}
