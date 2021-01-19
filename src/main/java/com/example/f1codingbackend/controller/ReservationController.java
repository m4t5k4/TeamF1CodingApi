package com.example.f1codingbackend.controller;

import com.example.f1codingbackend.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostConstruct
    public void fillDB(){
        if (reservationRepository.count()==0){
            Reservation newRes1 = new Reservation();
            newRes1.setDate(new java.util.Date());
            newRes1.setAmountPersons(5);

            Reservation newRes2 = new Reservation();
            newRes2.setDate(new java.util.Date());
            newRes2.setAmountPersons(5);

            Reservation newRes3 = new Reservation();
            newRes3.setDate(new java.util.Date());
            newRes3.setAmountPersons(5);

            Reservation newRes4 = new Reservation();
            newRes4.setDate(new java.util.Date());
            newRes4.setAmountPersons(5);

            reservationRepository.save(newRes1);
            reservationRepository.save(newRes2);
            reservationRepository.save(newRes3);
            reservationRepository.save(newRes4);
        }
    }

    @GetMapping("/reservations")
    public List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }

}


