package com.example.f1codingbackend.controller;

import com.example.f1codingbackend.model.Place;
import com.example.f1codingbackend.model.TableLocation;
import com.example.f1codingbackend.repository.PlaceRepository;
import com.example.f1codingbackend.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.Random;

@Controller
public class PlaceController {

    @Autowired
    PlaceRepository placeRepository;


}
