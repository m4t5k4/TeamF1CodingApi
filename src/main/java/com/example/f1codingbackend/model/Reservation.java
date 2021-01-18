package com.example.f1codingbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalTime;
import java.util.Date;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private int persoonId;
    private Date datum;
    private LocalTime startHour;
    private LocalTime endHour;
    private int amountPersons;
    private String description;

    public Reservation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersoonId() {
        return persoonId;
    }

    public void setPersoonId(int persoonId) {
        this.persoonId = persoonId;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
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
}
