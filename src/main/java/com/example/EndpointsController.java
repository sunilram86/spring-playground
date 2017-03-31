package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EndpointsController {
    @GetMapping("/index")
    public String getIndex() {
        return "GET to index route";
    }

    @GetMapping("/tasks")
    public String getTasks() {
        return "These are tasks";
    }

    @PostMapping("/tasks")
    public String createTask() {
        return "You just POSTed to /tasks";
    }

    @GetMapping("/math/pi")
    public String getPiValue() {
        return "3.141592653589793";
    }

}
