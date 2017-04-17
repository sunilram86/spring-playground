package com.example.api;

import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class FormDataController {

    @PostMapping(value = "/comments", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createComment(@RequestParam Map<String, String> formData) {
        return formData.toString();

    }

    @PostMapping("/string-example")
    public String getRawString(@RequestBody String rawBody) {
        return rawBody;
    }

}
