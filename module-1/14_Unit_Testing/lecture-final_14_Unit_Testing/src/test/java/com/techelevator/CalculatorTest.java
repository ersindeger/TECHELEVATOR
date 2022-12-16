package com.techelevator;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    private Calculator calc;

    @Before
    public void setup() {
        System.out.println("Before");

        //Arrange
        calc = new Calculator();
    }

    @Test
    public void test_adding_two_ints () {

        System.out.println("Test");
        //Act and Assert
        Assert.assertEquals(4, calc.add(2,2));
        Assert.assertEquals(0, calc.add(0,0));
        Assert.assertEquals(10, calc.add(6,4));
        Assert.assertEquals(-2, calc.add(-6,4));
        Assert.assertEquals(2, calc.add(6,-4));
        Assert.assertEquals(-10, calc.add(-6,-4));

    }

    @Test
    public void test_A_greaterThan_B () {

        System.out.println("Test");
        //Act and Assert
        Assert.assertTrue(calc.isAGreaterThanB(7,3));

        Assert.assertFalse(calc.isAGreaterThanB(2,9));


    }

    @Test
    public void test_fizzbuzz() {

        //test to see of fizzbuzz works for only numbers divisible by 3
        Assert.assertEquals("fizz", calc.fizzBuzz(3));
        Assert.assertEquals("fizz", calc.fizzBuzz(6));
        Assert.assertEquals("fizz", calc.fizzBuzz(27));

        //test to see of fizzbuzz works for only numbers divisible by 5
        Assert.assertEquals("buzz", calc.fizzBuzz(5));
        Assert.assertEquals("buzz", calc.fizzBuzz(10));
        Assert.assertEquals("buzz", calc.fizzBuzz(95));

        //test to see of fizzbuzz works for only numbers divisible 3 and 5
        Assert.assertEquals("fizzbuzz", calc.fizzBuzz(15));
        Assert.assertEquals("fizzbuzz", calc.fizzBuzz(30));
        Assert.assertEquals("fizzbuzz", calc.fizzBuzz(45));

        //test to see of fizzbuzz works for only numbers not divisible by 3 and 5
        Assert.assertEquals("1", calc.fizzBuzz(1));
        Assert.assertEquals("2", calc.fizzBuzz(2));
        Assert.assertEquals("8", calc.fizzBuzz(8));

    }

    @Test
    public void test_fizzbuzz_divisible_only_by_three() {

        Assert.assertEquals("fizz", calc.fizzBuzz(3));
        Assert.assertEquals("fizz", calc.fizzBuzz(6));
        Assert.assertEquals("fizz", calc.fizzBuzz(27));

    }

    @Test
    public void test_fizzbuzz_divisible_only_by_five() {

        Assert.assertEquals("buzz", calc.fizzBuzz(5));
        Assert.assertEquals("buzz", calc.fizzBuzz(10));
        Assert.assertEquals("buzz", calc.fizzBuzz(95));

    }

    @Test
    public void test_fizzbuzz_divisible_by_three_five() {

        Assert.assertEquals("fizzbuzz", calc.fizzBuzz(15));
        Assert.assertEquals("fizzbuzz", calc.fizzBuzz(30));
        Assert.assertEquals("fizzbuzz", calc.fizzBuzz(45));

    }

    @Test
    public void test_fizzbuzz_not_divisible_by_three_and_or_five() {

        Assert.assertEquals("1", calc.fizzBuzz(1));
        Assert.assertEquals("2", calc.fizzBuzz(2));
        Assert.assertEquals("8", calc.fizzBuzz(8));

    }

    @Test
    public void test_add_wrapped_objects() {

        //arrange
        WrappedNumbers set_of_numbers1 = new WrappedNumbers(5,5);

        //act
        Result resultOne = calc.add(set_of_numbers1);

        //assert
        Assert.assertEquals(10, resultOne.getResult());

    }




    @After
    public void teardown() {
        System.out.println("After");
    }



}

