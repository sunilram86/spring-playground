package com.example.api;

import com.example.api.EndpointsController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EndpointsController.class)
public class EndpointsControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testIndexEndpoint() throws Exception {
        this.mvc.perform(get("/index").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("GET to index route"));
    }

    @Test
    public void testGetTasks() throws Exception {
        this.mvc.perform(get("/tasks").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("These are tasks"));
    }

    @Test
    public void testCreateTask() throws Exception {
        this.mvc.perform(post("/tasks").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("You just POSTed to /tasks"));
    }

    @Test
    public void testGetPiValue() throws Exception {
        this.mvc.perform(get("/math/pi").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("3.141592653589793"));
    }

    @Test
    public void testGetCalculateWithNoOperation() throws Exception {
        this.mvc.perform(get("/math/calculate/?x=30&y=5").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("35"));
    }

    @Test
    public void testGetCalculateAdd() throws Exception {
        this.mvc.perform(get("/math/calculate/?operation=add&x=30&y=5").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("35"));
    }


    @Test
    public void testGetCalculateMultiply() throws Exception {
        this.mvc.perform(get("/math/calculate/?operation=multiply&x=30&y=5").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("150"));
    }

    @Test
    public void testPostcalculateSum() throws Exception {
        this.mvc.perform(post("/math/sum?n=4&n=6&n=8").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("18"));
    }

    @Test
    public void testgetCommentsForTask() throws Exception {
        int taskId=4;
        int commentId=5;
        this.mvc.perform(get(String.format("/tasks/%d/comments/%d", taskId,commentId)))
                .andExpect(status().isOk())
                .andExpect(content().string("taskId is 4; commentId is 5"));

    }

    @Test
    public void testGetcalculateRectangleVolume() throws Exception {
        int height=4;
        int width=5;
        int length=3;
        this.mvc.perform(get(String.format("/math/volume/%d/%d/%d",length,width,height)))
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 3x5x4 rectangle is 60"));

    }

    @Test
    public void testPostcalculateRectangleVolume() throws Exception {
        int height=4;
        int width=5;
        int length=3;
        this.mvc.perform(post(String.format("/math/volume/%d/%d/%d",length,width,height)))
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 3x5x4 rectangle is 60"));

    }

    @Test
    public void testcalculateCircleArea() throws Exception {
        String type = "circle";
        int radius=4;

        MockHttpServletRequestBuilder request1 = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", type)
                .param("radius", String.valueOf(radius));

        this.mvc.perform(request1)
                .andExpect(status().isOk())
                .andExpect(content().string("Area of a circle with a radius of 4 is 50.26548245743669"));

    }

    @Test
    public void testcalculateCircleAreaInvalid() throws Exception {
        String type = "circle";
        int length=4;

        MockHttpServletRequestBuilder request1 = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", type)
                .param("length", String.valueOf(length));

        this.mvc.perform(request1)
                .andExpect(status().isOk())
                .andExpect(content().string("Invalid"));

    }

    @Test
    public void testcalculateRectangleArea() throws Exception {
        String type = "rectangle";
        int width=4;
        int height=5;

        MockHttpServletRequestBuilder request1 = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", type)
                .param("width", String.valueOf(width))
                .param("height", String.valueOf(height));

        this.mvc.perform(request1)
                .andExpect(status().isOk())
                .andExpect(content().string("Area of a 4x5 rectangle is 20"));

    }

    @Test
    public void testcalculateRectangleAreaInvalid() throws Exception {
        String type = "rectangle";
        int radius=4;
        int height=5;


        MockHttpServletRequestBuilder request1 = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", type)
                .param("radius", String.valueOf(radius))
                .param("height",String.valueOf(height));

        this.mvc.perform(request1)
                .andExpect(status().isOk())
                .andExpect(content().string("Invalid"));

    }


}