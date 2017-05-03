package com.example.workflow;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.isNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ZenServiceTest {

    @Autowired
    ZenService zenService;

    @Test
    public void testget() throws Exception {

        String s =zenService.getMessage_simple_url();
        System.out.println(s);
        assertThat(zenService.getMessage_simple_url(), is(notNullValue()));
    }

}