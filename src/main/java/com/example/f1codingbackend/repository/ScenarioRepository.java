package com.example.f1codingbackend.repository;
import com.example.f1codingbackend.model.Role;
import com.example.f1codingbackend.model.Scenario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScenarioRepository extends JpaRepository<Scenario, Long> {
   List <Scenario> findAll();
   Scenario findById(int id);
}
