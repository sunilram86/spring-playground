package com.example.api;

import com.example.Wordconfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest({Wordconfiguration.class, WordController.class})
public class WordControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void testcountWordswithcomma() throws Exception
    {

        String s = "Hello subbu, rubbu rubbu Hello";

        this.mvc.perform(
                post("/words/count")
                        .content(s)
                        .contentType(MediaType.TEXT_PLAIN))
                .andExpect(jsonPath("$.Hello", is(1)));

    }

}