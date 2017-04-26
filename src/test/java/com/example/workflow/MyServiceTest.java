package com.example.workflow;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource(properties = {
        "myService.url=https://example1.com1",
        "myService.username=neil1",
        "myService.password=1234"
})
public class MyServiceTest {

    @Autowired
    MyService myService;


    @Test
    public void testconfig() throws Exception
    {

        String url = "https://example1.com1";
        String username="neil1";
        assertThat(myService.getUrlFromConfig(), equalTo( url));
        assertThat(myService.getusernamefromconfig(), equalTo( username));
    }
    }



