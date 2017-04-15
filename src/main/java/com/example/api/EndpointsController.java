package com.example.api;

import com.example.workflow.MathService;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
        return String.format("The volume of a %dx%dx%d rectangle is " + (length * width * height), length, width, height);
    }

    @PostMapping(value = "/math/area", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String calculateArea(@RequestParam Map<String, String> formData) {

        String type = formData.get("type");

        if (type.equalsIgnoreCase("circle")) {
            if (formData.containsKey("radius") && !formData.containsKey("height")) {
                int radius = Integer.parseInt(formData.get("radius"));
                Double piValue = Double.parseDouble(getPiValue());
                String circleArea = String.valueOf((piValue * radius * radius));
                return String.format("Area of a circle with a radius of " + radius + " is " + circleArea);
            } else
                return "Invalid";

        }

        if (type.equalsIgnoreCase("rectangle")) {
            if (formData.containsKey("width") && formData.containsKey("height") && !formData.containsKey("radius")) {
                int width = Integer.parseInt(formData.get("width"));
                int height = Integer.parseInt(formData.get("height"));
                String rectangleArea = String.valueOf((width * height));
                return String.format("Area of a " + width + "x" + height + " rectangle is " + rectangleArea);
            } else
                return "Invalid";

        }
        return null;
    }



}
