package com.example.f1codingbackend.controller;

import com.example.f1codingbackend.repository.LocationRepository;
import com.example.f1codingbackend.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.f1codingbackend.model.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;


@RestController
public class TableController {

    @Autowired
    private TableRepository tableRepository;


    @GetMapping("/tables")
    public List<TableLocation> getTables() {
        return tableRepository.findAll();
    }

    @GetMapping("/tables/{appId}")
    public TableLocation getTableByAppId(@PathVariable Integer appId){
        return tableRepository.findById(appId);
    }

    @PostMapping("/tables")
    public TableLocation addTable(@RequestBody TableLocation tableLocation) {
        tableRepository.save(tableLocation);
        return tableLocation;
    }

}


