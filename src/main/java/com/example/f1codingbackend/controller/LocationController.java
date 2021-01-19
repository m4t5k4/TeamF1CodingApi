package com.example.f1codingbackend.controller;

import com.example.f1codingbackend.model.Location;
import com.example.f1codingbackend.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

@Controller
public class LocationController {
    @Autowired
    LocationRepository locationRepository;
    @PostConstruct
    public void generate()
    {
        String[] address_list = {"2627  Hall Valley Drive","2791  Buffalo Creek Road","4976  Hayhurst Lane"};
        String[] name_list = {"Office 1","Office 2","Office 3"};
        for (int i = 0; i < address_list.length; i++)
        {
            Location location = new Location();
            location.setAddress(address_list[i]);
            location.setDescription("....");
            location.setName(name_list[i]);
            locationRepository.save(location);
        }
}
}
