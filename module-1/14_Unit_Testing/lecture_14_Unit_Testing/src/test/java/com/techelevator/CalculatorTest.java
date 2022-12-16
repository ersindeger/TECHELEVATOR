package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    private Calculator calc;


    @Before
    public void setUp(){
        System.out.println("before");


        //Arrange
        Calculator calc = new Calculator();
    }


    @Test   // don't forget this annotation , cause otherwise you cannot run the test....
    public void sample_test_that_tests_nothing(){
//        Assert.assertFalse(4>7); // test passes if this assertion is false.
    }

    @Test   // don't forget this annotation , cause otherwise you cannot run the test....
    public void another_sample_test_that_tests_nothing(){
//        Assert.fail(); //automatically fails the test...
    }

    @Test
    public void test_adding_two_ints() {
        System.out.println("testing going on");



        //Arrange
        Calculator calc = new Calculator();

        //Act & Assert
        Assert.assertEquals(4, calc.add(2, 2));
        Assert.assertEquals(-6, calc.add(-8, 2));
        Assert.assertEquals(-13, calc.add(-9, -4));
        Assert.assertEquals(2, calc.add(-9, 11));
    }

    public void test_A_greaterThan_B () {

        System.out.println("testing going onnnn");

        //Arrange
        Calculator calc = new Calculator();

        //Act and Assert
        Assert.assertTrue(calc.isAGreaterThanB(7,3));

        Assert.assertFalse(calc.isAGreaterThanB(-7,3));
    }




}


