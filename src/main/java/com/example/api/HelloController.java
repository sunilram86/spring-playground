package com.example.api;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String helloWorld() {
        return "Hello from Spring during the Spring season!";
    }

    @GetMapping("/cookie")
    public String getCookie(@CookieValue(name = "foo") String cookie) {
        return cookie;
    }

    @GetMapping("/header")
    public String getHeader(@RequestHeader String host) {
        return host;
    }
}