package com.example.f1codingbackend.controller;

import com.example.f1codingbackend.model.Place;
import com.example.f1codingbackend.model.Reservation;
import com.example.f1codingbackend.repository.PlaceRepository;
import com.example.f1codingbackend.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;

@RestController
public class PlaceController {

    @Autowired
    PlaceRepository placeRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping("/places")
    public List<Place> getPlaces() {
        return placeRepository.findAll();
    }

    @GetMapping("/places/{appId}")
    public Place getPlaceByAppId(@PathVariable Integer appId){
        return placeRepository.findById(appId);
    }

    @PostMapping("/places")
    public Place addTable(@RequestBody Place place) {
        placeRepository.save(place);
        return place;
    }
    @PutMapping("/places")
    public Place updateTable(@RequestBody Place updatedPlace) {
        Place retrievedPlace = placeRepository.findById(updatedPlace.getId());

        retrievedPlace.setTableLocation(updatedPlace.getTableLocation());
        retrievedPlace.setReservations(updatedPlace.getReservations());

        placeRepository.save(retrievedPlace);
        return retrievedPlace;
    }

    @DeleteMapping("/places/{appId}")
    public ResponseEntity deleteplace(@PathVariable Integer appId){
        Place place = placeRepository.findById(appId);
        if (place!=null){
            List<Reservation> reservations = place.getReservations();
            for (Reservation reservation: reservations) {
                reservationRepository.delete(reservation);
            }
            placeRepository.delete(place);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
