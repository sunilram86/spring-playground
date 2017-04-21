package com.example.api;

import com.example.database.LessonRepository;
import com.example.model.Lesson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.Matchers.is;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class LessonsControllerTest {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MockMvc mvc;

    @Autowired
    LessonRepository lessonRepository;

    @Before
    public void setUp() {

        Lesson lesson = new Lesson();
        lesson.setTitle("new title");

        lessonRepository.save(lesson);
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testfindbyID() throws Exception {

        this.mvc.perform(
                        get("/lessons/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is("new title")));
    }



    @Test
    public void testPatchbyID() throws Exception {
        String json = getJSON("/data1.json");

        this.mvc.perform(
                patch("/lessons/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                    .andExpect(jsonPath("$.title", is("new book")));

    }

    @Test
    public void testDeletebyID() throws Exception {

        this.mvc.perform(
                delete("/lessons/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    private String getJSON(String path) throws Exception {
        URL url = this.getClass().getResource(path);
        return new String(Files.readAllBytes(Paths.get(url.getFile())));
    }

}