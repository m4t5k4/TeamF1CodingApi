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

    @Autowired
    private ReservationRepository reservationRepository;



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
    @PutMapping("/tables")
    public TableLocation updateTable(@RequestBody TableLocation updatedTable) {
        TableLocation retrievedTable = tableRepository.findById(updatedTable.getId());

        retrievedTable.setLocation(updatedTable.getLocation());
        retrievedTable.setName(updatedTable.getName());
        retrievedTable.setPlaces(updatedTable.getPlaces());
        retrievedTable.setReservations(updatedTable.getReservations());

        tableRepository.save(retrievedTable);
        return retrievedTable;
    }

    @DeleteMapping("/tables/{appId}")
    public ResponseEntity deleteTable(@PathVariable Integer appId){
        TableLocation table = tableRepository.findById(appId);
        if (table!=null){

            List<Place> tablePlaces = table.getPlaces();
            for (Place tablePlace: tablePlaces) {
                placeRepository.delete(tablePlace);
            }

            List<Reservation> reservations = table.getReservations();
            for (Reservation reservation: reservations) {
                reservationRepository.delete(reservation);
            }

            tableRepository.delete(table);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}


