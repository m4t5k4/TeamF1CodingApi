package com.example.f1codingbackend.repository;

import com.example.f1codingbackend.model.Employee;
import com.example.f1codingbackend.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAll();
    //Reservation findById();
    //Reservation findByPersoonId();
}
