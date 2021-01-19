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

    @ManyToOne
    @JsonIgnore
    private TableLocation tableLocation;

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
}
