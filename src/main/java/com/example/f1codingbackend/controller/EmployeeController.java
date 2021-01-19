package com.example.f1codingbackend.controller;
import com.example.f1codingbackend.model.Employee;
import com.example.f1codingbackend.model.Reservation;
import com.example.f1codingbackend.model.TableLocation;
import com.example.f1codingbackend.repository.EmployeeRepository;
import com.example.f1codingbackend.repository.ReservationRepository;
import com.example.f1codingbackend.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/employee")
    public List<Employee> employees()
    {
        List<Employee> employeeList = employeeRepository.findAll();
        return  employeeList;
    }
}
