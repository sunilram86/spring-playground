package com.example.workflow;

import com.example.MovieConfig;
import com.example.model.MovieResponse;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.RequestMatcher;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;

import java.awt.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
public class MoviesServiceTest {

    private MoviesService service;
    private MockRestServiceServer mockRestServiceServer;

    @Before
    public void setupService()
    {
        MovieConfig movieConfig = mock(MovieConfig.class);
        when(movieConfig.getUrl()).thenReturn("http://www.TEST.com/");

        this.service=new MoviesService(movieConfig);
        this.mockRestServiceServer=MockRestServiceServer.createServer(service.getRestTemplate());
    }

    @Test
    public void testgetMovies() throws Exception
    {
//        mockRestServiceServer
//                .expect(requestTo("http://test.host/users"))
//                .andExpect(jsonPath("$.firstName", equalTo("Dwayne")))
//                .andRespond(withSuccess(getJSON("/users.json"), MediaType.APPLICATION_JSON));
//

        mockRestServiceServer.expect(MockRestRequestMatchers.requestTo("http://www.TEST.com/?s=Harry"))
                .andRespond(MockRestResponseCreators.withSuccess(getJSON("/movies.json"),
                        MediaType.APPLICATION_JSON));


        java.util.List<HashMap<String,Object>> response= service.getMovies("Harry");

        assertThat(response ,equalTo(""));

        mockRestServiceServer.verify();

    }

    private String getJSON(String path) throws Exception {
        URL url = this.getClass().getResource(path);
        return new String(Files.readAllBytes(Paths.get(url.getFile())));
    }

}