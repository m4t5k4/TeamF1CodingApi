package com.example.f1codingbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Place {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String name;
    private Boolean active;

    @ManyToOne
    private TableLocation tableLocation;

    @ManyToMany(mappedBy = "places")
    @JsonIgnore
    private List<Reservation> reservations = new ArrayList<>();

    public Place() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TableLocation getTableLocation() {
        return tableLocation;
    }

    public void setTableLocation(TableLocation tableLocation) {
        this.tableLocation = tableLocation;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
