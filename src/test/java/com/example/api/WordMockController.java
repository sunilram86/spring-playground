package com.example.api;

import com.example.workflow.WordCounter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyMap;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@WebMvcTest(WordController.class)

public class WordMockController {

    @MockBean
    WordCounter wordCounter;
    @Autowired
    MockMvc mvc;
    @Before
    public void setup() {
        when(wordCounter.count(anyString())).thenReturn(anyMap());
    }

    @Test
    public void testcontroller() throws Exception

    {
        String text = "Hello Sunil";
        this.mvc.perform(
                post("/words/count")
                        .content(text)
                        .contentType(MediaType.TEXT_PLAIN))
                        .andExpect(any());

    }
}
