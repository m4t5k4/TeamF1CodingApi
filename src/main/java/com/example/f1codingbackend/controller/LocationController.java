package com.example.f1codingbackend.controller;
import com.example.f1codingbackend.model.*;
import com.example.f1codingbackend.repository.LocationRepository;
import com.example.f1codingbackend.repository.PlaceRepository;
import com.example.f1codingbackend.repository.ReservationRepository;
import com.example.f1codingbackend.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocationController {
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    TableRepository tableRepository;
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    PlaceRepository placeRepository;

    @GetMapping("/locations")
    public List<Location> locations()
    {
        List<Location> locationList = locationRepository.findAll();
        return  locationList;
    }

    @GetMapping("/locations/{position}")
    public Location one(@PathVariable int position)
    {
        return locationRepository.findById(position);
    }

    @PostMapping("/locations")
    Location add(@RequestBody Location location)
    {
        locationRepository.save(location);
        return location;
    }

    @PutMapping("/locations/{position}")
    public Location replaceLocation(@RequestBody Location location,@PathVariable int position)
    {
       Location currentLocation = locationRepository.findById(position);
       currentLocation.setName(location.getName());
       currentLocation.setDescription(location.getDescription());
       currentLocation.setAddress(location.getAddress());
       locationRepository.save(currentLocation);
       return currentLocation;
    }

    @DeleteMapping("/locations/{position}")
    public void deleteLocation(@PathVariable int position)
    {
        Location location = locationRepository.findById(position);
        List <TableLocation> table_locations = location.getTableLocations();
        for (TableLocation table_location : table_locations)
        {
            List <Reservation> reservations = table_location.getReservations();
            List <Place> places = table_location.getPlaces();
            for (Reservation reservation : reservations){
                reservationRepository.delete(reservation);
            }
            for (Place place : places){
                placeRepository.delete(place);
            }
            tableRepository.delete(table_location);
        }
        locationRepository.delete(location);
    }
}
