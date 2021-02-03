package com.example.f1codingbackend.controller;

import com.example.f1codingbackend.model.*;
import com.example.f1codingbackend.repository.PlaceRepository;
import com.example.f1codingbackend.repository.ScenarioRepository;
import com.example.f1codingbackend.repository.TableRepository;
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

    @Autowired
    PlaceRepository placeRepository;

    @Autowired
    TableRepository tableRepository;

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

    @GetMapping("/scenario-zwart")
    public List<Place>setPlacesZwart() {
        List <Place> places = placeRepository.findAll();
        for (Place place : places){
            place.setActive(false);
            placeRepository.save(place);
        }
        return placeRepository.findAllByActiveTrue();
    }

    @GetMapping("/scenario-geel")
    public List<Place>setPlacesGeel() {
        List <TableLocation> tables = tableRepository.findAll();
        for (TableLocation table : tables){
            List <Place> places = table.getPlaces();
            if (places.size() != 1)
            {
                for (int teller = 0 ; teller < places.size() ; teller += 1 ){
                    Place place =  places.get(teller);
                    if (teller % 4 == 0 )
                    {
                        place.setActive(false);
                    }
                    else {
                        place.setActive(true);
                    }
                    placeRepository.save(place);
                }
            }
            else
            {
                Place place = places.get(0);
                place.setActive(true);
                placeRepository.save(place);
            }
        }
        return placeRepository.findAllByActiveTrue();
    }

    @GetMapping("/scenario-groen")
    public List<Place> setPlacesGroen() {
        List <Place> places = placeRepository.findAll();
        for (Place place : places){
            place.setActive(true);
            placeRepository.save(place);
        }
        return placeRepository.findAllByActiveTrue();
    }

    @GetMapping("/scenario-oranje")
    public List<Place> setPlacesOranje() {
        List <TableLocation> tables = tableRepository.findAll();
        for (TableLocation table : tables){
            List <Place> places = table.getPlaces();
            if (places.size() != 1)
            {
                for (int teller = 0 ; teller < places.size() ; teller += 1 ){
                    Place place =  places.get(teller);
                    if (teller % 2 == 0 )
                    {
                        place.setActive(false);
                    }
                    else {
                        place.setActive(true);
                    }
                    placeRepository.save(place);
                }
            }
            else
            {
                Place place = places.get(0);
                place.setActive(true);
                placeRepository.save(place);
            }
        }
        return placeRepository.findAllByActiveTrue();
    }

    @GetMapping("/scenario-rood")
    public List<Place> setPlacesRood() {
        List <TableLocation> tables = tableRepository.findAll();
        for (TableLocation table : tables){
            List <Place> places = table.getPlaces();
            if (places.size() != 1)
            {
                for (int teller = 0 ; teller < places.size() ; teller += 1 ){
                    Place place =  places.get(teller);
                    if (teller % 4 == 0 )
                    {
                        place.setActive(true);
                    }
                    else {
                        place.setActive(false);
                    }
                    placeRepository.save(place);
                }
            }
            else
            {
                Place place = places.get(0);
                place.setActive(true);
                placeRepository.save(place);
            }
        }
        return placeRepository.findAllByActiveTrue();
    }

}
