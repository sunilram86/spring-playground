package com.example.workflow;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static java.util.Arrays.asList;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MyNewServiceTest {
    @Autowired
    MyNewService myService;


    @Test
    public void testconfigList() throws Exception
    {

        assertThat(myService.getFilterWords(), equalTo( asList("the","an","a")));
    }

    @Test
    public void testconfigBoolean() throws Exception
    {

        Boolean value=false;
        assertThat(myService.getCaseSensitive(), equalTo( value));
    }
}