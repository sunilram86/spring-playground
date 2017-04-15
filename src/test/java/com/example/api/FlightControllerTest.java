package com.example.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(FlightController.class)
public class FlightControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testGetFlightDetails() throws Exception {
        this.mvc.perform(
                get("/flights/flight")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departs", is("2017-07-21 20:07")))
                .andExpect(jsonPath("$.tickets[0].price", is(200)))
                .andExpect(jsonPath("$.tickets[0].passenger.firstName", is("sunil")));


    }

    @Test
    public void testGetAllFlightDetails() throws Exception {
        this.mvc.perform(
                get("/flights")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].Departs", is("2017-07-21 20:07")))
                .andExpect(jsonPath("$[1].Departs", is("2017-06-21 20:06")))

                .andExpect(jsonPath("$[0].Tickets[0].Price", is(200)))
                .andExpect(jsonPath("$[0].Tickets[0].Passenger.FirstName", is("sunil")))
                .andExpect(jsonPath("$[1].Tickets[0].Passenger.FirstName", is("mike")));


    }

}