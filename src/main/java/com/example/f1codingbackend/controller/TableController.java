package com.example.f1codingbackend.controller;

import com.example.f1codingbackend.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.f1codingbackend.model.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.PostConstruct;
import java.util.List;


@RestController
public class TableController {

    @Autowired
    private TableRepository tableRepository;

    @PostConstruct
    public void fillDB(){
        if (tableRepository.count()==0){
            TableLocation newTable1 = new TableLocation();
            newTable1.setName("Table 1");
            TableLocation newTable2 = new TableLocation();
            newTable2.setName("Table 2");
            TableLocation newTable3 = new TableLocation();
            newTable3.setName("Table 3");
            TableLocation newTable4 = new TableLocation();
            newTable4.setName("Table 4");
            tableRepository.save(newTable1);
            tableRepository.save(newTable2);
            tableRepository.save(newTable3);
            tableRepository.save(newTable4);
        }
    }

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


