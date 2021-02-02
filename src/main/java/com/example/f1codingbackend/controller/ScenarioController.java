package com.example.f1codingbackend.controller;

import com.example.f1codingbackend.model.Location;
import com.example.f1codingbackend.model.Reservation;
import com.example.f1codingbackend.model.Scenario;
import com.example.f1codingbackend.repository.ScenarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScenarioController {
    @Autowired
    ScenarioRepository scenarioRepository;

    @GetMapping("/scenarios")
    public List <Scenario> all() {
        return scenarioRepository.findAll();
    }

    @PutMapping("/scenarios")
    public Scenario replaceScenario(@RequestBody Scenario scenario)
    {
        Scenario currentScenario = scenarioRepository.findById(scenario.getId());
        currentScenario.setScenario(scenario.getScenario());
        scenarioRepository.save(currentScenario);
        return currentScenario;
    }
}
