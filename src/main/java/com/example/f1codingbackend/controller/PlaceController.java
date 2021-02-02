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

    @GetMapping("/scenario-zwart")
    public List<Place>setPlacesZwart() {
        List <Place> places = placeRepository.findAll();
        for (Place place : places){
            place.setActive(false);
            placeRepository.save(place);
        }
        return placeRepository.findAllByActiveTrue();
    }

    @GetMapping("/scenario-geel")
    public List<Place>setPlacesGeel() {
        List <Place> places = placeRepository.findAll();
        for (Place place : places){
            if (place.getId() % 4 == 0 )
            {
             place.setActive(false);
            }
            else {
                place.setActive(true);
            }
            placeRepository.save(place);
        }
        return placeRepository.findAllByActiveTrue();
    }

    @GetMapping("/scenario-groen")
    public List<Place> setPlacesGroen() {
        List <Place> places = placeRepository.findAll();
        for (Place place : places){
            place.setActive(true);
            placeRepository.save(place);
        }
        return placeRepository.findAllByActiveTrue();
    }

    @GetMapping("/scenario-oranje")
    public List<Place> setPlacesOranje() {
        List <Place> places = placeRepository.findAll();
        for (Place place : places) {
            if (place.getId() % 2 == 0) {
                place.setActive(true);
            } else {
                place.setActive(false);
            }
            placeRepository.save(place);
        }
        return placeRepository.findAllByActiveTrue();
    }

    @GetMapping("/scenario-rood")
    public List<Place> setPlacesRood() {
        List <Place> places = placeRepository.findAll();
        for (Place place : places) {
            if (place.getId() % 4 == 0) {
                place.setActive(true);
            } else {
                place.setActive(false);
            }
            placeRepository.save(place);
        }
        return placeRepository.findAllByActiveTrue();
    }

    @GetMapping("/places/{id}")
    public Place one(@PathVariable Integer id){
        return placeRepository.findById(id);
    }

    @PostMapping("/places")
    public Place add(@RequestBody Place place) {
        placeRepository.save(place);
        return place;
    }
    @PutMapping("/places")
    public Place replacePlace(@RequestBody Place updatedPlace) {
        Place retrievedPlace = placeRepository.findById(updatedPlace.getId());
        retrievedPlace.setName(updatedPlace.getName());
        retrievedPlace.setTableLocation(updatedPlace.getTableLocation());
        retrievedPlace.setReservations(updatedPlace.getReservations());

        placeRepository.save(retrievedPlace);
        return retrievedPlace;
    }

    @DeleteMapping("/places/{id}")
    public ResponseEntity deleteplace(@PathVariable Integer id){
        Place place = placeRepository.findById(id);
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
