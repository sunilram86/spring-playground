package com.example.workflow;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FlightSample {
    private int id;
    private String destination;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date departsOn;

    private List<People> people;
    private People pilot;

    public FlightSample() {
    }

    public FlightSample(int id, String destination, Date departsOn, List<People> people, People pilot) {
        this.id = id;
        this.destination = destination;
        this.departsOn = departsOn;
        this.people = people;
        this.pilot = pilot;
    }

    public int getId() {
        return id;
    }

    public String getDestination() {
        return destination;
    }

    public Date getDepartsOn() {
        return departsOn;
    }

    public List<People> getPeople() {
        return people;
    }

    public People getPilot() {
        return pilot;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDepartsOn(Date departsOn) {
        this.departsOn = departsOn;
    }

    public void setPeople(List<People> people) {
        this.people = people;
    }

    public void setPilot(People pilot) {
        this.pilot = pilot;
    }

    public static class People {
        private String name;

        public String getName() { return name; }

        public void setName(String name) { this.name = name; }
    }
}
