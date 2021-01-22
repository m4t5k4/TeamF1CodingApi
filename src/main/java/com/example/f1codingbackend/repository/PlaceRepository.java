package com.example.f1codingbackend.repository;

import com.example.f1codingbackend.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
    List<Place> findAll();
    Place findById(int id);
    //Place findByTableId();
}
