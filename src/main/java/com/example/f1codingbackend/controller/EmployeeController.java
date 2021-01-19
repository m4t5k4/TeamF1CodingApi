package com.example.f1codingbackend.controller;
import com.example.f1codingbackend.model.Employee;
import com.example.f1codingbackend.model.Reservation;
import com.example.f1codingbackend.repository.EmployeeRepository;
import com.example.f1codingbackend.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ReservationRepository reservationRepository;

    @PostConstruct
    public void render()
    {
        for (int i = 1 ; i < 10 ; i++)
        {
            Employee employee = new Employee();
            employee.setEmail("test" + i + "@gmail.com");
            employee.setFirstname("Test" + i);
            employee.setLastname("Test" + i);
            employee.setPassword("test123");
            employee.setRoleId(1);
            employeeRepository.save(employee);
            Reservation reservation = new Reservation();
            reservation.setDate(new java.util.Date());
            reservation.setEmployee(employeeRepository.findById(1));
            reservation.setAmountPersons(5);
            reservationRepository.save(reservation);
        }
    }

    @GetMapping("/employee")
    public List<Employee> employees()
    {
        List<Employee> employeeList = employeeRepository.findAll();
        return  employeeList;
    }
}
