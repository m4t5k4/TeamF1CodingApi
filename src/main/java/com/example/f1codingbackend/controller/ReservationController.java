package com.example.f1codingbackend.controller;

import com.example.f1codingbackend.repository.EmployeeRepository;
import com.example.f1codingbackend.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.f1codingbackend.model.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.PostConstruct;
import java.util.List;


@RestController
public class ReservationController {
    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping("/reservations")
    public List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }

    @GetMapping("/reservations/{appId}")
    public Reservation getReservationByAppId(@PathVariable Integer appId){
        return reservationRepository.findById(appId);
    }

    @PostMapping("/reservations")
    public Reservation addTable(@RequestBody Reservation reservation) {
        reservationRepository.save(reservation);
        return reservation;
    }
    @PutMapping("/reservations")
    public Reservation updateTable(@RequestBody Reservation updatedReservation) {
        Reservation retrievedReservation = reservationRepository.findById(updatedReservation.getId());

        retrievedReservation.setEmployee(updatedReservation.getEmployee());
        retrievedReservation.setAmountPersons(updatedReservation.getAmountPersons());
        retrievedReservation.setDate(updatedReservation.getDate());
        retrievedReservation.setDescription(updatedReservation.getDescription());
        retrievedReservation.setEndHour(updatedReservation.getEndHour());
        retrievedReservation.setStartHour(updatedReservation.getStartHour());
        retrievedReservation.setPlaces(updatedReservation.getPlaces());

        reservationRepository.save(retrievedReservation);
        return retrievedReservation;
    }

    @DeleteMapping("/reservations/{appId}")
    public ResponseEntity deleteReservation(@PathVariable Integer appId){
        Reservation reservation = reservationRepository.findById(appId);
        if (reservation!=null){
            reservationRepository.delete(reservation);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}


