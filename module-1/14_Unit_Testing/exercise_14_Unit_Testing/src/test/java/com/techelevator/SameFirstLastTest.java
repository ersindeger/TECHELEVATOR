package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class SameFirstLastTest {

    private SameFirstLast compareFirstLastNum = new SameFirstLast();

    @Test
    public void testIsItTheSame (){

        Assert.assertTrue(compareFirstLastNum.isItTheSame(new int[]{3,4,8,3}));
        Assert.assertTrue(compareFirstLastNum.isItTheSame(new int[]{1,4,-4,5,1}));
        Assert.assertTrue(compareFirstLastNum.isItTheSame(new int[]{6,100,91, -7, 1,6}));


        Assert.assertFalse(compareFirstLastNum.isItTheSame(new int[]{0,4,8,3}));
        Assert.assertFalse(compareFirstLastNum.isItTheSame(new int[]{5,2,9,11}));
        Assert.assertFalse(compareFirstLastNum.isItTheSame(new int[]{0,2,-7, 81,1}));
        Assert.assertFalse(compareFirstLastNum.isItTheSame(new int[]{7,2,1,3,5,6}));


    }



}
