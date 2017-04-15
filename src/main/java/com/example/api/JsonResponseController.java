package com.example.api;


import com.example.workflow.FlightSample;
import org.springframework.web.bind.annotation.GetMapping;
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


}
