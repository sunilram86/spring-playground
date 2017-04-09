package com.example.workflow;

import org.junit.Test;


import static org.junit.Assert.*;



public class MathServiceTest {

    private  MathService mathService=new MathService();

    @Test
    public void testcalculateAdd() throws Exception {
       String result= mathService.calculate("add",3,4);
        assertEquals("7", result);
    }

    @Test
    public void testcalculateSubtract() throws Exception {
        String result= mathService.calculate("subtract",6,4);
        assertEquals("2", result);
    }

    @Test
    public void testcalculateDivide() throws Exception {
        String result= mathService.calculate("divide",6,3);
        assertEquals("2", result);
    }

    @Test
    public void testcalculateNoOperation() throws Exception {
        String result= mathService.calculate(null,6,3);
        assertEquals("9", result);
    }
}