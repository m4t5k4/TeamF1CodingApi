package com.example.f1codingbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Table {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private int Name;
    private int locationId;

    public int getId() {
        return id;
    }

    public Table() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return Name;
    }

    public void setName(int name) {
        Name = name;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }
}
