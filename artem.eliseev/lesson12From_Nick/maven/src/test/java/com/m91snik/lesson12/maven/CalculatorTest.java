package com.m91snik.lesson12.maven;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by m91snik on 23.08.15.
 */
public class CalculatorTest {

    @Test
    public void testSumOfZeroes() throws Exception {
        Assert.assertEquals(0, new Calculator().sum(0, 0));
    }

    @Test
    public void testSum() throws Exception {
        Assert.assertEquals(5, new Calculator().sum(2, 3));
    }

    @Test(expected = ArithmeticException.class)
    public void testDiv() throws Exception {
        new Calculator().div(2, 0);
    }
}