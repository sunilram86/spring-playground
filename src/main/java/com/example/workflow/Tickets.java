package com.example.workflow;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tickets {

    @JsonProperty("passenger")
    private Passengers passenger;
    @JsonProperty("price")
    private Integer price;

    /**
     * No args constructor for use in serialization
     *
     */
    public Tickets() {
    }

    /**
     *
     * @param passenger
     * @param price
     */
    public Tickets(Passengers passenger, Integer price) {
        super();
        this.passenger = passenger;
        this.price = price;
    }

    @JsonProperty("passenger")
    public Passengers getPassenger() {
        return passenger;
    }

    @JsonProperty("passenger")
    public void setPassenger(Passengers passenger) {
        this.passenger = passenger;
    }

    @JsonProperty("price")
    public Integer getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Integer price) {
        this.price = price;
    }

}