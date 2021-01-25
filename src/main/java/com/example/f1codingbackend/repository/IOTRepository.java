package com.example.f1codingbackend.repository;

import com.example.f1codingbackend.model.IOT;
import com.example.f1codingbackend.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOTRepository extends JpaRepository<IOT, Long> {
    List<IOT> findAll();
}
