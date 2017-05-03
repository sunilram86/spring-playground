package com.example.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest public class WordControllerTest {

    @Autowired
    WordController wordController;



    @Test
    public void testcountWordswithcomma() throws Exception
    {
        Map<String, Integer> expected = new LinkedHashMap<>();
        expected.put("hello", 1);
        expected.put("rama", 1);
        expected.put("sunny",2);
        expected.put("money",2);

        assertThat(wordController.countWords("hello RAMA The sunny a sunny money money the"), equalTo(expected));


    }

}