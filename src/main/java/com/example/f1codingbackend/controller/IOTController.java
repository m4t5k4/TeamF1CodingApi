package com.example.f1codingbackend.controller;

import com.example.f1codingbackend.model.IOT;
import com.example.f1codingbackend.model.Location;
import com.example.f1codingbackend.repository.IOTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IOTController {
    @Autowired
    IOTRepository iotRepository;

    @GetMapping("/iot")
    public List<IOT> iots()
    {
        List<IOT> iotList = iotRepository.findAll();
        return  iotList;
    }
}
