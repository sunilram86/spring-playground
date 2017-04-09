package com.example.api;

import com.example.workflow.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.lang.String.valueOf;

@RestController
public class EndpointsController {

    MathService mathService = new MathService();

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

    @GetMapping("/math/calculate")
    public String calculate(@RequestParam(required = false) String operation,
                            @RequestParam(value = "x") int x, @RequestParam(value = "y") int y) {
        return (mathService.calculate(operation, x, y));

    }

    @PostMapping("/math/sum")
    public String calculateSum(@RequestParam MultiValueMap<String, String> querystring) {
        return (mathService.calculateSum(querystring));

    }
}
