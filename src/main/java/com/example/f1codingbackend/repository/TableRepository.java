package com.example.f1codingbackend.repository;

import com.example.f1codingbackend.model.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TableRepository extends JpaRepository<Table, Integer> {

    List<Table> findAll();
    Table findById();
    Table findByLocationId();
    Table findByName();
}
