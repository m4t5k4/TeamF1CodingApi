package com.example.f1codingbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;

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
    @JsonIgnore
    private Employee employee;

    @ManyToOne
    private TableLocation tableLocation;

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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public TableLocation getTableLocation() {
        return tableLocation;
    }

    public void setTableLocation(TableLocation tableLocation) {
        this.tableLocation = tableLocation;
    }
}
