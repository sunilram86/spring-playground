package com.example.workflow;

import com.fasterxml.jackson.annotation.JsonView;

import java.util.List;

public class User1 {
    @JsonView(Views.ListView.class)
    private int id;

    @JsonView(Views.ListView.class)
    private String name;

    @JsonView(Views.DetailView.class)
    private String email;

    @JsonView(Views.DetailView.class)
    private List<Passenger> passenger;

    public User1() {
    }

    public User1(int id, String name, String email, List<Passenger> passenger) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passenger = passenger;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Passenger> getPassenger() {
        return passenger;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassenger(List<Passenger> passenger) {
        this.passenger = passenger;
    }
}

