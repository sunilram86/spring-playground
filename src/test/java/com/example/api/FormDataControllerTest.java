package com.example.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.Random;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@RunWith(SpringRunner.class)
@WebMvcTest(FormDataController.class)
@AutoConfigureMockMvc(secure=false)

public class FormDataControllerTest {
    @Autowired
    private MockMvc mvc;
    private Object Dwayne;

    @Test
    public void testCreateComment() throws Exception {
        String content = String.valueOf(2);

        MockHttpServletRequestBuilder request1 = post("/comments")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("content", content)
                .param("author", "Dwayne");

         this.mvc.perform(request1)
                .andExpect(status().isOk())
                .andExpect(content().string("{content=2, author=Dwayne}"));
    }

    @Test
    public void testgetRawString() throws Exception {
        String content = "hello";

        this.mvc.perform(
                 post("/string-example")
                .contentType(MediaType.TEXT_PLAIN)
                         .content("hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));
    }


}
