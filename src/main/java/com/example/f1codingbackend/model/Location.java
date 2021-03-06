package com.example.f1codingbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String description;

    @OneToMany(mappedBy="location")
    @JsonIgnore
    private List<TableLocation> tableLocations = new ArrayList<>();

    public Location() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TableLocation> getTableLocations() {
        return tableLocations;
    }

    public void setTableLocations(List<TableLocation> tableLocations) {
        this.tableLocations = tableLocations;
    }
}
