package com.example.workflow;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ServiceTest {

    @Autowired
    WordCounter wordCounter;

    @Test
    public void testShouldWork() {

        Map<String, Integer> expected = new LinkedHashMap<>();
        expected.put("sunil", 1);
        expected.put("anil", 2);


        assertThat(wordCounter.count("sunil anil"), equalTo( expected));
    }
}