package com.example.api;

import com.example.model.FinalMoviesResponse;
import com.example.model.MovieResponse;
import com.example.workflow.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MoviesController {

    @Autowired
    MoviesService moviesService;

    @GetMapping("/movies")
    public List<HashMap<String,Object>> getMovies(@RequestParam(value="q") String name)
    {
             return moviesService.getMovies(name);
    }

}
