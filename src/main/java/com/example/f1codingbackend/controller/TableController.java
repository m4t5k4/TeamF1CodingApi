package com.example.f1codingbackend.controller;

import com.example.f1codingbackend.repository.LocationRepository;
import com.example.f1codingbackend.repository.PlaceRepository;
import com.example.f1codingbackend.repository.ReservationRepository;
import com.example.f1codingbackend.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    private PlaceRepository placeRepository;


    @GetMapping("/tables")
    public List<TableLocation> getTables() {
        return tableRepository.findAll();
    }

    @GetMapping("/tables/{id}")
    public TableLocation one(@PathVariable Integer id){
        return tableRepository.findById(id);
    }

    @PostMapping("/tables")
    public TableLocation add(@RequestBody TableLocation tableLocation) {
        tableRepository.save(tableLocation);
        return tableLocation;
    }
    @PutMapping("/tables")
    public TableLocation replaceTable(@RequestBody TableLocation updatedTable) {
        TableLocation retrievedTable = tableRepository.findById(updatedTable.getId());

        retrievedTable.setLocation(updatedTable.getLocation());
        retrievedTable.setName(updatedTable.getName());
        retrievedTable.setZone(updatedTable.getZone());
        retrievedTable.setPlaces(updatedTable.getPlaces());

        tableRepository.save(retrievedTable);
        return retrievedTable;
    }

    @DeleteMapping("/tables/{id}")
    public ResponseEntity deleteTable(@PathVariable Integer id){
        TableLocation table = tableRepository.findById(id);
        if (table!=null){

            List<Place> tablePlaces = table.getPlaces();
            for (Place tablePlace: tablePlaces) {
                placeRepository.delete(tablePlace);
            }

            tableRepository.delete(table);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}


