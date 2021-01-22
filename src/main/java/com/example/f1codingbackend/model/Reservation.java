package com.example.f1codingbackend.model;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private Date date;
    private LocalTime startHour;
    private LocalTime endHour;
    private int amountPersons;
    private String description;

    public Reservation() {
    }

    @ManyToOne
    private User user;

    @ManyToMany
    @JoinTable
    private List<Place> places = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LocalTime getStartHour() {
        return startHour;
    }

    public void setStartHour(LocalTime startHour) {
        this.startHour = startHour;
    }

    public LocalTime getEndHour() {
        return endHour;
    }

    public void setEndHour(LocalTime endHour) {
        this.endHour = endHour;
    }

    public int getAmountPersons() {
        return amountPersons;
    }

    public void setAmountPersons(int amountPersons) {
        this.amountPersons = amountPersons;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Place> getPlaces() { return places; }

    public void setPlaces(List<Place> places) { this.places = places; }
}
