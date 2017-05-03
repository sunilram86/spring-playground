package com.example.workflow;

import com.example.model.FinalMoviesResponse;
import com.example.model.MovieResponse;

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

    private final RestTemplate restTemplate = new RestTemplate();

    public List<HashMap<String,Object>> getMovies(String q)
    {

        URI uri = UriComponentsBuilder
                .fromUriString("http://www.omdbapi.com/")
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
