package com.example.f1codingbackend.controller;

import com.example.f1codingbackend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.f1codingbackend.model.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;
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
    UserRepository userRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    IOTRepository iotRepository;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostConstruct
    public void fillDB() {
        if (locationRepository.count() == 0) {
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
        if (tableRepository.count() == 0) {
            //tables zone A corda 1
            for (int i = 1; i <= 4; i++) {
                TableLocation newTable = new TableLocation();
                newTable.setName("Tafel " + i);
                newTable.setLocation(locationRepository.findById(1));
                newTable.setZone("A");
                tableRepository.save(newTable);
            }
            //tables zone B corda 1
            for (int i = 1; i <= 5; i++) {
                TableLocation newTable = new TableLocation();
                newTable.setName("Tafel " + i);
                newTable.setLocation(locationRepository.findById(1));
                newTable.setZone("B");
                tableRepository.save(newTable);
            }
            //tables zone C corda 1
            for (int i = 1; i <= 4; i++) {
                TableLocation newTable = new TableLocation();
                newTable.setName("Tafel " + i);
                newTable.setLocation(locationRepository.findById(1));
                newTable.setZone("C");
                tableRepository.save(newTable);
            }
            //tables zone D corda 1
            for (int i = 1; i <= 4; i++) {
                TableLocation newTable = new TableLocation();
                newTable.setName("Tafel " + i);
                newTable.setLocation(locationRepository.findById(1));
                newTable.setZone("D");
                tableRepository.save(newTable);
            }
            //tables zone E corda 1
            for (int i = 1; i <= 3; i++) {
                TableLocation newTable = new TableLocation();
                newTable.setName("Tafel " + i);
                newTable.setLocation(locationRepository.findById(1));
                newTable.setZone("E");
                tableRepository.save(newTable);
            }

            //tables zone A corda 2
            for (int i = 1; i <= 3; i++) {
                TableLocation newTable = new TableLocation();
                newTable.setName("Tafel " + i);
                newTable.setLocation(locationRepository.findById(2));
                newTable.setZone("A");
                tableRepository.save(newTable);
            }

            //tables zone B corda 2
            for (int i = 1; i <= 3; i++) {
                TableLocation newTable = new TableLocation();
                newTable.setName("Tafel " + i);
                newTable.setLocation(locationRepository.findById(2));
                newTable.setZone("B");
                tableRepository.save(newTable);
            }

            //tables zone C corda 2
            for (int i = 1; i <= 6; i++) {
                TableLocation newTable = new TableLocation();
                newTable.setName("Tafel " + i);
                newTable.setLocation(locationRepository.findById(2));
                newTable.setZone("C");
                tableRepository.save(newTable);
            }

            //tables zone D corda 2
            for (int i = 1; i <= 5; i++) {
                TableLocation newTable = new TableLocation();
                newTable.setName("Tafel " + i);
                newTable.setLocation(locationRepository.findById(2));
                newTable.setZone("D");
                tableRepository.save(newTable);
            }
        }
        if (placeRepository.count() == 0) {
            Integer[] placeNums = {8, 16, 24, 30, 34, 38, 42, 52, 62, 68, 74, 80, 86, 92, 98, 104, 110, 116, 122, 126, 136, 146,
                    154, 162, 170, 178, 182, 186, 190, 194, 202, 210, 216, 224, 232, 238, 240};
            ArrayList<Integer> values = new ArrayList<>();
            for (int id : placeNums) {
                values.add(id);
            }

            for (int i = 1; i <= 240; i++) {

            }

            for (int num : values) {
                int start = 0;
                if (values.indexOf(num) != 0)
                    start = values.get(values.indexOf(num) - 1);
                IntStream.range(start, num).forEachOrdered(n ->
                {
                    int placeNr = 0;
                    if (values.indexOf(num) != 0){ placeNr = n - values.get(values.indexOf(num) - 1)+1; }
                    else { placeNr = n+1; }
                    String name = "Plaats "+ placeNr ;
                    Place addPlaceToTable = new Place();
                    addPlaceToTable.setName(name);
                    addPlaceToTable.setTableLocation(tableRepository.findById(values.indexOf(num) + 1));
                    placeRepository.save(addPlaceToTable);
                });

            }
        }

        if (userRepository.count() == 0) {
            String [] first_names = {"David","Jelle","Randy","Marcel","Gert","Bill","Chloe","Christie","Nana","Darrel"};
            String [] last_names = {"Lim","Findlay","Verstrepen","Heylen","Janssens","Hardin","Luna","Holding","Barrera","Shea"};
            if ( first_names.length == last_names.length) {
                for (int i = 0; i < 10; i++) {
                    User user = new User();
                    user.setFirstname(first_names[i]);
                    user.setLastname(last_names[i]);
                    user.setUsername(first_names[i] + "." + last_names[i] + "@gmail.com");
                    user.setPassword("$2a$10$k/1hEuJ2WWz9JSU9cuMP8uMMdaRkfPE/MGDH5/Cn8I/GNDxxt1aP2"); //password: test123
                    userRepository.save(user);
                }
            }
        }
        if (reservationRepository.count() == 0) {
            for (int i = 1; i < 100 ; i++) {
                Reservation reservation = new Reservation();
                reservation.setDate(LocalDate.of(2021, Month.FEBRUARY, new Random().nextInt(25)  + 1 ));
                reservation.setUser(userRepository.findUserById(Long.valueOf(new Random().nextInt(10)  + 1 )));
                reservation.setAmountPersons(5);
                reservation.setStartHour(LocalTime.of(8, 10));
                reservation.setEndHour(LocalTime.of(19, 00));
                reservation.setConfirmed(false);
                reservation.setDescription("Resevatie");
                List<Place> places = new ArrayList<>();
                places.add(placeRepository.findById(1));
                places.add(placeRepository.findById(2));
                reservation.setPlaces(places);
                reservationRepository.save(reservation);
            }
        }
        if (roleRepository.count() == 0) {
            roleRepository.save(new Role(ERole.Employee));
            roleRepository.save(new Role(ERole.OfficeManager));
            roleRepository.save(new Role(ERole.Admin));
        }

        if (iotRepository.count()==0)
        {
            IOT iot = new IOT();
            iot.setTotalInside(30);
            iot.setTimeStamp( LocalDateTime.of(2014, Month.JANUARY, 1, 10, 10, 30));
            iotRepository.save(iot);
        }
    }
}
