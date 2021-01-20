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
}
