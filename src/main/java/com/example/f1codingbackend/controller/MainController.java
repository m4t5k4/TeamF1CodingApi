package com.example.f1codingbackend.controller;

import com.example.f1codingbackend.repository.LocationRepository;
import com.example.f1codingbackend.repository.PlaceRepository;
import com.example.f1codingbackend.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.f1codingbackend.model.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
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

    @GetMapping("/start")
    public String test() {
        return "test";
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
    }
}
