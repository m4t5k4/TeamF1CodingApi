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
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.stream.IntStream;

@RestController
public class MainController {

    @Autowired
    private TableRepository tableRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    PlaceRepository placeRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostConstruct
    public void fillDB(){
        if (locationRepository.count()==0) {
            String[] address_list = {"Kempische Steenweg 293, 3500 Hasselt", "Kempische Steenweg 293, 3500 Hasselt"};
            String[] name_list = {"Corda campus 1", "Corda campus 2"};
            for (int i = 0; i < address_list.length; i++) {
                Location location = new Location();
                location.setAddress(address_list[i]);
                location.setDescription("Office");
                location.setName(name_list[i]);
                locationRepository.save(location);
            }
        }
        if (tableRepository.count()==0){
            //tables zone A corda 1
            for (int i = 1; i <= 4;i++) {
                TableLocation newTable = new TableLocation();
                newTable.setName("Table " + i);
                newTable.setLocation(locationRepository.findById(1));
                newTable.setZone("A");
                tableRepository.save(newTable);
            }
            //tables zone B corda 1
            for (int i = 1; i <= 5 ;i++) {
                TableLocation newTable = new TableLocation();
                newTable.setName("Table " + i);
                newTable.setLocation(locationRepository.findById(1));
                newTable.setZone("B");
                tableRepository.save(newTable);
            }
            //tables zone C corda 1
            for (int i = 1; i <= 4;i++) {
                TableLocation newTable = new TableLocation();
                newTable.setName("Table " + i);
                newTable.setLocation(locationRepository.findById(1));
                newTable.setZone("C");
                tableRepository.save(newTable);
            }
            //tables zone D corda 1
            for (int i = 1; i <= 4;i++) {
                TableLocation newTable = new TableLocation();
                newTable.setName("Table " + i);
                newTable.setLocation(locationRepository.findById(1));
                newTable.setZone("D");
                tableRepository.save(newTable);
            }
            //tables zone E corda 1
            for (int i = 1; i <= 3;i++) {
                TableLocation newTable = new TableLocation();
                newTable.setName("Table " + i);
                newTable.setLocation(locationRepository.findById(1));
                newTable.setZone("E");
                tableRepository.save(newTable);
            }

            //tables zone A corda 2
            for (int i = 1; i <= 3;i++) {
                TableLocation newTable = new TableLocation();
                newTable.setName("Table " + i);
                newTable.setLocation(locationRepository.findById(2));
                newTable.setZone("A");
                tableRepository.save(newTable);
            }

            //tables zone B corda 2
            for (int i = 1; i <= 3;i++) {
                TableLocation newTable = new TableLocation();
                newTable.setName("Table " + i);
                newTable.setLocation(locationRepository.findById(2));
                newTable.setZone("B");
                tableRepository.save(newTable);
            }

            //tables zone C corda 2
            for (int i = 1; i <= 6;i++) {
                TableLocation newTable = new TableLocation();
                newTable.setName("Table " + i);
                newTable.setLocation(locationRepository.findById(2));
                newTable.setZone("C");
                tableRepository.save(newTable);
            }

            //tables zone D corda 2
            for (int i = 1; i <= 5 ;i++) {
                TableLocation newTable = new TableLocation();
                newTable.setName("Table " + i);
                newTable.setLocation(locationRepository.findById(2));
                newTable.setZone("D");
                tableRepository.save(newTable);
            }
        }
        if (placeRepository.count()==0){
            for (int i = 1; i<=240;i++) {
                Place newplace = new Place();
                placeRepository.save(newplace);
            }
            Integer[] placeNums = {8,16,24,30,34,38,42,52,62,68,74,80,86,92,98,104,110,116,122,126,136,146,
                    154,162,170,178,182,186,190,194,202,210,216,224,232,238,240};
            ArrayList<Integer> values = new ArrayList<>();
            for (int id: placeNums) {
                values.add(id);
            }

            for (int num:values) {
                int start = 0;
                if (values.indexOf(num)!=0)
                    start = values.get(values.indexOf(num)-1);
                IntStream.range(start, num).forEachOrdered(n ->
                {
                    Place addPlaceToTable = placeRepository.findById(n+1);
                    System.out.println(values.indexOf(num));
                    addPlaceToTable.setTableLocation(tableRepository.findById(values.indexOf(num)+1));
                    placeRepository.save(addPlaceToTable);
                });

            }
        }
        if (employeeRepository.count()==0)
        {
            String[] first_name = {"Danny","Nico","Yentl","Ralph","Rudolf"};
            String[] last_name = {"Verelst","Wellens","Janssens","Appels","Verstrepen"};
            if (first_name.length == last_name.length)
            {
                for (int i = 0; i < first_name.length; i++)
                {
                    Employee employee = new Employee();
                    employee.setEmail(first_name[i] + "." +  last_name[i] +  "@gmail.com");
                    employee.setFirstname(first_name[i]);
                    employee.setLastname(last_name[i]);
                    employee.setPassword(first_name[i] + "123");
                    employee.setRoleId(1);
                    employeeRepository.save(employee);
                }
            }
            else
            {
                System.out.println("Please give the same amount of name/lastname");
            }
        }
        if (reservationRepository.count()==0)
        {
            for (int i = 1 ; i < 10 ; i++)
            {
                Reservation reservation = new Reservation();
                reservation.setDate(new java.util.Date());
                reservation.setEmployee(employeeRepository.findById(1));
                reservation.setAmountPersons(5);
                reservation.setStartHour(LocalTime.of(8,10));
                reservation.setEndHour(LocalTime.of(19,00));
                reservation.setTableLocation(tableRepository.findById(1));
                reservationRepository.save(reservation);
            }
        }
    }
}
