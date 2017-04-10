package com.example.api;

import com.example.workflow.MathService;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/tasks/{taskId}/comments/{commentId}")
    public String getCommentsForTask(@PathVariable int taskId, @PathVariable int commentId) {
        return String.format("taskId is %d; commentId is %d", taskId, commentId);
    }

    @RequestMapping("/math/volume/{length}/{width}/{height}")
    public String calculateRectangleVolume(@PathVariable int length, @PathVariable int width, @PathVariable int height) {
        return  String.format("The volume of a %dx%dx%d rectangle is "+(length*width*height), length,width,height);
    }

}
