package com.example.workflow;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class AirPlane {

    @JsonProperty("tickets")
    private List<Tickets> tickets = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public AirPlane() {
    }

    /**
     *
     * @param tickets
     */
    public AirPlane(List<Tickets> tickets) {
        super();
        this.tickets = tickets;
    }

    @JsonProperty("tickets")
    public List<Tickets> getTickets() {
        return tickets;
    }

    @JsonProperty("tickets")
    public void setTickets(List<Tickets> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "AirPlane{" +
                "tickets=" + tickets +
                '}';
    }
}
