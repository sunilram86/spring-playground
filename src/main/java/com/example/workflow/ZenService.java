package com.example.workflow;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.net.URI;

@Service
public class ZenService
{

    public final RestTemplate restTemplate = new RestTemplate();

    public String getMessage_simple_url(){

        return this.restTemplate.getForObject("https://api.github.com/zen",String.class);
    }

    public String getMessage_query_url(){

        return this.restTemplate.getForObject("https://api.example.com/drivers/{id}/trips", String.class, 42);
    }

    public String getMessage_path_url(){

        return this.restTemplate.getForObject("https://api.example.com/trips?driverId={id}", String.class, 42);
    }


}
