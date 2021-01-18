package com.example.f1codingbackend.controller;

import com.example.f1codingbackend.model.Employee;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {
    ArrayList<Employee> employees  = new ArrayList<>();

    @PostConstruct
    public void opvullen(){
        Employee emp = new Employee();
        emp.setFirstname("Test");
        emp.setLastname("Tester");
        employees.add(emp);
    }

    @GetMapping("/employees")
    public List<Employee> all()
    {
        return employees;
    }

    @GetMapping("/employees/{position}")
    public Employee one(@PathVariable int position)
    {
        return employees.get(position);
    }

//    @PostMapping("/opleidingen")
//    Opleiding add(@RequestBody Opleiding newOpleiding)
//    {
//        opleidingen.add((newOpleiding));
//        return newOpleiding;
//    }

//    @PutMapping("/opleidingen/{position}")
//    public Opleiding replaceOpleiding(@RequestBody Opleiding updateOpleiding, @PathVariable int position)
//    {
//        Opleiding opleiding = opleidingen.get(position);
//        opleiding.setNaam(updateOpleiding.getNaam());
//        opleiding.setAfkorting(updateOpleiding.getAfkorting());
//
//        return opleiding;
//    }
//
//    @DeleteMapping("/opleidingen/{position}")
//    public void deleteEmployee(@PathVariable int position)
//    {
//        opleidingen.remove(position);
//    }

}
