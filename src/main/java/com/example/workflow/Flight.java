package com.example.workflow;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Flight {
    public Flight() {
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:MM")
    @JsonProperty("Departs")
    private Date departs;
    @JsonProperty("Tickets")
    private List<Ticket> tickets=null;

    public Flight(Date departs, List<Ticket> tickets) {
        this.departs = departs;
        this.tickets = tickets;
    }

    public Date getDeparts() {
        return departs;
    }

    public void setDeparts(Date departs) {
        this.departs = departs;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "departs=" + departs +
                ", tickets=" + tickets +
                '}';
    }
}
