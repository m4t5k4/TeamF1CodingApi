package com.example.f1codingbackend.controller;

import com.example.f1codingbackend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.f1codingbackend.model.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalTime;
import java.util.GregorianCalendar;
import java.util.Random;

@RestController
public class MainController {

    @Autowired
    private TableRepository tableRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    PlaceRepository placeRepository;

//    @Autowired
//    EmployeeRepository employeeRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostConstruct
    public void fillDB(){
        if (locationRepository.count()==0) {
            String[] address_list = {"2627  Hall Valley Drive", "2791  Buffalo Creek Road", "4976  Hayhurst Lane"};
            String[] name_list = {"Office 1", "Office 2", "Office 3"};
            for (int i = 0; i < address_list.length; i++) {
                Location location = new Location();
                location.setAddress(address_list[i]);
                location.setDescription("Office");
                location.setName(name_list[i]);
                locationRepository.save(location);
            }
        }
        if (tableRepository.count()==0){
            String[] names = {"Table 1","Table 2","Table 3","Table 4"};
            for (String name : names) {
                int rand = new Random().nextInt(names.length-1)+1;
                TableLocation newTable = new TableLocation();
                newTable.setName(name);
                newTable.setLocation(locationRepository.findById(rand));
                tableRepository.save(newTable);
            }
        }
        if (placeRepository.count()==0){
            String[] names = {"place 1","place 2","place 3","place 4"};
            for (String name : names) {
                int bound = ((int) tableRepository.count());
                int rand = new Random().nextInt(bound-1)+1;
                Place newplace = new Place();
                newplace.setTableLocation(tableRepository.findById(rand));
                placeRepository.save(newplace);
            }
        }
//        if (employeeRepository.count()==0)
//        {
//            for (int i = 1 ; i < 10 ; i++)
//            {
//                Employee employee = new Employee();
//                employee.setEmail("test" + i + "@gmail.com");
//                employee.setFirstname("Test" + i);
//                employee.setLastname("Test" + i);
//                employee.setPassword("test123");
//                employee.setRoleId(1);
//                employeeRepository.save(employee);
//            }
//        }

        if (userRepository.count()==0)
        {
            for (int i = 1 ; i < 10 ; i++)
            {
                User user = new User();
                user.setFirstname("Test" + i);
                user.setLastname("Test" + i);
                user.setUsername("test" + i + "@gmail.com");
                user.setPassword("$2a$10$k/1hEuJ2WWz9JSU9cuMP8uMMdaRkfPE/MGDH5/Cn8I/GNDxxt1aP2"); //password: test123
                userRepository.save(user);
            }
        }
        if (reservationRepository.count()==0)
        {
            for (int i = 1 ; i < 10 ; i++)
            {
                Reservation reservation = new Reservation();
                reservation.setDate(new java.util.Date());
                reservation.setUser(userRepository.findUserById(1L));
                reservation.setAmountPersons(5);
                reservation.setStartHour(LocalTime.of(8,10));
                reservation.setEndHour(LocalTime.of(19,00));
                reservation.setTableLocation(tableRepository.findById(1));
                reservationRepository.save(reservation);
            }
        }
        if (roleRepository.count()==0)
        {
            roleRepository.save(new Role(ERole.Employee));
            roleRepository.save(new Role(ERole.OfficeManager));
            roleRepository.save(new Role(ERole.Admin));
        }
    }
}
