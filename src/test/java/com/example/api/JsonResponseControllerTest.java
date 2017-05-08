package com.example.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(JsonResponseController.class)
@AutoConfigureMockMvc(secure=false)

public class JsonResponseControllerTest {
    @Autowired
    private MockMvc mvc;
    private Gson gson = new GsonBuilder().create();


    @Test
    public void testGetJsonBody() throws Exception {
        this.mvc.perform(
                get("/json/simple-object")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", is("Dwayne")))
                .andExpect(jsonPath("$.lastName", is("Johnson")));
    }

    @Test
    public void testArraygetJsonBody() throws Exception {
        this.mvc.perform(
                get("/json/array")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName", is("Dwayne")))
                .andExpect(jsonPath("$[0].lastName", is("Johnson")));
    }

    static class SearchRequestParams {
        final String q;
        final String from;
        SearchRequestParams(String q, String from) {
            this.q = q;
            this.from = from;
        }
    }

    @Test
    public void testObjectParams() throws Exception {
        SearchRequestParams params = new SearchRequestParams("something", "2008");

        MockHttpServletRequestBuilder request = post("/receiveJson")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(params));

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Search: q=something from=2008"));
    }

    @Test
    public void testRawBody() throws Exception {
        String json = getJSON("/data.json");

        MockHttpServletRequestBuilder request = post("/nested-example")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json(json,true));
    }



    private String getJSON(String path) throws Exception {
        URL url = this.getClass().getResource(path);
        return new String(Files.readAllBytes(Paths.get(url.getFile())));
    }




}