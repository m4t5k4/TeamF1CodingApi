package com.example.f1codingbackend.controller;

import com.example.f1codingbackend.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.f1codingbackend.model.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;


@RestController
public class ReservationController {
    @Autowired
    private ReservationRepository reservationRepository;


    @GetMapping("/reservations")
    public List<Reservation> all() {
        return reservationRepository.findAll();
    }

    @GetMapping("/reservations/{id}")
    public Reservation one(@PathVariable Integer id){ return reservationRepository.findById(id); }

    @GetMapping("/reservations/user/{id}")
    public List<Reservation> allByUser(@PathVariable Long id) {
        List<Reservation> r = reservationRepository.findByUser_Id(id);
        return r;
    }

    @GetMapping("/reservations/date/{date}")
    public List<Reservation> findByDate(@PathVariable("date") String date) {
        List<Reservation> r = reservationRepository.findByDate(LocalDate.parse(date));
        return r;
    }

    @PostMapping("/reservations")
    public Reservation add(@RequestBody Reservation reservation) {
        reservationRepository.save(reservation);
        return reservation;
    }
    @PutMapping("/reservations")
    public Reservation replaceReservation(@RequestBody Reservation updatedReservation) {
        Reservation retrievedReservation = reservationRepository.findById(updatedReservation.getId());

        retrievedReservation.setUser(updatedReservation.getUser());
        retrievedReservation.setAmountPersons(updatedReservation.getAmountPersons());
        retrievedReservation.setDate(updatedReservation.getDate());
        retrievedReservation.setDescription(updatedReservation.getDescription());
        retrievedReservation.setEndHour(updatedReservation.getEndHour());
        retrievedReservation.setStartHour(updatedReservation.getStartHour());
        retrievedReservation.setPlaces(updatedReservation.getPlaces());

        reservationRepository.save(retrievedReservation);
        return retrievedReservation;
    }

    @DeleteMapping("/reservations/{id}")
    public ResponseEntity deleteReservation(@PathVariable Integer id){
        Reservation reservation = reservationRepository.findById(id);
        if (reservation!=null){
            reservationRepository.delete(reservation);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}


