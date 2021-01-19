package com.example.f1codingbackend.repository;

import com.example.f1codingbackend.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findAll();
    //Location findById();
    //Location findByName();
    //Location findByAddress();
}
