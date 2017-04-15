package com.example.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(JsonResponseController.class)
public class JsonResponseControllerTest {
    @Autowired
    private MockMvc mvc;

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

}