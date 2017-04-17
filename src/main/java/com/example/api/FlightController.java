package com.example.api;

import com.example.workflow.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Arrays.parallelPrefix;

@RestController
public class FlightController {

    @GetMapping("/flights/flight")
    public Flight getFlightDetails() {
        Flight flight = new Flight();
        Ticket ticket = new Ticket();
        Passenger passenger = new Passenger();
        passenger.setFirstName("sunil");
        passenger.setLastName("ram");
        ticket.setPrice(200);
        ticket.setPassenger(passenger);
        flight.setDeparts(new Date(2017 - 1900, 06, 21, 14, 34));
        flight.setTickets(asList(ticket));
        return flight;
    }

    @GetMapping("/flights")
    public List<Flight> getAllFlightDetails() {
        Flight flight = new Flight();
        Ticket ticket = new Ticket();
        Passenger passenger = new Passenger();
        passenger.setFirstName("sunil");
        passenger.setLastName("ram");
        ticket.setPrice(200);
        ticket.setPassenger(passenger);
        flight.setDeparts(new Date(2017 - 1900, 06, 21, 14, 34));
        flight.setTickets(asList(ticket));

        Flight flight2 = new Flight();
        Ticket ticket2 = new Ticket();
        Passenger passenger2 = new Passenger();
        passenger2.setFirstName("mike");
        passenger2.setLastName("chris");
        ticket2.setPrice(400);
        ticket2.setPassenger(passenger2);
        flight2.setDeparts(new Date(2017 - 1900, 05, 21, 14, 34));
        flight2.setTickets(asList(ticket2));

        return asList(flight, flight2);
    }

    @PostMapping("/flights/tickets/total")
    public FlightTotal calculateFlightTotal(@RequestBody AirPlane airplane) {
        FlightTotal flightTotal = new FlightTotal();
        Integer total = airplane.getTickets().stream().
                mapToInt(a -> a.getPrice()).sum();

        flightTotal.setResult(total);

        return flightTotal;
    }
}
