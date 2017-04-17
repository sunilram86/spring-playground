package com.example.api;


import com.example.workflow.Blog;
import com.example.workflow.Example;
import com.example.workflow.FlightSample;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

import static java.util.Arrays.asList;

@RestController
public class JsonResponseController {

    @GetMapping("/json/simple-object")
    public Person getJsonBody() {
        Person person = new Person();
        person.firstName = "Dwayne";
        person.lastName = "Johnson";
        return person;
    }


    @GetMapping("/json/array")
    public List<Person> getArrayJsonBody() {
        Person person = new Person();
        person.firstName = "Dwayne";
        person.lastName = "Johnson";

        Person person2 = new Person();
        person2.firstName = "Ram";
        person2.lastName = "Johnson";


        return asList(person, person2);
    }

    public static class Person {
        private String firstName;
        private String lastName;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }


    @GetMapping("/getFlights")
    public List<FlightSample> getFlights() {
        FlightSample flightSample1 = new FlightSample();
        FlightSample.People p = new FlightSample.People();
        p.setName("rama");
        FlightSample.People p2 = new FlightSample.People();
        p2.setName("rama");
        FlightSample.People pilot = new FlightSample.People();
        pilot.setName("chandroa");
        flightSample1.setPilot(pilot);
        flightSample1.setDestination("Mumbai");
        flightSample1.setId(200);
        flightSample1.setDepartsOn(new Date(2020, 3, 2));
        flightSample1.setPeople(asList(p, p2));

        FlightSample flightSample2 = new FlightSample();
        flightSample2.setDestination("blore");
        flightSample2.setId(420);
        flightSample2.setDepartsOn(null);


        return asList(flightSample1, flightSample2);
    }

    @PostMapping("/receiveJson")
    public String postJson(@RequestBody Example
                                   example) {
        String q = example.getQ();
        String from = example.getFrom();

        return "Search: q=" + q + " from=" + from;
    }

    @PostMapping("/nested-example")
        public Blog getNested(@RequestBody Blog blog) {
           return blog;
    }

}
