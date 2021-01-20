package com.example.f1codingbackend.controller;
import com.example.f1codingbackend.model.Employee;
import com.example.f1codingbackend.model.Reservation;
import com.example.f1codingbackend.model.TableLocation;
import com.example.f1codingbackend.repository.EmployeeRepository;
import com.example.f1codingbackend.repository.ReservationRepository;
import com.example.f1codingbackend.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ReservationRepository reservationRepository;

    @GetMapping("/employees")
    public List<Employee> employees()
    {
        List<Employee> employeeList = employeeRepository.findAll();
        return  employeeList;
    }

    @GetMapping("/employees/{position}")
    public Employee one(@PathVariable int position)
    {
        return employeeRepository.findById(position);
    }

    @PostMapping("/employees")
    Employee add(@RequestBody Employee newEmployee)
    {
        employeeRepository.save(newEmployee);
        return newEmployee;
    }

    @PutMapping("/employees/{position}")
    public Employee replaceEmployee(@RequestBody Employee employee,@PathVariable int position)
    {
        Employee currentEmployee = employeeRepository.findById(position);
        currentEmployee.setFirstname(employee.getFirstname());
        currentEmployee.setLastname(employee.getLastname());
        currentEmployee.setPassword(employee.getPassword());
        currentEmployee.setRoleId(employee.getRoleId());
        currentEmployee.setEmail(employee.getEmail());
        employeeRepository.save(currentEmployee);
        return currentEmployee;
    }

    @DeleteMapping("/employees/{position}")
    public void deleteEmployee(@PathVariable int position)
    {
        Employee employee = employeeRepository.findById(position);
        List <Reservation> reservations = employee.getReservations();
        for (Reservation reservation : reservations)
        {
            reservationRepository.delete(reservation);
        }
        employeeRepository.delete(employee);
    }
}
