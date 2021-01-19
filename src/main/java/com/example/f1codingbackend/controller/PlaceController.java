package com.example.f1codingbackend.controller;

import com.example.f1codingbackend.model.Place;
import com.example.f1codingbackend.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

@Controller
public class PlaceController {
    @Autowired
    PlaceRepository placeRepository;

    @PostConstruct
    public void generate()
    {
        Place place = new Place();
    }
}
