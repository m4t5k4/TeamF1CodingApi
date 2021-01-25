package com.example.f1codingbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class IOT {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private int totalInside;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalInside() {
        return totalInside;
    }

    public void setTotalInside(int totalInside) {
        this.totalInside = totalInside;
    }

    public IOT() {
    }
}
