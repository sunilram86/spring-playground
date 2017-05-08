package com.example.api;

import com.example.workflow.AirPlane;
import com.example.workflow.Passenger;
import com.example.workflow.Passengers;
import com.example.workflow.Tickets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.util.Arrays.asList;
import static javafx.scene.input.KeyCode.T;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(FlightController.class)
@AutoConfigureMockMvc(secure=false)

public class FlightControllerTest {
    @Autowired
    private MockMvc mvc;
    private Gson gson = new GsonBuilder().create();


    @Test
    public void testGetFlightDetails() throws Exception {
        this.mvc.perform(
                get("/flights/flight")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Departs", is("2017-07-21 20:07")))
                .andExpect(jsonPath("$.Tickets[0].Price", is(200)))
                .andExpect(jsonPath("$.Tickets[0].Passenger.FirstName", is("sunil")));


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

    @Test
    public void testCalculateTicketPrice_via_StringLiteral() throws Exception {

        MockHttpServletRequestBuilder request = post("/flights/tickets/total")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("  {\n    \"tickets\": [\n      {\n        \"passenger\": {\n          \"firstName\": \"Some name\",\n          \"lastName\": \"Some other name\"\n        },\n        \"price\": 200\n      },\n      {\n        \"passenger\": {\n          \"firstName\": \"Name B\",\n          \"lastName\": \"Name C\"\n        },\n        \"price\": 150\n      }\n    ]\n  }");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\n  \"result\": 350\n}"));
    }

    @Test
    public void testCalculateTicketPrice_via_fileRead() throws Exception {

        String json = getJSON("/tickets.json");


        MockHttpServletRequestBuilder request = post("/flights/tickets/total")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(json);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\n  \"result\": 350\n}"));
    }


    @Test
    public void testCalculateTicketPrice_via_gson() throws Exception {

        AirPlane airPlane = new AirPlane();
        Tickets tickets = new Tickets();
        Passengers passenger = new Passengers();
        passenger.setFirstName("sunil");
        passenger.setLastName("anil");
        tickets.setPassenger(passenger);
        tickets.setPrice(10);

        Tickets tickets2 = new Tickets();

        Passengers passenger2 = new Passengers();
        passenger2.setFirstName("rop");
        passenger2.setLastName("swa");
        tickets2.setPassenger(passenger);
        tickets2.setPrice(60);

        airPlane.setTickets(asList(tickets,tickets2));

        MockHttpServletRequestBuilder request = post("/flights/tickets/total")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(gson.toJson(airPlane));

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\n  \"result\": 70\n}"));
    }
    private String getJSON(String path) throws Exception {
        URL url = this.getClass().getResource(path);
        return new String(Files.readAllBytes(Paths.get(url.getFile())));
    }


}