package com.example.workflow;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ticket {
    @JsonProperty("Passenger")

    private Passenger passenger;
    @JsonProperty("Price")
    private Integer price;

    public Ticket() {
    }

    public Ticket(Integer price, Passenger passenger) {
        this.price = price;
        this.passenger = passenger;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }


}
