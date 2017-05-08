package com.example.workflow;

import com.example.MovieConfig;
import com.example.model.FinalMoviesResponse;
import com.example.model.MovieResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.Character.toLowerCase;


@Service
public class MoviesService {


    private MovieConfig movieConfig;

    public MoviesService(MovieConfig movieConfig) {
        this.movieConfig = movieConfig;
    }

    private final RestTemplate restTemplate = new RestTemplate();

    public RestTemplate getRestTemplate()
    {
        return  this.restTemplate;
    }

    public List<HashMap<String,Object>> getMovies(String q)
    {

        URI uri = UriComponentsBuilder
                .fromUriString(movieConfig.getUrl())
                .queryParam("s",q)
                .build()
                .toUri();



        // Create the request

        RequestEntity<?> request = RequestEntity.get(uri)
                .build();

        // Execute the request
        ResponseEntity<MovieResponse> response = restTemplate.exchange(
              request, MovieResponse.class);


     return response.getBody().getSearch();



    }
}
