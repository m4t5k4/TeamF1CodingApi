package com.example.f1codingbackend.repository;

import com.example.f1codingbackend.model.TableLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TableRepository extends JpaRepository<TableLocation, Long> {
    List<TableLocation> findAll();
    TableLocation findById(int id);
    TableLocation findByLocationId(int id);
    TableLocation findByName(String Name);
}
